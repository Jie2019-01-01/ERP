package cn.itcast.erp.invoce.bill.business.ebo;

import java.util.List;

import cn.itcast.erp.invoce.bill.business.ebi.BillEbi;
import cn.itcast.erp.invoce.bill.dao.dao.BillDao;
import cn.itcast.erp.invoce.bill.vo.BillQueryModel;
import cn.itcast.erp.invoce.order.vo.OrderModel;

public class BillEbo implements BillEbi {

	private BillDao billDao;
	public void setBillDao(BillDao billDao) {this.billDao = billDao;}
	
	public List<Object> buyBills(BillQueryModel bqm) {
		bqm.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		return billDao.buyBills(bqm);
	}

}