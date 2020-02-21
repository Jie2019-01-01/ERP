package cn.itcast.erp.auth.menu.dao.dao;

import java.util.List;

import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface MenuDao extends BaseDao<MenuModel>{

	/**
	 * 获取除系统菜单外的所有菜单
	 * @param mqm	菜单模型
	 * @param curPage	当前页
	 * @param pageCount 每页显示
	 * @return
	 */
	public List<MenuModel> listExSystem(MenuQueryModel mqm, Integer curPage, Integer pageCount);

	public List<MenuModel> listAsParent();

}