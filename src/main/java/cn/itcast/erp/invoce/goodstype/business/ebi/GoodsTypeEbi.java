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

	/**
	 * 通过供应商uuid，获取包含商品的类别信息
	 * @param uuid 供应商uuid
	 * @return
	 */
	public List<GoodsTypeModel> getNotNullBySupplier(Long uuid);

	/**
	 * 根据已经使用过的商品uuid来过滤类别信息，获取类别集合
	 * @param supplierUuid	供应商uuid
	 * @param gmUuids	已使用的商品uuid集合
	 * @return
	 */
	public List<GoodsTypeModel> getBySupplierUnion(Long supplierUuid, List<Long> gmUuids);

}