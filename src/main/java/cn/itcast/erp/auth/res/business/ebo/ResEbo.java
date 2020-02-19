package cn.itcast.erp.auth.res.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.res.business.ebi.ResEbi;
import cn.itcast.erp.auth.res.dao.dao.ResDao;
import cn.itcast.erp.auth.res.vo.ResModel;
import cn.itcast.erp.auth.res.vo.ResQueryModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class ResEbo implements ResEbi{

	private ResDao resDao;
	public void setResDao(ResDao resDao) {this.resDao = resDao;}
	
	public List<ResModel> list() {
		return resDao.list();
	}

	public ResModel getByUuid(Long uuid) {
		return resDao.getByUuid(uuid);
	}

	public void save(ResModel rm) {
		resDao.save(rm);
	}

	public void update(ResModel rm) {
		resDao.update(rm);
	}

	public void delete(ResModel rm) {
		resDao.delete(rm);
	}

	public List<ResModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return resDao.list(bqm, curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return resDao.getCount(bqm);
	}
	
}
