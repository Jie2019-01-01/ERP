package cn.itcast.erp.auth.role.action;

import java.util.List;
import cn.itcast.erp.auth.role.business.ebi.RoleEbi;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.auth.role.vo.RoleQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class RoleAction extends BaseAction{

	private RoleEbi roleEbi;
	public void setRoleEbi(RoleEbi roleEbi) {this.roleEbi = roleEbi;}

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
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(rm.getUuid()!=null) {
			roleEbi.update(rm);
		}else {
			roleEbi.save(rm);
		}
		return "toList";
	}

	public String delete() {
		roleEbi.delete(rm);
		return "toList";
	}

}