package cn.itcast.erp.auth.emp.business.ebo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;
import cn.itcast.erp.auth.utils.format.FormatUtil;
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

	public void save(EmpModel em) {
		// 设置最后登录时间(即用户创建就是第一次登录时间)
		em.setLastLoginTime(System.currentTimeMillis());
		// 密码加密
		em.setPwd(Md5Utils.md5(em.getPwd()));
		empDao.save(em);
	}

	public EmpModel getByUuid(Long uuid) {
		return empDao.getByUuid(uuid);
	}

	public void update(EmpModel em) {
		// 用户有些数据是不能修改的，例如：出生日期、性别等
		// 这里使用快照
		EmpModel temp = empDao.getByUuid(em.getUuid());
		temp.setAddress(em.getAddress());
		temp.setEmail(em.getEmail());
		temp.setTele(em.getTele());
		temp.setDm(em.getDm());
	}

	public void delete(EmpModel em) {
		empDao.delete(em);
	}

	public List<EmpModel> list(EmpQueryModel eqm, Integer curPage, Integer pageCount) {
		return empDao.list(eqm, curPage, pageCount);
	}

	public Integer getCount(EmpQueryModel eqm) {
		return empDao.getCount(eqm);
	}
}
