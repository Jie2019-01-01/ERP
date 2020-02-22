package cn.itcast.erp.invoce.goodstype.dao.dao;

import java.util.List;

import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface GoodsTypeDao extends BaseDao<GoodsTypeModel>{

	/**
	 * 获取指定供应商下的uuid
	 * @param uuid 供应商uuid
	 * @return
	 */
	public List<GoodsTypeModel> getBySupplier(Long uuid);

}