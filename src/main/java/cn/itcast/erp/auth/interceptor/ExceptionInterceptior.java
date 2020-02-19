package cn.itcast.erp.auth.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import cn.itcast.erp.auth.exception.AppException;

public class ExceptionInterceptior extends AbstractInterceptor{

	private static final long serialVersionUID = -5523509743228335191L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		}catch(AppException e) {
			// 记录日志
			// 发送消息到程序员邮箱
			// 报警（根据需求）
			ActionSupport as = (ActionSupport) invocation.getAction();
			as.addActionError(as.getText("INFO_EMP_TEST"));
			return "appException";
		}catch(Exception e) {
			//开发
			e.printStackTrace();
			return invocation.invoke();
			
			//上线
			// 记录日志
			// 发送消息到程序员邮箱
			// 报警（根据需求）
//			ActionSupport as = (ActionSupport) invocation.getAction();
//			as.addActionError("对不起，服务器已关闭，请联系管理员！");
//			return "error";
		}
	}

}
