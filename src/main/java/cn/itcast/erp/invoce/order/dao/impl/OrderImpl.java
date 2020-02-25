package cn.itcast.erp.invoce.order.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
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
		// 审核人
		if(oqm.getChecker()!=null && oqm.getChecker().getRealName()!=null 
			&& oqm.getChecker().getRealName().trim().length()>0) {
			dc.createAlias("checker", "c2");
			dc.add(Restrictions.like("c2.realName", "%"+oqm.getChecker().getRealName().trim()+"%"));
		}
		// 跟单人
		if(oqm.getCompleter()!=null && oqm.getCompleter().getRealName()!=null 
				&& oqm.getCompleter().getRealName().trim().length()>0) {
			dc.createAlias("completer", "c3");
			dc.add(Restrictions.like("c3.realName", "%"+oqm.getCompleter().getRealName()+"%"));
		}
		if(oqm.getCompleter()!=null && oqm.getCompleter().getUuid()!=null 
				&& oqm.getCompleter().getUuid()!=-1) {
			dc.add(Restrictions.eq("completer", oqm.getCompleter()));
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
		Long dayMills = 24*60*60*1000L;
		if(oqm.getCreateTime()!=null) {
			dc.add(Restrictions.ge("createTime", oqm.getCreateTime()));
		}
		if(oqm.getMaxCreateTime()!=null) {
			dc.add(Restrictions.le("createTime", oqm.getMaxCreateTime()+dayMills-1));
		}
		if(oqm.getCheckTime()!=null) {
			dc.add(Restrictions.ge("checkTime", oqm.getCheckTime()));
		}
		if(oqm.getMaxCheckTime()!=null) {
			dc.add(Restrictions.le("checkTime", oqm.getMaxCheckTime()+dayMills-1));
		}
		// 供应商
		if(oqm.getSm()!=null && oqm.getSm().getUuid()!=null 
				&& oqm.getSm().getUuid()!=-1) {
			dc.add(Restrictions.eq("sm", oqm.getSm()));
		}
		// 发货方式
		if(oqm.getSm()!=null && oqm.getSm().getPattern()!=null 
				&& oqm.getSm().getPattern()!=-1) {
			dc.createAlias("sm", "s");
			dc.add(Restrictions.eq("s.pattern", oqm.getSm().getPattern()));
		}
		
	}

	// 运输任务自定义查询条件
	private void doQbcTask(DetachedCriteria dc, OrderQueryModel oqm, Integer[] statuses) {
		dc.add(Restrictions.in("status", statuses));
		doQbc(dc, oqm);
	}
	public Integer getTaskCount(OrderQueryModel oqm, Integer[] statuses) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		dc.setProjection(Projections.rowCount());
		doQbcTask(dc, oqm, statuses);
		List<Long> list = this.getHibernateTemplate().findByCriteria(dc); 
		return list.get(0).intValue();
	}
	public List<OrderModel> getTaskList(OrderQueryModel oqm, Integer curPage, 
			Integer pageCount, Integer[] statuses) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		doQbcTask(dc, oqm, statuses);
		return this.getHibernateTemplate().findByCriteria(dc);
	}

}