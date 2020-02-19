package cn.itcast.erp.auth.dep.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.dao.dao.DepDao;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.exception.AppException;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class DepEbo implements DepEbi {

	private DepDao depDao;
	public void setDepDao(DepDao depDao) {this.depDao = depDao;}

	public List<DepModel> list() {
		return depDao.list();
	}

	public void save(DepModel dm) {
		// 逻辑校验：部门名称和电话不能为空(正常情况应该用正则来匹配)
		if(dm.getDepName()==null || dm.getDepName().trim().length()==0) {
			//抛出自定义异常
			throw new AppException("部门名称不能为空！");
		}
		if(dm.getTele()==null || dm.getTele().trim().length()==0) {
			//抛出自定义异常
			throw new AppException("电话不能为空！");
		}
		depDao.save(dm);
	}

	public void update(DepModel dm) {
		depDao.update(dm);
	}

	public DepModel getByUuid(Long uuid) {
		return depDao.getByUuid(uuid);
	}

	public void delete(DepModel dm) {
		depDao.delete(dm);
	}

	public List<DepModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return depDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel cqm) {
		return depDao.getCount(cqm);
	}

}
