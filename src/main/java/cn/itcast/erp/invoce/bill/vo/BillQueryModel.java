package cn.itcast.erp.invoce.bill.vo;

public class BillQueryModel {

	private Integer orderType;
	private Integer type = -1;
	private Long startTime;
	private Long endTime;
	private Long supplierUuid;
	private Long goodsUuid;
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getSupplierUuid() {
		return supplierUuid;
	}
	public void setSupplierUuid(Long supplierUuid) {
		this.supplierUuid = supplierUuid;
	}
	public Long getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(Long goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
}