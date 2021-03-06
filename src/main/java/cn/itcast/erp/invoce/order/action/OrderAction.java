package cn.itcast.erp.invoce.order.action;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.invoce.goods.business.ebi.GoodsEbi;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.invoce.order.business.ebi.OrderEbi;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.invoce.store.business.ebi.StoreEbi;
import cn.itcast.erp.invoce.store.vo.StoreModel;
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
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {this.empEbi = empEbi;}
	private StoreEbi storeEbi;
	public void setStoreEbi(StoreEbi storeEbi) {this.storeEbi = storeEbi;}

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
		List<SupplierModel> supplierList = supplierEbi.getNotNullAndGtm();
		put("supplierList", supplierList);
		List<GoodsTypeModel> gtmList = goodsTypeEbi.getNotNullBySupplier(supplierList.get(0).getUuid());
		put("gtmList", gtmList);
		List<GoodsModel> gmList = goodsEbi.getByGtm(gtmList.get(0).getUuid());
		put("gmList", gmList);
		return "inInput";
	}
	
	// 采购审核列表
	public String inCheckList() {
		oqm.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		Integer rescords = orderEbi.getCount(oqm);
		setRecords(rescords);
		// 获取所有采购订单
		List<OrderModel> orderList = orderEbi.inList(oqm, curPage, pageCount);
		put("orderList", orderList);
		return "inCheckList";
	}
	// 采购审核操作界面
	public String inCheck() {
		om = orderEbi.getByUuid(om.getUuid());
		return "inCheck";
	}
	// 审核通过
	public String inCheckPass() {
		orderEbi.inCheckPass(om.getUuid(), getLoginEm());
		return "inCheckPass";
	}
	// 审核未通过
	public String inCheckNoPass() {
		orderEbi.inCheckNoPass(om.getUuid(), getLoginEm());
		return "inCheckNoPass";
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
	
	//------------------运输任务-------------------------
	public String taskList() {
		Integer records = orderEbi.getTaskCount(oqm);
		setRecords(records);
		List<OrderModel> orderList = orderEbi.getTaskList(oqm, curPage, pageCount);
		put("orderList", orderList);
		// 供应商列表
		List<SupplierModel> suppliserList = supplierEbi.list();
		put("suppliserList", suppliserList);
		return "taskList";
	}
	
	// 任务指派操作页面
	public String assignTask() {
		// 根据uuid查询订单
		om = orderEbi.getByUuid(om.getUuid());
		// 查询运输部门的人员
		List<EmpModel> empList = empEbi.getByDep(getLoginEm().getDm().getUuid());
		put("empList", empList);
		return "assignTask";
	}
	// 指派任务人
	public Long completerUuid;
	public String assignTaskMan() {
		// 获取跟单人
		EmpModel em = empEbi.getByUuid(completerUuid);
		orderEbi.assignTaskMan(om.getUuid(), em);
		return "assignTaskMan";
	}
	//----------------任务查询----------------------
	public String queryList() {
		Integer records = orderEbi.getQueryTaskCount(oqm, getLoginEm());
		setRecords(records);
		List<OrderModel> orderList = orderEbi.queryTaskList(oqm, curPage, pageCount, getLoginEm());
		put("orderList", orderList);
		return "queryList";
	}
	public String queryDetail() {
		om = orderEbi.getByUuid(om.getUuid());
		return "queryDetail";
	}
	// 结单
	public String endTask() {
		orderEbi.endTask(om.getUuid());
		return "toQueryList";
	}
	
	// ----------------仓库------------
	public String storeInList() {
		Integer records = orderEbi.inStoreCount(oqm);
		setRecords(records);
		List<OrderModel> orderList = orderEbi.inStoreList(oqm, curPage, pageCount);
		put("orderList", orderList);
		return "storeInList";
	}
	public String storeInDetail() {
		om = orderEbi.inStoreDetail(om.getUuid());
		// 加载所有仓库信息
		List<StoreModel> storeList = storeEbi.list();
		put("storeList", storeList);
		return "storeInDetail";
	}
	// 入库
	public Long odmUuid;
	public Integer inNum;
	public Long storeUuid;
	
	private OrderDetailModel odm;
	public OrderDetailModel getOdm() {return odm;}
	public String inStore() {
		odm = orderEbi.inGoods(odmUuid, inNum, storeUuid, getLoginEm());
		return "inStore";
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