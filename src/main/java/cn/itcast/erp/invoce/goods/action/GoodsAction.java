package cn.itcast.erp.invoce.goods.action;

import java.util.List;
import cn.itcast.erp.invoce.goods.business.ebi.GoodsEbi;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.goods.vo.GoodsQueryModel;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.invoce.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseAction;

public class GoodsAction extends BaseAction{

	private GoodsEbi goodsEbi;
	public void setGoodsEbi(GoodsEbi goodsEbi) {this.goodsEbi = goodsEbi;}
	private GoodsTypeEbi goodsTypeEbi;
	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {this.goodsTypeEbi = goodsTypeEbi;}
	private SupplierEbi supplierEbi;
	public void setSupplierEbi(SupplierEbi supplierEbi) {this.supplierEbi = supplierEbi;}

	public GoodsModel gm = new GoodsModel();
	public GoodsQueryModel gqm = new GoodsQueryModel();

	public String list() {
		setRecords(goodsEbi.getCount(gqm));
		List<GoodsModel> goodsList = goodsEbi.list(gqm, curPage, pageCount);
		put("goodsList", goodsList);
		List<SupplierModel> supplierList = supplierEbi.list();
		put("supplierList", supplierList);
		return "list"; 
	}

	public String input() {
		if(gm.getUuid()!=null) {
			gm = goodsEbi.getByUuid(gm.getUuid());
		}
		List<SupplierModel> smList = supplierEbi.getNotNull();
		put("smList", smList);
		List<GoodsTypeModel> gtmList = goodsTypeEbi.getBySupplier(smList.get(0).getUuid());
		put("gtmList", gtmList);
		return "input";
	}

	public String saveOrUpdate() {
		if(gm.getUuid()!=null) {
			goodsEbi.update(gm);
		}else {
			goodsEbi.save(gm);
		}
		return "toList";
	}

	public String delete() {
		goodsEbi.delete(gm);
		return "toList";
	}

	//-------------ajax-----------------------
	public Long supplierUuid;
	public String ajaxGetBySm() {
		gtmList = goodsTypeEbi.getBySupplier(supplierUuid);
		return "ajaxGetBySm";
	}
	
	public List<GoodsTypeModel> gtmList;
	public List<GoodsTypeModel> getGtmList() {return gtmList;}
}