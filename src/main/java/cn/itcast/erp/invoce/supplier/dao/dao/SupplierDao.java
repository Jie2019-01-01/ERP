package cn.itcast.erp.invoce.supplier.dao.dao;

import java.util.List;

import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface SupplierDao extends BaseDao<SupplierModel>{

	/**
	 * 获取包含商品类别的供应商数据
	 * @return
	 */
	public List<SupplierModel> getNotNull();

	/**
	 * 获取供应商包含类别、并且类别中包含商品的供应商列表
	 * @return
	 */
	public List<SupplierModel> getNotNullAndGtm();

}