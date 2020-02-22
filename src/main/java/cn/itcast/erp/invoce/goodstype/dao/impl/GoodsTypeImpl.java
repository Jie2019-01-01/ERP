package cn.itcast.erp.invoce.goodstype.dao.impl;

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

}