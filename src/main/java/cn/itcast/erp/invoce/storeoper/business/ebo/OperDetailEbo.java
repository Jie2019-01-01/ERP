package cn.itcast.erp.invoce.storeoper.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.storeoper.business.ebi.OperDetailEbi;
import cn.itcast.erp.invoce.storeoper.dao.dao.OperDetailDao;
import cn.itcast.erp.invoce.storeoper.vo.OperDetailModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class OperDetailEbo implements OperDetailEbi {

	private OperDetailDao operDetailDao;
	public void setOperDetailDao(OperDetailDao operDetailDao) {this.operDetailDao = operDetailDao;}

	public List<OperDetailModel> list() {
		return operDetailDao.list();
	}

	public void save(OperDetailModel om) {
		operDetailDao.save(om);
	}

	public void update(OperDetailModel om) {
		operDetailDao.update(om);
	}

	public OperDetailModel getByUuid(Long uuid) {
		return operDetailDao.getByUuid(uuid);
	}

	public void delete(OperDetailModel om) {
		operDetailDao.delete(om);
	}

	public List<OperDetailModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return operDetailDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return operDetailDao.getCount(bqm);
	}

}