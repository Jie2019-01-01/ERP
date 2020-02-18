package cn.itcast.erp.auth.dep.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.erp.auth.dep.dao.dao.DepDao;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;

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

	public Integer getCount() {
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		dc.setProjection(Projections.rowCount());
		List<Long> depList = this.getHibernateTemplate().findByCriteria(dc);
		return depList.get(0).intValue();
	}

	public List<DepModel> list(Integer curPage, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		return this.getHibernateTemplate().findByCriteria(dc, (curPage-1)*pageCount, pageCount);
	}

	public List<DepModel> list(DepQueryModel dqm, Integer curPage, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		doQbc(dc, dqm);
		return this.getHibernateTemplate().findByCriteria(dc, (curPage-1)*pageCount, pageCount);
	}

	public Integer getCount(DepQueryModel dqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		doQbc(dc, dqm);
		dc.setProjection(Projections.rowCount());
		List<Long> depList = this.getHibernateTemplate().findByCriteria(dc);
		return depList.get(0).intValue();
	}
	
	// 自定义查询条件
	private void doQbc(DetachedCriteria dc, DepQueryModel dqm) {
		if(dqm.getDepName()!=null && dqm.getDepName().trim().length()>0) {
			dc.add(Restrictions.like("depName", "%"+dqm.getDepName().trim()+"%"));
		}
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0) {
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
	}

}
