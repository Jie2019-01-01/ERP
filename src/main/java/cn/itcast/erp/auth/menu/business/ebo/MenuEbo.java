package cn.itcast.erp.auth.menu.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.menu.business.ebi.MenuEbi;
import cn.itcast.erp.auth.menu.dao.dao.MenuDao;
import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
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

	public void update(MenuModel mm) {
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

}