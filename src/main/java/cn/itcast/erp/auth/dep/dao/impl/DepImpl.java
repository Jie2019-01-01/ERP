package cn.itcast.erp.auth.dep.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.auth.dep.dao.dao.DepDao;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class DepImpl extends BaseImpl<DepModel> implements DepDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		DepQueryModel dqm = (DepQueryModel) bqm;
		if(dqm.getDepName()!=null && dqm.getDepName().trim().length()>0) {
			dc.add(Restrictions.like("depName", "%"+dqm.getDepName().trim()+"%"));
		}
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0) {
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
	}
}
