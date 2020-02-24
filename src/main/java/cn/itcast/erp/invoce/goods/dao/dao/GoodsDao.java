package cn.itcast.erp.invoce.goods.dao.dao;

import java.util.List;

import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface GoodsDao extends BaseDao<GoodsModel>{

	/**
	 * 根据类别获取商品列表
	 * @param uuid 类别uuid
	 * @return
	 */
	public List<GoodsModel> getByGtm(Long uuid);

}