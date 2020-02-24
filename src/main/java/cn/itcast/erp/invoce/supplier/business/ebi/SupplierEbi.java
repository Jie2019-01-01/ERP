package cn.itcast.erp.invoce.supplier.business.ebi;

import java.util.List;

import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseEbi;

public interface SupplierEbi extends BaseEbi<SupplierModel>{

	/**
	 * 获取包含商品类别的供应商数据
	 * @return
	 */
	public List<SupplierModel> getNotNull();

	/**
	 * 获取供应商中包含类别、同时类别又包含商品的供应商信息
	 * @return
	 */
	public List<SupplierModel> getNotNullAndGtm();

}