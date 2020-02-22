package cn.itcast.erp.auth.menu.action;

import java.io.PrintWriter;
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
	
	public String showMenu() throws Exception {
		getResponse().setContentType("text/html;charset=utf-8");
		String root = getRequest().getParameter("root");
		PrintWriter pw = getResponse().getWriter();
		StringBuilder temp = new StringBuilder();
		temp.append("[");
		if("source".equals(root)) {
			// 获取所有一级菜单
			List<MenuModel> oneList = menuEbi.listOne(getLoginEm().getUuid());
			for(MenuModel one: oneList) {
				temp.append("{\"id\":"+one.getUuid()+", \"text\": \""+one.getMname()+"\", "
						+ "\"classes\": \"folder\", \"hasChildren\": true},");
			}
		}else {
			List<MenuModel> childs = menuEbi.listByMenu(getLoginEm().getUuid(), new Long(root));
			for(MenuModel child: childs) {
				temp.append("{\"text\": \"<a class='hei' target='main' "
						+ "href='"+child.getMurl()+"'>"+child.getMname()+"</a>\"},");
			}
		}
		temp.deleteCharAt(temp.length()-1);
		temp.append("]");
		pw.print(temp.toString());
		return NONE;
	}

	public String list() {
		setRecords(menuEbi.getCount(mqm));
		List<MenuModel> menuList = menuEbi.listExSystem(mqm, curPage, pageCount);
		put("menuList", menuList);
		List<MenuModel>	parentList = menuEbi.listAsParent();
		put("parentList", parentList);
		return "list";
	}

	public Long[] roles;
	public String input() {
		List<MenuModel> menuList = menuEbi.listAsParent();
		put("menuList", menuList);
		List<RoleModel> roleList = roleEbi.list();
		put("roleList", roleList);
		if(mm.getUuid()!=null) {
			mm = menuEbi.getByUuid(mm.getUuid());
			roles = new Long[mm.getRms().size()];
			int i = 0;
			for(RoleModel temp: mm.getRms()) {
				roles[i++] = temp.getUuid();
			}
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(mm.getUuid()!=null) {
			menuEbi.update(mm, roles);
		}else {
			menuEbi.save(mm, roles);
		}
		return "toList";
	}

	public String delete() {
		menuEbi.delete(mm);
		return "toList";
	}

}