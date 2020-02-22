package cn.itcast.erp.invoce.supplier.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoce.supplier.dao.dao.SupplierDao;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class SupplierEbo implements SupplierEbi {

	private SupplierDao supplierDao;
	public void setSupplierDao(SupplierDao supplierDao) {this.supplierDao = supplierDao;}

	public List<SupplierModel> list() {
		return supplierDao.list();
	}

	public void save(SupplierModel sm) {
		supplierDao.save(sm);
	}

	public void update(SupplierModel sm) {
		supplierDao.update(sm);
	}

	public SupplierModel getByUuid(Long uuid) {
		return supplierDao.getByUuid(uuid);
	}

	public void delete(SupplierModel sm) {
		supplierDao.delete(sm);
	}

	public List<SupplierModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return supplierDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return supplierDao.getCount(bqm);
	}

}