package cn.itcast.erp.invoce.bill.business.ebi;

import java.util.List;

import cn.itcast.erp.invoce.bill.vo.BillQueryModel;

public interface BillEbi {

	/**
	 * 查询商品采购报表
	 * @param bqm 条件模型
	 * @return
	 */
	public List<Object> buyBills(BillQueryModel bqm);

}