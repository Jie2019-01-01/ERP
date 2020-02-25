package cn.itcast.erp.invoce.order.business.ebi;

import java.util.List;

import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.utils.base.BaseEbi;

public interface OrderEbi extends BaseEbi<OrderModel>{

	/**
	 * 采购订单保存
	 * @param om 订单模型(封装了供应商的uuid)
	 * @param goodsUuids	商品uuid数组
	 * @param nums	购买数量数组
	 * @param prices	商品单价数组
	 */
	public void inSave(EmpModel creater, OrderModel om, 
			Long[] goodsUuids, Integer[] nums, Double[] prices);

	/**
	 * 采购列表显示
	 * @param oqm
	 * @param curPage
	 * @param pageCount
	 * @return
	 */
	public List<OrderModel> inList(OrderQueryModel oqm, Integer curPage, Integer pageCount);

	/**
	 * 审核通过
	 * @param uuid 订单uuid
	 * @param checker 审核人
	 */
	public void inCheckPass(Long uuid, EmpModel checker);
	/**
	 * 审核未通过
	 * @param uuid 订单uuid
	 * @param checker 审核人
	 */
	public void inCheckNoPass(Long uuid, EmpModel checker);

	/**
	 * 获取运输任务总数
	 * @param oqm	条件模型
	 * @return
	 */
	public Integer getTaskCount(OrderQueryModel oqm);

	/**
	 * 获取运输任务列表
	 * @param oqm 条件模型
	 * @param curPage
	 * @param pageCount
	 * @return
	 */
	public List<OrderModel> getTaskList(OrderQueryModel oqm, Integer curPage, Integer pageCount);

	/**
	 * 指派任务人
	 * @param uuid 订单uuid
	 * @param completer
	 */
	public void assignTaskMan(Long uuid, EmpModel completer);

	/**
	 * 任务查询显示的订单数量
	 * @param oqm
	 * @param completer 跟单人，即当前登录人
	 * @return
	 */
	public Integer getQueryTaskCount(OrderQueryModel oqm, EmpModel completer);

	/**
	 * 任务查询中的订单列表
	 * @param oqm
	 * @param curPage
	 * @param pageCount
	 * @param completer 跟单人，即当前登录人
	 * @return
	 */
	public List<OrderModel> queryTaskList(OrderQueryModel oqm, Integer curPage, 
			Integer pageCount, EmpModel completer);

	/**
	 * 订单任务结束
	 * @param uuid 订单uuid
	 */
	public void endTask(Long uuid);

}