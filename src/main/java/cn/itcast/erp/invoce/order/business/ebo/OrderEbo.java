package cn.itcast.erp.invoce.order.business.ebo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.exception.AppException;
import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.order.business.ebi.OrderEbi;
import cn.itcast.erp.invoce.order.dao.dao.OrderDao;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.invoce.order.vo.OrderQueryModel;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.utils.base.BaseQueryModel;
import cn.itcast.erp.utils.generator.OrderNumUtil;

@Transactional
public class OrderEbo implements OrderEbi {

	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {this.orderDao = orderDao;}

	public List<OrderModel> list() {
		return orderDao.list();
	}

	public void save(OrderModel om) {
		orderDao.save(om);
	}

	public void update(OrderModel om) {
		orderDao.update(om);
	}

	public OrderModel getByUuid(Long uuid) {
		return orderDao.getByUuid(uuid);
	}

	public void delete(OrderModel om) {
		orderDao.delete(om);
	}

	public List<OrderModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return orderDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return orderDao.getCount(bqm);
	}
	
	public void inSave(EmpModel creater, OrderModel om, 
			 Long[] goodsUuids, Integer[] nums, Double[] prices) {
		// 订单
		// 订单号
		om.setOrderNum(OrderNumUtil.generatorNum());
		// 总数量  += nums.each
		int totalCount = 0;
		// 总价格  += prices.each
		Double totalPrice = 0D;
		//	订单类型为“采购”
		om.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		// 订单状态为“未审核”
		om.setStatus(OrderModel.ORDER_STATUS_OF_BUY_NO_CHECK);
		// 下单时间为“当前系统时间”
		om.setCreateTime(System.currentTimeMillis());
		// 下单人为“当前登录人”
		om.setCreater(creater);
		
		// 审核人与跟单人暂时为null
		
		// 明细
		Set<OrderDetailModel> odms = new HashSet<OrderDetailModel>();
		for(int i=0; i<goodsUuids.length; i++) {
			// 订单明细
			// 商品
			OrderDetailModel odm = new OrderDetailModel();
			GoodsModel gm = new GoodsModel();
			gm.setUuid(goodsUuids[i]);
			odm.setGm(gm);
			// 数量
			odm.setBuyCount(nums[i]);
			// 单价
			odm.setInPrice(prices[i]);
			// 所属订单
			odm.setOm(om);
			// 添加
			odms.add(odm);
			
			// 统计总数量、总价格
			totalCount += nums[i];
			totalPrice += prices[i] * nums[i];
		}
		om.setOdms(odms);
		om.setTotalCount(totalCount);
		om.setTotalPrice(totalPrice);
		
		orderDao.save(om);
	}

	public List<OrderModel> inList(OrderQueryModel oqm, Integer curPage, Integer pageCount) {
		return orderDao.list(oqm, curPage, pageCount);
	}

	public void inCheckPass(Long uuid, EmpModel checker) {
		OrderModel om = orderDao.getByUuid(uuid);
		// 逻辑校验
		if(om.getStatus()!=OrderModel.ORDER_STATUS_OF_BUY_NO_CHECK) {
			throw new AppException("悟空，不要调皮....");
		}
		// 订单状态: 未审核==》通过
		om.setStatus(OrderModel.ORDER_STATUS_OF_BUY_PASS);
		// 审核人
		om.setChecker(checker);
		// 审核时间
		om.setCheckTime(System.currentTimeMillis());
	}

	public void inCheckNoPass(Long uuid, EmpModel checker) {
		OrderModel om = orderDao.getByUuid(uuid);
		// 逻辑校验
		if(om.getStatus()!=OrderModel.ORDER_STATUS_OF_BUY_NO_CHECK) {
			throw new AppException("悟空，不要调皮....");
		}
		// 订单状态: 未审核==》驳回
		om.setStatus(OrderModel.ORDER_STATUS_OF_BUY_NO_PASS);
		// 审核人
		om.setChecker(checker);
		// 审核时间
		om.setCheckTime(System.currentTimeMillis());
	}

	// 运输任务中应显示的订单状态
	private Integer[] statuses = {
		OrderModel.ORDER_STATUS_OF_BUY_PASS,
		OrderModel.ORDER_STATUS_OF_BUY_BUYING,
		OrderModel.ORDER_STATUS_OF_BUY_IN_STORE,
		OrderModel.ORDER_STATUS_OF_BUY_COMPLETE,
		
		OrderModel.ORDER_STATUS_OF_SALE_PASS
		};
	public Integer getTaskCount(OrderQueryModel oqm) {
		return orderDao.getTaskCount(oqm, statuses);
	}

	public List<OrderModel> getTaskList(OrderQueryModel oqm, Integer curPage, 
			Integer pageCount) {
		return orderDao.getTaskList(oqm, curPage, pageCount, statuses);
	}

	public void assignTaskMan(Long uuid, EmpModel completer) {
		OrderModel om = orderDao.getByUuid(uuid);
		// 逻辑校验
		if(om.getStatus()!=OrderModel.ORDER_STATUS_OF_BUY_PASS) {
			throw new AppException("悟空，你又调皮了，为师要念咒语了。。。");
		}
		// 跟单人==》前台指定
		om.setCompleter(completer);
		// 订单状态
		om.setStatus(OrderModel.ORDER_STATUS_OF_BUY_BUYING);
	}

}