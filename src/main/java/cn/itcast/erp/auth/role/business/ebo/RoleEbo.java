package cn.itcast.erp.auth.role.business.ebo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.res.vo.ResModel;
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
	
	public void save(RoleModel rm, Long[] rs) {
		Set<ResModel> reses = new HashSet<ResModel>();
		for(Long resUuid: rs) {
			ResModel temp = new ResModel();
			temp.setUuid(resUuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		roleDao.save(rm);
	}
	
	public void save(RoleModel rm, Long[] rs, Long[] menus) {
		// 绑定资源
		Set<ResModel> reses = new HashSet<ResModel>();
		for(Long resUuid: rs) {
			ResModel temp = new ResModel();
			temp.setUuid(resUuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		// 绑定菜单
		Set<MenuModel> mms = new HashSet<MenuModel>();
		for(Long menuUuid: menus) {
			MenuModel temp = new MenuModel();
			temp.setUuid(menuUuid);
			mms.add(temp);
		}
		rm.setMms(mms);
		roleDao.save(rm);
	}

	public void update(RoleModel rm) {
		roleDao.update(rm);
	}
	
	public void update(RoleModel rm, Long[] rs) {
		Set<ResModel> reses = new HashSet<ResModel>();
		for(Long resUuid: rs) {
			ResModel temp = new ResModel();
			temp.setUuid(resUuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		roleDao.update(rm);
	}
	
	public void update(RoleModel rm, Long[] rs, Long[] menus) {
		// 绑定资源
		Set<ResModel> reses = new HashSet<ResModel>();
		for(Long resUuid: rs) {
			ResModel temp = new ResModel();
			temp.setUuid(resUuid);
			reses.add(temp);
		}
		rm.setReses(reses);
		// 绑定菜单
		Set<MenuModel> mms = new HashSet<MenuModel>();
		for(Long menuUuid: menus) {
			MenuModel temp = new MenuModel();
			temp.setUuid(menuUuid);
			mms.add(temp);
		}
		rm.setMms(mms);
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