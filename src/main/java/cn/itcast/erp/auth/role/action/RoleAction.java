package cn.itcast.erp.auth.role.action;

import java.util.List;
import cn.itcast.erp.auth.menu.business.ebi.MenuEbi;
import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.res.business.ebi.ResEbi;
import cn.itcast.erp.auth.res.vo.ResModel;
import cn.itcast.erp.auth.role.business.ebi.RoleEbi;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.auth.role.vo.RoleQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class RoleAction extends BaseAction{

	private RoleEbi roleEbi;
	public void setRoleEbi(RoleEbi roleEbi) {this.roleEbi = roleEbi;}
	private ResEbi resEbi;
	public void setResEbi(ResEbi resEbi) {this.resEbi = resEbi;}
	private MenuEbi menuEbi;
	public void setMenuEbi(MenuEbi menuEbi) {this.menuEbi = menuEbi;}
	
	public RoleModel rm = new RoleModel();
	public RoleQueryModel rqm = new RoleQueryModel();

	public String list() {
		setRecords(roleEbi.getCount(rqm));
		List<RoleModel> roleList = roleEbi.list(rqm, curPage, pageCount);
		put("roleList", roleList);
		return "list";
	}

	public String input() {
		if(rm.getUuid()!=null) {
			rm = roleEbi.getByUuid(rm.getUuid());
			// 资源回显
			rs = new Long[rm.getReses().size()];
			int i = 0;
			for(ResModel temp: rm.getReses()) {
				rs[i++] = temp.getUuid();
			}
			// 菜单回显
			menus = new Long[rm.getMms().size()];
			i = 0;
			for(MenuModel temp: rm.getMms()) {
				menus[i++] = temp.getUuid();
			}
		}
		List<ResModel> resList = resEbi.list();
		put("resList", resList);
		List<MenuModel> menuList = menuEbi.list();
		put("menuList", menuList);
		return "input";
	}

	public Long[] rs;
	public Long[] menus;
	public String saveOrUpdate() {
		if(rm.getUuid()!=null) {
			roleEbi.update(rm, rs, menus);
		}else {
			roleEbi.save(rm, rs, menus);
		}
		return "toList";
	}

	public String delete() {
		roleEbi.delete(rm);
		return "toList";
	}

}