package cn.itcast.erp.auth.emp.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface EmpDao extends BaseDao<EmpModel>{

	public EmpModel login(String userName, String pwd);

	public boolean changePwd(String userName, String oldPwd, String newPwd);

	public List<EmpModel> getByDep(Long depUuid);
}
