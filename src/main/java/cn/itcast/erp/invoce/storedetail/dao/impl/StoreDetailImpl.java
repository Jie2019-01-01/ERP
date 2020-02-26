package cn.itcast.erp.invoce.storedetail.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import cn.itcast.erp.invoce.storedetail.dao.dao.StoreDetailDao;
import cn.itcast.erp.invoce.storedetail.vo.StoreDetailModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class StoreDetailImpl extends BaseImpl<StoreDetailModel> implements StoreDetailDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		//TODO:自定义查询条件
	}

	public StoreDetailModel getBySmAndGm(Long storeUuid, Long goodsUuid) {
		String hql = "from StoreDetailModel where sm.uuid=? and gm.uuid=?";
		List<StoreDetailModel> sdmList = this.getHibernateTemplate().find(hql, storeUuid, goodsUuid);
		return sdmList.size()>0? sdmList.get(0): null;
	}

}