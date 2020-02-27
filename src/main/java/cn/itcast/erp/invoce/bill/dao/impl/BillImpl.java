package cn.itcast.erp.invoce.bill.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.erp.invoce.bill.dao.dao.BillDao;
import cn.itcast.erp.invoce.bill.vo.BillQueryModel;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;

public class BillImpl extends HibernateDaoSupport implements BillDao {

	public List<Object> buyBills(BillQueryModel bqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderDetailModel.class);
		// 查询条件
		if(bqm.getOrderType()!=null && bqm.getOrderType()!=-1) {
			dc.add(Restrictions.eq("orderType", bqm.getOrderType()));
		}
		if(bqm.getSupplierUuid()!=null && bqm.getSupplierUuid()!=-1) {
			dc.createAlias("gm", "");
			dc.add(Restrictions.eq("", bqm.getSupplierUuid()));
		}
		// 投影查询
		ProjectionList pList = Projections.projectionList();
		// 按商品分组
		pList.add(Projections.groupProperty("gm"));
		// 总数
		pList.add(Projections.sum("buyCount"));
		dc.setProjection(pList);
		return this.getHibernateTemplate().findByCriteria(dc);
	}

}