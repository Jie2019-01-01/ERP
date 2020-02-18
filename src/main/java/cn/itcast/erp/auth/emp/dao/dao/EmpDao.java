package cn.itcast.erp.auth.emp.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.auth.emp.vo.EmpQueryModel;

public interface EmpDao {

	public EmpModel login(String userName, String pwd);

	public List<EmpModel> list();

	public void save(EmpModel em);

	public EmpModel getByUuid(Long uuid);

	public void delete(EmpModel em);

	public List<EmpModel> list(EmpQueryModel eqm, Integer curPage, Integer pageCount);

	public Integer getCount(EmpQueryModel eqm);
}
