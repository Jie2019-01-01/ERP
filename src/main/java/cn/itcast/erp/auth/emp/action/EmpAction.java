package cn.itcast.erp.auth.emp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;

public class EmpAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {this.empEbi = empEbi;}

	public EmpModel em = new EmpModel();
	
	// 登录
	public String login() {
		System.out.println("开始执行模版:");
		EmpModel loginEm = empEbi.login(em.getUserName(), em.getPwd());
		if(loginEm!=null) {
			System.out.println("登录成功");
			// 将登录人信息放入session
			ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_OF_INFO, loginEm);
			return "loginSuccess";
		}else {
			System.out.println("登录失败");
			ActionContext.getContext().put("loginMsg", "用户名或密码错误");
			return "loginFail";
		}
	}
	
	// 注销
	public String logout() {
		ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_OF_INFO, null);
		return "toLogin";
	}
}
