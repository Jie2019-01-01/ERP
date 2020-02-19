package cn.itcast.erp.auth.emp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;
import cn.itcast.erp.auth.exception.AppException;
import cn.itcast.erp.auth.utils.format.FormatUtil;

public class EmpAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {this.empEbi = empEbi;}
	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {this.depEbi = depEbi;}

	public EmpModel em = new EmpModel();
	public EmpQueryModel eqm = new EmpQueryModel();
	public Integer curPage = 1;	// 当前页
	public Integer pageCount = 12; // 每页显示数量
	public Integer totalRecords; // 总记录数
	public Integer lastPage; // 最后一页
	
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
	
	// 列表
	public String list() {
		List<DepModel> depList = depEbi.list();
		ActionContext.getContext().put("depList", depList);
		totalRecords = empEbi.getCount(eqm);
		lastPage = (totalRecords-1)/pageCount+1;
		List<EmpModel> empList = empEbi.list(eqm, curPage, pageCount);
		ActionContext.getContext().put("empList", empList);
		return "list";
	}
	
	// 操作页面
	public String input() {
		// 获取所有部门信息
		List<DepModel> depList = depEbi.list();
		ActionContext.getContext().put("depList", depList);
		if(em.getUuid()!=null) {
			em = empEbi.getByUuid(em.getUuid());
			
		}
		return "input";
	}
	
	public String birthDay;
	public String saveOrUpdate() {
		if(em.getUuid()!=null) {
			empEbi.update(em);
		}else {
			em.setBirth(FormatUtil.formatDate(birthDay));
			empEbi.save(em);
		}
		return "toList";
	}
	
	public String delete() {
		empEbi.delete(em);
		return "toList";
	}
}
