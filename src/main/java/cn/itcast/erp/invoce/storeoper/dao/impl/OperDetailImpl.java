package cn.itcast.erp.invoce.storeoper.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import cn.itcast.erp.invoce.storeoper.dao.dao.OperDetailDao;
import cn.itcast.erp.invoce.storeoper.vo.OperDetailModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class OperDetailImpl extends BaseImpl<OperDetailModel> implements OperDetailDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		//TODO:自定义查询条件
	}

}