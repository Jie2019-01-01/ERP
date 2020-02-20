package cn.itcast.erp.auth.role.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.auth.role.dao.dao.RoleDao;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.auth.role.vo.RoleQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class RoleImpl extends BaseImpl<RoleModel> implements RoleDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		RoleQueryModel rqm = (RoleQueryModel) bqm;
		if(rqm.getRname()!=null && rqm.getRname().trim().length()>0) {
			dc.add(Restrictions.like("rname", "%"+rqm.getRname().trim()+"%"));
		}
		if(rqm.getRcode()!=null && rqm.getRcode().trim().length()>0) {
			dc.add(Restrictions.like("rcode", "%"+rqm.getRcode().trim()+"%"));
		}
	}

}