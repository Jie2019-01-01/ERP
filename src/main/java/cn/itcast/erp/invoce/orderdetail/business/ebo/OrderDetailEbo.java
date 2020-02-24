package cn.itcast.erp.invoce.orderdetail.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.orderdetail.business.ebi.OrderDetailEbi;
import cn.itcast.erp.invoce.orderdetail.dao.dao.OrderDetailDao;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class OrderDetailEbo implements OrderDetailEbi {

	private OrderDetailDao orderDetailDao;
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {this.orderDetailDao = orderDetailDao;}

	public List<OrderDetailModel> list() {
		return orderDetailDao.list();
	}

	public void save(OrderDetailModel om) {
		orderDetailDao.save(om);
	}

	public void update(OrderDetailModel om) {
		orderDetailDao.update(om);
	}

	public OrderDetailModel getByUuid(Long uuid) {
		return orderDetailDao.getByUuid(uuid);
	}

	public void delete(OrderDetailModel om) {
		orderDetailDao.delete(om);
	}

	public List<OrderDetailModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return orderDetailDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return orderDetailDao.getCount(bqm);
	}

}