package cn.itcast.erp.invoce.storedetail.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.storedetail.business.ebi.StoreDetailEbi;
import cn.itcast.erp.invoce.storedetail.dao.dao.StoreDetailDao;
import cn.itcast.erp.invoce.storedetail.vo.StoreDetailModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class StoreDetailEbo implements StoreDetailEbi {

	private StoreDetailDao storeDetailDao;
	public void setStoreDetailDao(StoreDetailDao storeDetailDao) {this.storeDetailDao = storeDetailDao;}

	public List<StoreDetailModel> list() {
		return storeDetailDao.list();
	}

	public void save(StoreDetailModel sm) {
		storeDetailDao.save(sm);
	}

	public void update(StoreDetailModel sm) {
		storeDetailDao.update(sm);
	}

	public StoreDetailModel getByUuid(Long uuid) {
		return storeDetailDao.getByUuid(uuid);
	}

	public void delete(StoreDetailModel sm) {
		storeDetailDao.delete(sm);
	}

	public List<StoreDetailModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return storeDetailDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return storeDetailDao.getCount(bqm);
	}

}