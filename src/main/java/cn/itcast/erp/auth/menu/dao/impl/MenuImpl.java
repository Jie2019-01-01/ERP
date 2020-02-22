package cn.itcast.erp.auth.menu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.erp.auth.menu.dao.dao.MenuDao;
import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
import cn.itcast.erp.utils.base.BaseImpl;
import cn.itcast.erp.utils.base.BaseQueryModel;

public class MenuImpl extends BaseImpl<MenuModel> implements MenuDao {

	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {
		MenuQueryModel mqm = (MenuQueryModel) bqm;
		if(mqm.getMname()!=null && mqm.getMname().trim().length()>0) {
			dc.add(Restrictions.like("mname", "%"+mqm.getMname().trim()+"%"));
		}
		if(mqm.getMm()!=null && mqm.getMm().getUuid()!=null && 
				mqm.getMm().getUuid()!=-1) {
			dc.add(Restrictions.eq("mm", mqm.getMm()));
		}
	}

	public List<MenuModel> listExSystem(MenuQueryModel mqm, Integer curPage, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(MenuModel.class);
		doQbc(dc, mqm);
		dc.add(Restrictions.not(Restrictions.eq("uuid", MenuModel.MENU_SYSTEM_OF_UUID)));
		return this.getHibernateTemplate().findByCriteria(dc, (curPage-1)*pageCount, pageCount);
	}

	public List<MenuModel> listAsParent() {
		String hql = "from MenuModel where uuid=? or parent=?";
		return this.getHibernateTemplate().find(hql, MenuModel.MENU_SYSTEM_OF_UUID, MenuModel.MENU_SYSTEM_OF_UUID);
	}

	public List<MenuModel> listOne(Long empUuid) {
		String hql = "select distinct mm from EmpModel em join em.rms rm join "
				+ "rm.mms mm where mm.mm.uuid=? and em.uuid=? order by mm.uuid";
		return this.getHibernateTemplate().find(hql, MenuModel.MENU_SYSTEM_OF_UUID, empUuid);
	}

	public List<MenuModel> listByMenu(Long empUuid, Long puuid) {
		String hql = "select distinct mm from EmpModel em join em.rms rm join "
				+ "rm.mms mm where mm.mm.uuid=? and em.uuid=? order by mm.uuid";
		return this.getHibernateTemplate().find(hql, puuid, empUuid);
	}
}