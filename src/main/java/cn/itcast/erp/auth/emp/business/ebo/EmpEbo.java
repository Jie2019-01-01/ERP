package cn.itcast.erp.auth.emp.business.ebo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.utils.format.Md5Utils;

@Transactional
public class EmpEbo implements EmpEbi {

	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {this.empDao = empDao;}

	public EmpModel login(String userName, String pwd) {
		// pwd进行Md5加密
		pwd = Md5Utils.md5(pwd);
		EmpModel loginEm = empDao.login(userName, pwd);
		if(loginEm!=null) {
			// 更新最后登录时间
			loginEm.setLastLoginTime(System.currentTimeMillis());
		}
		return loginEm;
	}

	public List<EmpModel> list() {
		return empDao.list();
	}
}
