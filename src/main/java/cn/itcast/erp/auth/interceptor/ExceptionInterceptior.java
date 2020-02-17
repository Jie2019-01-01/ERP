package cn.itcast.erp.auth.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import cn.itcast.erp.auth.exception.AppException;

public class ExceptionInterceptior extends AbstractInterceptor{

	private static final long serialVersionUID = -5523509743228335191L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		}catch(AppException e) {
			ActionContext.getContext().put("msg", e.getMessage());
			return "appException";
		}
	}

}
