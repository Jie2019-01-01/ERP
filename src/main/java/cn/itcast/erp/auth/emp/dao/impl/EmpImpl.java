package cn.itcast.erp.auth.emp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;

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

}
