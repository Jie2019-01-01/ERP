package cn.itcast.erp.auth.emp.business.ebi;

import java.util.List;

import cn.itcast.erp.auth.emp.vo.EmpModel;

public interface EmpEbi {

	public EmpModel login(String userName, String pwd);

	public List<EmpModel> list();
}
