package cn.itcast.erp.utils.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class<T> entityClass;
	//将entityClass初始化
	public BaseImpl(){
		Type genType = getClass().getGenericSuperclass();   
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
		entityClass =  (Class)params[0];  
	}
	
	public List<T> list() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		return this.getHibernateTemplate().findByCriteria(dc);
	}
	
	public List<T> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		doQbc(dc, bqm);
		return this.getHibernateTemplate().findByCriteria(dc, (curPage-1)*pageCount, pageCount);
	}
	
	// 根据条件统计总量
	public Integer getCount(BaseQueryModel bqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setProjection(Projections.rowCount());
		doQbc(dc, bqm);
		List<Long> list = this.getHibernateTemplate().findByCriteria(dc);
		return list.get(0).intValue();
	}

	// 添加
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	// 修改
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	// 根据uuid获取
	public T getByUuid(Serializable uuid) {
		return this.getHibernateTemplate().get(entityClass, uuid);
	}

	// 删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	// 自定义查询条件
	public abstract void doQbc(DetachedCriteria dc, BaseQueryModel bqm);
}
