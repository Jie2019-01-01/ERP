package cn.itcast.erp.invoce.orderdetail.action;

import java.util.List;
import cn.itcast.erp.invoce.orderdetail.business.ebi.OrderDetailEbi;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class OrderDetailAction extends BaseAction{

	private OrderDetailEbi orderDetailEbi;
	public void setOrderDetailEbi(OrderDetailEbi orderDetailEbi) {this.orderDetailEbi = orderDetailEbi;}

	public OrderDetailModel om = new OrderDetailModel();
	public OrderDetailQueryModel oqm = new OrderDetailQueryModel();

	public String list() {
		setRecords(orderDetailEbi.getCount(oqm));
		List<OrderDetailModel> orderDetailList = orderDetailEbi.list(oqm, curPage, pageCount);
		put("orderDetailList", orderDetailList);
		return "list";
	}

	public String input() {
		if(om.getUuid()!=null) {
			om = orderDetailEbi.getByUuid(om.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(om.getUuid()!=null) {
			orderDetailEbi.update(om);
		}else {
			orderDetailEbi.save(om);
		}
		return "toList";
	}

	public String delete() {
		orderDetailEbi.delete(om);
		return "toList";
	}

}