package cn.itcast.erp.utils.base;

import java.util.List;

public interface BaseEbi<T> {

	public List<T> list();

	public void save(T dm);

	public void update(T dm);

	public T getByUuid(Long uuid);

	public void delete(T dm);

	public List<T> list(BaseQueryModel bqm, Integer curPage, Integer pageCount);

	public Integer getCount(BaseQueryModel bqm);
}
