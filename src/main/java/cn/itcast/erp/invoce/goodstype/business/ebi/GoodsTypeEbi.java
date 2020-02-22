package cn.itcast.erp.invoce.goodstype.business.ebi;

import java.util.List;

import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.utils.base.BaseEbi;

public interface GoodsTypeEbi extends BaseEbi<GoodsTypeModel>{

	/**
	 * 获取指定供应商下的商品类别
	 * @param uuid 供应商uuid
	 * @return
	 */
	public List<GoodsTypeModel> getBySupplier(Long uuid);

}