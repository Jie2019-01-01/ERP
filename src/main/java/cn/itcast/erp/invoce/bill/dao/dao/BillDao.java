package cn.itcast.erp.invoce.bill.dao.dao;

import java.util.List;

import cn.itcast.erp.invoce.bill.vo.BillQueryModel;

public interface BillDao {

	/**
	 * 查询商品采购报表
	 * @param bqm
	 * @return
	 */
	public List<Object> buyBills(BillQueryModel bqm);

}