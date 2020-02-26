package cn.itcast.erp.invoce.storedetail.dao.dao;

import cn.itcast.erp.invoce.storedetail.vo.StoreDetailModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface StoreDetailDao extends BaseDao<StoreDetailModel>{

	/**
	 * 获取仓库明细，通过商品uuid、仓库uuid
	 * @param storeUuid 仓库uuid
	 * @param goodsUuid 商品uuid
	 * @return
	 */
	public StoreDetailModel getBySmAndGm(Long storeUuid, Long goodsUuid);

}