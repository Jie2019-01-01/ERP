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

}