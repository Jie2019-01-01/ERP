package cn.itcast.erp.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.exception.AppException;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取当前调用的资源
		String actionName = invocation.getProxy().getAction().getClass().getName();
		String method = invocation.getProxy().getMethod();
		String totalName = actionName+"."+method;
		
		StringBuilder sbf = (StringBuilder) ActionContext.getContext().getApplication().get("sbf");
		// 判断所访问的是否为可放行的资源(如：login)
		if(sbf.indexOf(totalName+",")<0) {
			return invocation.invoke();
		}
		// 获取当前登录人信息
		EmpModel loginEm = (EmpModel) ActionContext.getContext()
				.getSession().get(EmpModel.EMP_LOGIN_OF_INFO);
		// 获取当前登录人的角色对应的资源
		if(loginEm!=null) {
			if(loginEm.getReses().contains(totalName)) {
				return invocation.invoke();
			}
			throw new AppException("对不起，你没有权限，不能执行该操作...");
		}
		
		return invocation.invoke();
	}

}
