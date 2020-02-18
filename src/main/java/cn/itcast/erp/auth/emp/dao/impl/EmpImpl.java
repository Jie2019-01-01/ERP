package cn.itcast.erp.auth.emp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;

public class EmpImpl extends HibernateDaoSupport implements EmpDao {

	public EmpModel login(String userName, String pwd) {
		String hql = "from EmpModel where userName=? and pwd=?";
		List<EmpModel> empList = this.getHibernateTemplate().find(hql, userName, pwd);
		return empList.size()>0? empList.get(0): null;
	}

	public List<EmpModel> list() {
		String hql = "from EmpModel";
		return this.getHibernateTemplate().find(hql);
	}

	public void save(EmpModel em) {
		this.getHibernateTemplate().save(em);
	}

	public EmpModel getByUuid(Long uuid) {
		String hql = "from EmpModel where uuid=?";
		List<EmpModel> empList = this.getHibernateTemplate().find(hql, uuid);
		return empList.get(0);
	}

	public void delete(EmpModel em) {
		this.getHibernateTemplate().delete(em);
	}

	public List<EmpModel> list(EmpQueryModel eqm, Integer curPage, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		doQbc(dc, eqm);
		List<EmpModel> empList = this.getHibernateTemplate().findByCriteria(dc, (curPage-1)*pageCount, pageCount);
		return empList;
	}

	public Integer getCount(EmpQueryModel eqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		dc.setProjection(Projections.rowCount());
		doQbc(dc, eqm);
		List<Long> empList = this.getHibernateTemplate().findByCriteria(dc);
		return empList.get(0).intValue();
	}
	
	public void doQbc(DetachedCriteria dc, EmpQueryModel eqm) {
		if(eqm.getUserName()!=null && eqm.getUserName().trim().length()>0) {
			dc.add(Restrictions.like("userName", "%"+eqm.getUserName().trim()+"%"));
		}
		if(eqm.getRealName()!=null && eqm.getRealName().trim().length()>0) {
			dc.add(Restrictions.like("realName", "%"+eqm.getRealName().trim()+"%"));
		}
		if(eqm.getTele()!=null && eqm.getTele().trim().length()>0) {
			dc.add(Restrictions.like("tele", "%"+eqm.getTele().trim()+"%"));
		}
		if(eqm.getEmail()!=null && eqm.getEmail().trim().length()>0) {
			dc.add(Restrictions.like("email", "%"+eqm.getEmail().trim()+"%"));
		}
		if(eqm.getGender()!=null && eqm.getGender()!=-1) {
			dc.add(Restrictions.eq("gender", eqm.getGender()));
		}
		if(eqm.getDm()!=null && eqm.getDm().getUuid()!=null && eqm.getDm().getUuid()!=-1) {
			dc.add(Restrictions.eq("dm", eqm.getDm()));
		}
		if(eqm.getBirth()!=null) {
			dc.add(Restrictions.ge("birth", eqm.getBirth()));
		}
		if(eqm.getMaxBirth()!=null) {
			dc.add(Restrictions.le("birth", eqm.getMaxBirth()));
		}
	}
}
