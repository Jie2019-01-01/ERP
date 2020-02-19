package cn.itcast.erp.auth.emp.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class EmpImpl extends BaseImpl<EmpModel> implements EmpDao {

	public EmpModel login(String userName, String pwd) {
		String hql = "from EmpModel where userName=? and pwd=?";
		List<EmpModel> empList = this.getHibernateTemplate().find(hql, userName, pwd);
		return empList.size()>0? empList.get(0): null;
	}

	public boolean changePwd(String userName, String oldPwd, String newPwd) {
		String hql = "update EmpModel set pwd=? where userName=? and pwd=?";
		int row = this.getHibernateTemplate().bulkUpdate(hql, newPwd, userName, oldPwd);
		return row>0;
	}

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		EmpQueryModel eqm = (EmpQueryModel) bqm;
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
