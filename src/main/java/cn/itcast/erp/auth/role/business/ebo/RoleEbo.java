package cn.itcast.erp.auth.role.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.role.business.ebi.RoleEbi;
import cn.itcast.erp.auth.role.dao.dao.RoleDao;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class RoleEbo implements RoleEbi {

	private RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {this.roleDao = roleDao;}

	public List<RoleModel> list() {
		return roleDao.list();
	}

	public void save(RoleModel rm) {
		roleDao.save(rm);
	}

	public void update(RoleModel rm) {
		roleDao.update(rm);
	}

	public RoleModel getByUuid(Long uuid) {
		return roleDao.getByUuid(uuid);
	}

	public void delete(RoleModel rm) {
		roleDao.delete(rm);
	}

	public List<RoleModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return roleDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return roleDao.getCount(bqm);
	}

}