package cn.itcast.erp.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ResLoadLintener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		StringBuilder sbf = new StringBuilder();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
			ps = con.prepareStatement("select resValue from tbl_res;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sbf.append(rs.getString("resValue")+",");
			}
			
			// 存放至context域中
			ServletContext context = event.getServletContext();
			context.setAttribute("sbf", sbf);
		} catch (Exception e) {
			System.out.println("服务启动查询所有资源出现异常了……");
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
