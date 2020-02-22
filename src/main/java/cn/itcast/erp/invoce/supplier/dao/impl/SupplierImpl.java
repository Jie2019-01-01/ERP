package cn.itcast.erp.invoce.supplier.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.erp.invoce.supplier.dao.dao.SupplierDao;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.invoce.supplier.vo.SupplierQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class SupplierImpl extends BaseImpl<SupplierModel> implements SupplierDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		SupplierQueryModel sqm = (SupplierQueryModel) bqm;
		if(sqm.getSname()!=null && sqm.getSname().trim().length()>0) {
			dc.add(Restrictions.like("sname", "%"+sqm.getSname().trim()+"%"));
		}
		if(sqm.getContact()!=null && sqm.getContact().trim().length()>0) {
			dc.add(Restrictions.like("contact", "%"+sqm.getContact().trim()+"%"));
		}
		if(sqm.getTele()!=null && sqm.getTele().trim().length()>0) {
			dc.add(Restrictions.like("tele", "%"+sqm.getTele().trim()+"%"));
		}
		if(sqm.getPattern()!=null && sqm.getPattern()!=-1) {
			dc.add(Restrictions.eq("pattern", sqm.getPattern()));
		}
	}

	public List<SupplierModel> getNotNull() {
		String hql = "select distinct s from GoodsTypeModel gtm join gtm.sm s";
		return this.getHibernateTemplate().find(hql);
	}

}