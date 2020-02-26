package cn.itcast.erp.invoce.orderdetail.vo;

import cn.itcast.erp.invoce.goods.vo.GoodsModel;
import cn.itcast.erp.invoce.order.vo.OrderModel;
import cn.itcast.erp.utils.format.FormatUtil;

public class OrderDetailModel {

	private Long uuid;
	
	private Integer buyCount;
	private Integer surplus;
	
	private Double inPrice;
	private String inPriceView;
	
	private OrderModel om;
	private GoodsModel gm;
	
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	public Integer getSurplus() {
		return surplus;
	}
	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}
	public Double getInPrice() {
		return inPrice;
	}
	public void setInPrice(Double inPrice) {
		this.inPrice = inPrice;
		this.inPriceView = FormatUtil.formatMonmey(inPrice);
	}
	public OrderModel getOm() {
		return om;
	}
	public void setOm(OrderModel om) {
		this.om = om;
	}
	public GoodsModel getGm() {
		return gm;
	}
	public void setGm(GoodsModel gm) {
		this.gm = gm;
	}
	public String getInPriceView() {
		return inPriceView;
	}
}
