package cn.itcast.erp.auth.emp.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.emp.vo.EmpModel;

public interface EmpDao {

	public EmpModel login(String userName, String pwd);

	public List<EmpModel> list();
}
