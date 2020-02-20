package cn.itcast.erp.auth.emp.business.ebo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.dao.dao.EmpDao;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;
import cn.itcast.erp.auth.res.dao.dao.ResDao;
import cn.itcast.erp.auth.res.vo.ResModel;
import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.exception.AppException;
import cn.itcast.erp.utils.format.Md5Utils;

@Transactional
public class EmpEbo implements EmpEbi {

	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {this.empDao = empDao;}
	private ResDao resDao;
	public void setResDao(ResDao resDao) {this.resDao = resDao;}

	public EmpModel login(String userName, String pwd) {
		// pwd进行Md5加密
		pwd = Md5Utils.md5(pwd);
		EmpModel loginEm = empDao.login(userName, pwd);
		if(loginEm!=null) {
			// 更新最后登录时间
			loginEm.setLastLoginTime(System.currentTimeMillis());
			// 连同该用户的资源一同获取出来
			StringBuilder sbf = new StringBuilder();
			List<ResModel> resList = resDao.getAllByEmpUuid(loginEm.getUuid());
			for(ResModel temp: resList) {
				sbf.append(temp.getResValue()+",");
			}
			loginEm.setReses(sbf.toString());
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
	
	public Integer getCount(EmpQueryModel eqm) {
		return empDao.getCount(eqm);
	}

	public List<EmpModel> list(EmpQueryModel eqm, Integer curPage, Integer pageCount) {
		return empDao.list(eqm, curPage, pageCount);
	}

	public void changePwd(String userName, String oldPwd, String newPwd) {
		//将oldPwd、newPwd加密，然后更新
		oldPwd = Md5Utils.md5(oldPwd);
		newPwd = Md5Utils.md5(newPwd);
		boolean result = empDao.changePwd(userName, oldPwd, newPwd);
		if(!result) {
			throw new AppException("对不起，两次密码输入不一致，本次操作失败!");
		}
	}

	public void update(EmpModel em, Long[] roles) {
		EmpModel temp = empDao.getByUuid(em.getUuid());
		temp.setAddress(em.getAddress());
		temp.setEmail(em.getEmail());
		temp.setTele(em.getTele());
		temp.setDm(em.getDm());
		Set<RoleModel> rms = new HashSet<RoleModel>();
		for(Long roleUuid: roles) {
			RoleModel rmTemp = new RoleModel();
			rmTemp.setUuid(roleUuid);
			rms.add(rmTemp);
		}
		temp.setRms(rms);
	}

	public void save(EmpModel em, Long[] roles) {
		em.setLastLoginTime(System.currentTimeMillis());
		em.setPwd(Md5Utils.md5(em.getPwd()));
		Set<RoleModel> rms = new HashSet<RoleModel>();
		for(Long roleUuid: roles) {
			RoleModel temp = new RoleModel();
			temp.setUuid(roleUuid);
			rms.add(temp);
		}
		em.setRms(rms);
		empDao.save(em);
	}
}
