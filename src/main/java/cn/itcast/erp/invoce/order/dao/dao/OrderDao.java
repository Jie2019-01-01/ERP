package cn.itcast.erp.invoce.order.dao.dao;

import java.util.List;

import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.utils.base.BaseDao;

public interface OrderDao extends BaseDao<OrderModel>{

	/**
	 * 获取运输任务中应显示的订单数量
	 * @param oqm 条件模型
	 * @param statuses 订单状态数组
	 * @return
	 */
	public Integer getTaskCount(OrderQueryModel oqm, Integer[] statuses);

	/**
	 * 获取运输任务列表
	 * @param oqm
	 * @param curPage
	 * @param pageCount
	 * @param statuses 订单状态数组
	 * @return
	 */
	public List<OrderModel> getTaskList(OrderQueryModel oqm, Integer curPage, Integer pageCount, Integer[] statuses);

}