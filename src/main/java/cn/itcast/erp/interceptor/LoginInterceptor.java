package cn.itcast.erp.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.itcast.erp.auth.emp.vo.EmpModel;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2195548322871250788L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 如何判断是否登录
		// 从session中获取的loginEm可以判断
		EmpModel em = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_OF_INFO);
		if(em!=null) {
			invocation.invoke();
		}
		// 包名+方法名可以确定访问的是登录action
		// action全限定名
		String actionClassName = invocation.getAction().getClass().getName();
		// 方法名
		String method = invocation.getProxy().getMethod();
		String allName = actionClassName + "." + method;
		if("cn.itcast.erp.auth.emp.action.EmpAction.login".equals(allName)) {
			invocation.invoke();
		}
		return "toLogin";
	}

}
