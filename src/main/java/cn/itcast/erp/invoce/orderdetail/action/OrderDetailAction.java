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
	public OrderDetailModel getOm() {return om;}
	public OrderDetailQueryModel oqm = new OrderDetailQueryModel();
	
	public String inList() {
		setRecords(orderDetailEbi.getCount(oqm));
		List<OrderDetailModel> orderDetailList = orderDetailEbi.list(oqm, curPage, pageCount);
		put("orderDetailList", orderDetailList);
		return "inList";
	}
	
	// --------------ajax----------------------------
	
	// 根据订单uuid获取该订单的剩余入库数量
	public String ajaxGetSurplueByOmUuid() {
		om = orderDetailEbi.getByUuid(om.getUuid());
		return "ajaxGetSurplueByOmUuid";
	}

}