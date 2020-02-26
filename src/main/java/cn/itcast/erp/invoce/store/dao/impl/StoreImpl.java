package cn.itcast.erp.invoce.store.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.invoce.store.dao.dao.StoreDao;
import cn.itcast.erp.invoce.store.vo.StoreModel;
import cn.itcast.erp.invoce.store.vo.StoreQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class StoreImpl extends BaseImpl<StoreModel> implements StoreDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		StoreQueryModel sqm = (StoreQueryModel) bqm;
		if(sqm.getSname()!=null && sqm.getSname().trim().length()>0) {
			dc.add(Restrictions.like("sname", "%"+sqm.getSname().trim()+"%"));
		}
		if(sqm.getEm()!=null && sqm.getEm().getRealName()!=null 
				&& sqm.getEm().getRealName().trim().length()>0) {
			dc.createAlias("em", "e");
			dc.add(Restrictions.like("e.realName", "%"+sqm.getEm().getRealName().trim()+"%"));
		}
	}

}