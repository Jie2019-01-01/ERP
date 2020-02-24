package cn.itcast.erp.invoce.goodstype.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.invoce.goodstype.dao.dao.GoodsTypeDao;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class GoodsTypeImpl extends BaseImpl<GoodsTypeModel> implements GoodsTypeDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		GoodsTypeQueryModel gtqm = (GoodsTypeQueryModel) bqm;
		if(gtqm.getGtname()!=null && gtqm.getGtname().trim().length()>0) {
			dc.add(Restrictions.like("gtname", "%"+gtqm.getGtname().trim()+"%"));
		}
		if(gtqm.getSm()!=null && gtqm.getSm().getUuid()!=null && gtqm.getSm().getUuid()!=-1) {
			dc.add(Restrictions.eq("sm", gtqm.getSm()));
		}
	}

	public List<GoodsTypeModel> getBySupplier(Long uuid) {
		String hql = "from GoodsTypeModel where sm.uuid=?";
		return this.getHibernateTemplate().find(hql, uuid);
	}

	public List<GoodsTypeModel> getNotNullBySupplier(Long uuid) {
		String hql = "select distinct g from GoodsModel gm join gm.gtm g where g.sm.uuid=?";
		return this.getHibernateTemplate().find(hql, uuid);
	}

}