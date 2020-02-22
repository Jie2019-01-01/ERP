package cn.itcast.erp.auth.menu.business.ebo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.menu.business.ebi.MenuEbi;
import cn.itcast.erp.auth.menu.dao.dao.MenuDao;
import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class MenuEbo implements MenuEbi {

	private MenuDao menuDao;
	public void setMenuDao(MenuDao menuDao) {this.menuDao = menuDao;}

	public List<MenuModel> list() {
		return menuDao.list();
	}

	public void save(MenuModel mm) {
		menuDao.save(mm);
	}
	
	public void save(MenuModel mm, Long[] roles) {
		Set<RoleModel> rms = new HashSet<RoleModel>();
		for(Long roleUuid: roles) {
			RoleModel temp = new RoleModel();
			temp.setUuid(roleUuid);
			rms.add(temp);
		}
		mm.setRms(rms);
		menuDao.save(mm);
	}

	public void update(MenuModel mm) {
		menuDao.update(mm);
	}
	
	public void update(MenuModel mm, Long[] roles) {
		Set<RoleModel> rms = new HashSet<RoleModel>();
		for(Long roleUuid: roles) {
			RoleModel temp = new RoleModel();
			temp.setUuid(roleUuid);
			rms.add(temp);
		}
		mm.setRms(rms);
		menuDao.update(mm);
	}

	public MenuModel getByUuid(Long uuid) {
		return menuDao.getByUuid(uuid);
	}

	public void delete(MenuModel mm) {
		menuDao.delete(mm);
	}

	public List<MenuModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return menuDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return menuDao.getCount(bqm);
	}

	public List<MenuModel> listExSystem(MenuQueryModel mqm, Integer curPage, Integer pageCount) {
		return menuDao.listExSystem(mqm,curPage, pageCount);
	}

	public List<MenuModel> listAsParent() {
		return menuDao.listAsParent();
	}

	public List<MenuModel> listOne(Long empUuid) {
		return menuDao.listOne(empUuid);
	}

	public List<MenuModel> listByMenu(Long empUuid, Long puuid) {
		return menuDao.listByMenu(empUuid, puuid);
	}
}