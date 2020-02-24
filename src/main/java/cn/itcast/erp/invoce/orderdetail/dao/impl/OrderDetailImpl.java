package cn.itcast.erp.invoce.orderdetail.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import cn.itcast.erp.invoce.orderdetail.dao.dao.OrderDetailDao;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class OrderDetailImpl extends BaseImpl<OrderDetailModel> implements OrderDetailDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		//TODO:自定义查询条件
	}

}