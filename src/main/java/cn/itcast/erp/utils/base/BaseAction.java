package cn.itcast.erp.utils.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.erp.auth.emp.vo.EmpModel;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = -7375714442519869658L;

	public Integer curPage = 1;	// 当前页
	public Integer pageCount = 10; // 每页显示数量
	public Integer totalRecords; // 总记录数
	public Integer lastPage; // 最后一页
	
	protected void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}
	
	protected void putSession(String key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
	}
	
	protected Object get(String name){
		return ActionContext.getContext().get(name);
	}
	
	protected Object getSession(String name){
		return ActionContext.getContext().getSession().get(name);
	}
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	protected EmpModel getLoginEm() {
		EmpModel loginEm = (EmpModel) ActionContext.getContext()
				.getSession().get(EmpModel.EMP_LOGIN_OF_INFO);
		return loginEm;
	}
	
	protected void setRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
		// 计算最后一页
		this.lastPage = (this.totalRecords-1)/this.pageCount+1;
		// 兼容页码值初始化错误
		if(curPage<1) curPage = 1;
		if(curPage>lastPage) curPage = lastPage;
	}
	
	private String actionName;
	public String getActionName() {return actionName;}
	{
		String temp = getClass().toString();
		temp = temp.substring(temp.lastIndexOf(".")+1); // DepAction
		temp = temp.substring(0, temp.length()-6); // Dep
		temp = (char)(temp.charAt(0)+32)+temp.substring(1);
		actionName = temp;
	}
}
