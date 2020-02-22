package cn.itcast.erp.invoce.supplier.action;

import java.util.List;
import cn.itcast.erp.invoce.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.invoce.supplier.vo.SupplierQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class SupplierAction extends BaseAction{

	private SupplierEbi supplierEbi;
	public void setSupplierEbi(SupplierEbi supplierEbi) {this.supplierEbi = supplierEbi;}

	public SupplierModel sm = new SupplierModel();
	public SupplierQueryModel sqm = new SupplierQueryModel();

	public String list() {
		setRecords(supplierEbi.getCount(sqm));
		List<SupplierModel> supplierList = supplierEbi.list(sqm, curPage, pageCount);
		put("supplierList", supplierList);
		return "list";
	}

	public String input() {
		if(sm.getUuid()!=null) {
			sm = supplierEbi.getByUuid(sm.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(sm.getUuid()!=null) {
			supplierEbi.update(sm);
		}else {
			supplierEbi.save(sm);
		}
		return "toList";
	}

	public String delete() {
		supplierEbi.delete(sm);
		return "toList";
	}

}