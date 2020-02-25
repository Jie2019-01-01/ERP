package cn.itcast.erp.invoce.order.action;

import java.util.ArrayList;
import java.util.List;
import cn.itcast.erp.invoce.goods.business.ebi.GoodsEbi;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.invoce.order.business.ebi.OrderEbi;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.invoce.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseAction;

public class OrderAction extends BaseAction{

	private OrderEbi orderEbi;
	public void setOrderEbi(OrderEbi orderEbi) {this.orderEbi = orderEbi;}
	private SupplierEbi supplierEbi;
	public void setSupplierEbi(SupplierEbi supplierEbi) {this.supplierEbi = supplierEbi;}
	private GoodsTypeEbi goodsTypeEbi;
	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {this.goodsTypeEbi = goodsTypeEbi;}
	private GoodsEbi goodsEbi;
	public void setGoodsEbi(GoodsEbi goodsEbi) {this.goodsEbi = goodsEbi;}

	public OrderModel om = new OrderModel();
	public OrderQueryModel oqm = new OrderQueryModel();

	public String inList() {
		oqm.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		setRecords(orderEbi.getCount(oqm));
		List<OrderModel> orderList = orderEbi.inList(oqm, curPage, pageCount);
		put("orderList", orderList);
		
		return "inList";
	}
	
	public String inDetailList() {
		// 根据uuid查询订单
		om = orderEbi.getByUuid(om.getUuid());
		return "inDetailList";
	}

	public String inInput() {
//		if(om.getUuid()!=null) {
//			om = orderEbi.getByUuid(om.getUuid());
//		}
		List<SupplierModel> supplierList = supplierEbi.getNotNullAndGtm();
		put("supplierList", supplierList);
		List<GoodsTypeModel> gtmList = goodsTypeEbi.getNotNullBySupplier(supplierList.get(0).getUuid());
		put("gtmList", gtmList);
		List<GoodsModel> gmList = goodsEbi.getByGtm(gtmList.get(0).getUuid());
		put("gmList", gmList);
		return "inInput";
	}

	public Long[] goodsUuids;
	public Integer[] nums;
	public Double[] prices;
	public String inSave() {
		orderEbi.inSave(getLoginEm(), om, goodsUuids, nums, prices);
		return "toInList";
	}

	public String delete() {
		orderEbi.delete(om);
		return "toList";
	}

	// -------------ajax--------------------
	public Long supplierUuid;
	private List<GoodsTypeModel> gtmList;
	public List<GoodsTypeModel> getGtmList() {return gtmList;}
	private List<GoodsModel> gmList;
	public List<GoodsModel> getGmList() {return gmList;}

	// 通过供应商uuid获取类别集合，以及集合中的第一个类别下的所有商品
	public String ajaxGetGtmBySm() {
		gtmList = goodsTypeEbi.getNotNullBySupplier(supplierUuid);
		gmList = goodsEbi.getByGtm(gtmList.get(0).getUuid());
		return "ajaxGetGtmBySm";
	}
	
	public Long gtmUuid;
	// 通过类别uuid获取商品集合
	public String ajaxGetGmByGtm() {
		gmList = goodsEbi.getByGtm(gtmUuid);
		for(int i=gmList.size()-1; i>=0; i--) {
			if(used.contains(gmList.get(i).getUuid()+",")) {
				gmList.remove(i);
			}
		}
		return "ajaxGetGmByGtm";
	}
	
	public Long goodsUuid;
	private GoodsModel gm;
	public GoodsModel getGm() {return gm;}
	// 通过商品uuid获取对应的数据
	public String ajaxGetGmByUuid() {
		gm = goodsEbi.getByUuid(goodsUuid);
		return "ajaxGetGmByUuid";
	}
	
	public String used;
	public String ajaxGetGtmAndGm() {
		// 获取的是1,2,3,这样包含商品uuid的字符串
		// 将字符串分割，放到集合中
		List<Long> gmUuids = new ArrayList<Long>();
		if(used!=null) {
			String[] uuids = used.split(",");
			for(int i=0; i<uuids.length; i++) {
				gmUuids.add(new Long(uuids[i]));
			}
		}
		gtmList = goodsTypeEbi.getBySupplierUnion(supplierUuid, gmUuids);
		// 过滤商品信息
		if(gtmList.size()>0) {
			gmList = goodsEbi.getByGtm(gtmList.get(0).getUuid());
			for(int i=gmList.size()-1; i>=0; i--) {
				if(gmUuids.contains(gmList.get(i).getUuid())) {
					gmList.remove(i);
				}
			}
		}
		return "ajaxGetGtmAndGm";
	}
}