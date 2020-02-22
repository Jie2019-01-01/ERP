package cn.itcast.erp.invoce.goods.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.invoce.goods.dao.dao.GoodsDao;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.goods.vo.GoodsQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class GoodsImpl extends BaseImpl<GoodsModel> implements GoodsDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		GoodsQueryModel gqm = (GoodsQueryModel) bqm;
		if(gqm.getGtm()!=null && gqm.getGtm().getSm()!=null 
				&& gqm.getGtm().getSm().getUuid()!=null 
				&& gqm.getGtm().getSm().getUuid()!=-1) {
			dc.createAlias("gtm", "g");
			dc.add(Restrictions.eq("g.sm", gqm.getGtm().getSm()));
		}
		if(gqm.getGname()!=null && gqm.getGname().trim().length()>0) {
			dc.add(Restrictions.like("gname", "%"+gqm.getGname().trim()+"%"));
		}
		if(gqm.getProduce()!=null && gqm.getProduce().trim().length()>0) {
			dc.add(Restrictions.like("produce", "%"+gqm.getProduce().trim()+"%"));
		}
		if(gqm.getUnit()!=null && gqm.getUnit().trim().length()>0) {
			dc.add(Restrictions.like("unit", "%"+gqm.getUnit().trim()+"%"));
		}
		if(gqm.getInPrice()!=null) {
			dc.add(Restrictions.ge("inPrice", gqm.getInPrice()));
		}
		if(gqm.getInMaxPrice()!=null) {
			dc.add(Restrictions.le("inPrice", gqm.getInMaxPrice()));
		}
		if(gqm.getOutPrice()!=null) {
			dc.add(Restrictions.ge("outPrice", gqm.getOutPrice()));
		}
		if(gqm.getOutMaxPrice()!=null) {
			dc.add(Restrictions.le("outPrice", gqm.getOutMaxPrice()));
		}
	}

}