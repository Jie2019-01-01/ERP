package cn.itcast.erp.auth.dep.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.erp.auth.dep.dao.dao.DepDao;
import cn.itcast.erp.auth.dep.vo.DepModel;

public class DepImpl extends HibernateDaoSupport implements DepDao {

	public List<DepModel> list() {
		String hql = "from DepModel";
		return this.getHibernateTemplate().find(hql);
	}

	public void save(DepModel dm) {
		this.getHibernateTemplate().save(dm);
	}

	public void update(DepModel dm) {
		this.getHibernateTemplate().update(dm);
	}

	public DepModel getByUuid(Long uuid) {
		return this.getHibernateTemplate().get(DepModel.class, uuid);
	}

	public void delete(DepModel dm) {
		this.getHibernateTemplate().delete(dm);
	}

}
