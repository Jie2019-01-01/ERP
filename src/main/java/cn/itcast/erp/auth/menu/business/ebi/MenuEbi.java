package cn.itcast.erp.auth.menu.business.ebi;

import java.util.List;

import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.menu.vo.MenuQueryModel;
import cn.itcast.erp.utils.base.BaseEbi;

public interface MenuEbi extends BaseEbi<MenuModel>{

	/**
	 * 获取除系统菜单外的所有菜单
	 * @param mqm	菜单模型
	 * @param curPage	当前页
	 * @param pageCount 每页显示
	 * @return
	 */
	public List<MenuModel> listExSystem(MenuQueryModel mqm, Integer curPage, Integer pageCount);

	/**
	 * 获取所有包含子菜单的父菜单列表
	 * @return
	 */
	public List<MenuModel> listAsParent();

	public void update(MenuModel mm, Long[] roles);

	public void save(MenuModel mm, Long[] roles);

	/**
	 * 获取当前用户中拥有的角色所对应的一级菜单
	 * @param empUuid 用户id
	 * @return
	 */
	public List<MenuModel> listOne(Long empUuid);

	/**
	 * 通过父级菜单获取当前用户中拥有的角色所对应的菜单
	 * @param puuid 父菜单的uuid 
	 * @param	empUuid 用户id
	 * @return
	 */
	public List<MenuModel> listByMenu(Long empUuid, Long puuid);

}