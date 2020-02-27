package cn.itcast.erp.invoce.bill.action;

import cn.itcast.erp.invoce.bill.business.ebi.BillEbi;
import cn.itcast.erp.invoce.bill.vo.BillQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class BillAction extends BaseAction{

	private BillEbi billEbi;
	public void setBillEbi(BillEbi billEbi) {this.billEbi = billEbi;}

	public BillQueryModel bqm = new BillQueryModel();

	public String buyBillList() {
	
		return "buyBillList";
	}
}