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
		// 订单状态
		if(oqm.getStatus()!=null && oqm.getStatus()!=-1) {
			dc.add(Restrictions.eq("status", oqm.getStatus()));
		}
		// 下单人
		if(oqm.getCreater()!=null && oqm.getCreater().getRealName()!=null 
				&& oqm.getCreater().getRealName().trim().length()>0) {
			dc.createAlias("creater", "c1");
			dc.add(Restrictions.like("c1.realName", "%"+oqm.getCreater().getRealName().trim()+"%"));
		}
		// 总数量范围
		if(oqm.getTotalCount()!=null) {
			dc.add(Restrictions.ge("totalCount", oqm.getTotalCount()));
		}
		if(oqm.getMaxTotalCount()!=null) {
			dc.add(Restrictions.le("totalCount", oqm.getMaxTotalCount()));
		}
		// 总价格范围
		if(oqm.getTotalPrice()!=null) {
			dc.add(Restrictions.ge("totalPrice", oqm.getTotalPrice()));
		}
		if(oqm.getMaxTotalPrice()!=null) {
			dc.add(Restrictions.le("totalPrice", oqm.getMaxTotalPrice()));
		}
		// 时间范围
		if(oqm.getCreateTime()!=null) {
			dc.add(Restrictions.ge("createTime", oqm.getCreateTime()));
		}
		if(oqm.getMaxCreateTime()!=null) {
			// 每天毫秒
			Long dayMills = 24*60*60*1000L;
			dc.add(Restrictions.le("createTime", oqm.getMaxCreateTime()+dayMills-1));
		}
	}

}