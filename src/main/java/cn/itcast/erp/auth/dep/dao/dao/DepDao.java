package cn.itcast.erp.auth.dep.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.dep.vo.DepModel;

public interface DepDao {

	public List<DepModel> list();

	public void save(DepModel dm);

	public void update(DepModel dm);

	public DepModel getByUuid(Long uuid);

	public void delete(DepModel dm);
}
