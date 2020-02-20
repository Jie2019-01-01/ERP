package cn.itcast.erp.auth.role.business.ebi;

import cn.itcast.erp.auth.role.vo.RoleModel;
import cn.itcast.erp.utils.base.BaseEbi;

public interface RoleEbi extends BaseEbi<RoleModel>{

	/**
	 * 同绑定资源操作一同修改
	 * @param rm 角色模型
	 * @param rs 需绑定资源的uuid数组
	 */
	public void update(RoleModel rm, Long[] rs);

	/**
	 * 同绑定资源操作一同保存
	 * @param rm 角色模型
	 * @param rs 需绑定资源的uuid数组
	 */
	public void save(RoleModel rm, Long[] rs);

}