package cn.itcast.erp.invoce.store.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.store.business.ebi.StoreEbi;
import cn.itcast.erp.invoce.store.dao.dao.StoreDao;
import cn.itcast.erp.invoce.store.vo.StoreModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class StoreEbo implements StoreEbi {

	private StoreDao storeDao;
	public void setStoreDao(StoreDao storeDao) {this.storeDao = storeDao;}

	public List<StoreModel> list() {
		return storeDao.list();
	}

	public void save(StoreModel sm) {
		storeDao.save(sm);
	}

	public void update(StoreModel sm) {
		storeDao.update(sm);
	}

	public StoreModel getByUuid(Long uuid) {
		return storeDao.getByUuid(uuid);
	}

	public void delete(StoreModel sm) {
		storeDao.delete(sm);
	}

	public List<StoreModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return storeDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return storeDao.getCount(bqm);
	}

}