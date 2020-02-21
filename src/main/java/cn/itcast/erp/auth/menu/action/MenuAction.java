package cn.itcast.erp.auth.menu.action;

import java.util.List;
import cn.itcast.erp.auth.menu.business.ebi.MenuEbi;
import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
import cn.itcast.erp.auth.role.business.ebi.RoleEbi;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.utils.base.BaseAction;

public class MenuAction extends BaseAction{

	private MenuEbi menuEbi;
	public void setMenuEbi(MenuEbi menuEbi) {this.menuEbi = menuEbi;}
	private RoleEbi roleEbi;
	public void setRoleEbi(RoleEbi roleEbi) {this.roleEbi = roleEbi;}

	public MenuModel mm = new MenuModel();
	public MenuQueryModel mqm = new MenuQueryModel();

	public String list() {
		setRecords(menuEbi.getCount(mqm));
		List<MenuModel> menuList = menuEbi.listExSystem(mqm, curPage, pageCount);
		put("menuList", menuList);
		List<MenuModel>	parentList = menuEbi.listAsParent();
		put("parentList", parentList);
		return "list";
	}

	private Long[] roles;
	public String input() {
		List<MenuModel> menuList = menuEbi.list();
		put("menuList", menuList);
		List<RoleModel> roleList = roleEbi.list();
		put("roleList", roleList);
		if(mm.getUuid()!=null) {
			mm = menuEbi.getByUuid(mm.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(mm.getUuid()!=null) {
			menuEbi.update(mm);
		}else {
			menuEbi.save(mm);
		}
		return "toList";
	}

	public String delete() {
		menuEbi.delete(mm);
		return "toList";
	}

}