package cn.itcast.erp.auth.role.action;

import java.util.List;
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
			rs = new Long[rm.getReses().size()];
			int i = 0;
			for(ResModel temp: rm.getReses()) {
				rs[i++] = temp.getUuid();
			}
		}
		List<ResModel> resList = resEbi.list();
		put("resList", resList);
		return "input";
	}

	public Long[] rs;
	public String saveOrUpdate() {
		if(rm.getUuid()!=null) {
			roleEbi.update(rm, rs);
		}else {
			roleEbi.save(rm, rs);
		}
		return "toList";
	}

	public String delete() {
		roleEbi.delete(rm);
		return "toList";
	}

}