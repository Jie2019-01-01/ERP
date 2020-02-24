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

}