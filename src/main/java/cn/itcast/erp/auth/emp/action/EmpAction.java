package cn.itcast.erp.auth.emp.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;
import cn.itcast.erp.auth.role.business.ebi.RoleEbi;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.utils.base.BaseAction;
import cn.itcast.erp.utils.format.FormatUtil;

public class EmpAction extends BaseAction{
	
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {this.empEbi = empEbi;}
	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {this.depEbi = depEbi;}
	private RoleEbi roleEbi;
	public void setRoleEbi(RoleEbi roleEbi) {this.roleEbi = roleEbi;}

	public EmpModel em = new EmpModel();
	public EmpQueryModel eqm = new EmpQueryModel();
	
	// 登录
	public String login() {
		System.out.println("开始执行模版:");
		EmpModel loginEm = empEbi.login(em.getUserName(), em.getPwd());
		if(loginEm!=null) {
			System.out.println("登录成功");
			// 将登录人信息放入session
			putSession(EmpModel.EMP_LOGIN_OF_INFO, loginEm);
			return "loginSuccess";
		}else {
			System.out.println("登录失败");
			put("loginMsg", "用户名或密码错误");
			return "loginFail";
		}
	}
	
	// 注销
	public String logout() {
		putSession(EmpModel.EMP_LOGIN_OF_INFO, null);
		return "toLogin";
	}
	
	// 修改密码第一步，填写新密码
	public String changePwd() {
		return "changePwd";
	}
	
	// 修改密码第二步，确认修改
	public String oldPwd;
	public String newPwd;
	public String confirm() {
		//获取当前登录人信息
		EmpModel loginEm = (EmpModel) get(EmpModel.EMP_LOGIN_OF_INFO);
		empEbi.changePwd(loginEm.getUserName(), oldPwd, newPwd);
		//将登录人信息清空
		putSession(EmpModel.EMP_LOGIN_OF_INFO, null);
		return "toLogin";
	}
	
	// 列表
	public String list() {
		setRecords(empEbi.getCount(eqm));
		List<DepModel> depList = depEbi.list();
		ActionContext.getContext().put("depList", depList);
		List<EmpModel> empList = empEbi.list(eqm, curPage, pageCount);
		put("empList", empList);
		return "list";
	}
	
	// 操作页面
	public Long[] roles;
	public String input() {
		// 获取所有部门信息
		List<DepModel> depList = depEbi.list();
		put("depList", depList);
		List<RoleModel> roleList = roleEbi.list();
		put("roleList", roleList);
		if(em.getUuid()!=null) {
			em = empEbi.getByUuid(em.getUuid());
			roles = new Long[em.getRms().size()];
			int i = 0;
			for(RoleModel temp: em.getRms()) {
				roles[i++] = temp.getUuid();
			}
		}
		return "input";
	}
	
	public String birthDay;
	public String saveOrUpdate() {
		if(em.getUuid()!=null) {
			empEbi.update(em, roles);
		}else {
			em.setBirth(FormatUtil.formatDate(birthDay));
			empEbi.save(em, roles);
		}
		return "toList";
	}
	
	public String delete() {
		empEbi.delete(em);
		return "toList";
	}
}
