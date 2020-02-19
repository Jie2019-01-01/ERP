package cn.itcast.erp.utils.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	// 列表
	public List<T> list();

	// 添加
	public void save(T t);

	// 修改
	public void update(T t);

	// 通过uuid获取
	public T getByUuid(Serializable uuid);

	// 删除
	public void delete(T t);

	// 分页列表
	public List<T> list(BaseQueryModel bqm, Integer curPage, Integer pageCount);

	// 统计
	public Integer getCount(BaseQueryModel bqm);
}
