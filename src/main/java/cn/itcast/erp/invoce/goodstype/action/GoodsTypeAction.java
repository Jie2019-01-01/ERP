package cn.itcast.erp.invoce.goodstype.action;

import java.util.List;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeQueryModel;
import cn.itcast.erp.invoce.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseAction;

public class GoodsTypeAction extends BaseAction{

	private GoodsTypeEbi goodsTypeEbi;
	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {this.goodsTypeEbi = goodsTypeEbi;}
	private SupplierEbi supplierEbi;
	public void setSupplierEbi(SupplierEbi supplierEbi) {this.supplierEbi = supplierEbi;}

	public GoodsTypeModel gm = new GoodsTypeModel();
	public GoodsTypeQueryModel gqm = new GoodsTypeQueryModel();

	public String list() {
		setRecords(goodsTypeEbi.getCount(gqm));
		List<GoodsTypeModel> goodsTypeList = goodsTypeEbi.list(gqm, curPage, pageCount);
		put("goodsTypeList", goodsTypeList);
		List<SupplierModel> supplierList = supplierEbi.list();
		put("supplierList", supplierList);
		return "list";
	}

	public String input() {
		List<SupplierModel> supplierList = supplierEbi.list();
		put("supplierList", supplierList);
		if(gm.getUuid()!=null) {
			gm = goodsTypeEbi.getByUuid(gm.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(gm.getUuid()!=null) {
			goodsTypeEbi.update(gm);
		}else {
			goodsTypeEbi.save(gm);
		}
		return "toList";
	}

	public String delete() {
		goodsTypeEbi.delete(gm);
		return "toList";
	}

}