package cn.itcast.erp.invoce.order.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.invoce.order.dao.dao.OrderDao;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class OrderImpl extends BaseImpl<OrderModel> implements OrderDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		OrderQueryModel oqm = (OrderQueryModel) bqm;
		// 订单类型
		if(oqm.getOrderType()!=null && oqm.getOrderType()!=-1) {
			dc.add(Restrictions.eq("orderType", oqm.getOrderType()));
		}
	}

}