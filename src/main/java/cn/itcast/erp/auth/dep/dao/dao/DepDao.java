package cn.itcast.erp.auth.dep.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;

public interface DepDao {

	public List<DepModel> list();

	public void save(DepModel dm);

	public void update(DepModel dm);

	public DepModel getByUuid(Long uuid);

	public void delete(DepModel dm);

	public Integer getCount();

	public List<DepModel> list(Integer curPage, Integer pageCount);

	public List<DepModel> list(DepQueryModel dqm, Integer curPage, Integer pageCount);

	public Integer getCount(DepQueryModel dqm);
}
