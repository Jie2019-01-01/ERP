package cn.itcast.erp.auth.res.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.auth.res.dao.dao.ResDao;
import cn.itcast.erp.auth.res.vo.ResModel;
import cn.itcast.erp.auth.res.vo.ResQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class ResImpl extends BaseImpl<ResModel> implements ResDao{

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		ResQueryModel rqm = (ResQueryModel) bqm;
		if(rqm.getResName()!=null && rqm.getResName().trim().length()>0) {
			dc.add(Restrictions.like("resName", "%"+rqm.getResName().trim()+"%"));
		}
	}

}
