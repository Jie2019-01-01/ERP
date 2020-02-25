package cn.itcast.erp.invoce.order.vo;

import cn.itcast.erp.utils.base.BaseQueryModel;
import cn.itcast.erp.utils.format.FormatUtil;

public class OrderQueryModel extends OrderModel implements BaseQueryModel{

	private Integer MaxTotalCount;
	private Double MaxTotalPrice;
	private Long maxCreateTime;
	private String maxCreateTimeView;
	
	public Integer getMaxTotalCount() {
		return MaxTotalCount;
	}
	public void setMaxTotalCount(Integer maxTotalCount) {
		MaxTotalCount = maxTotalCount;
	}
	public Double getMaxTotalPrice() {
		return MaxTotalPrice;
	}
	public void setMaxTotalPrice(Double maxTotalPrice) {
		MaxTotalPrice = maxTotalPrice;
	}
	public Long getMaxCreateTime() {
		return maxCreateTime;
	}
	public void setMaxCreateTime(Long maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
		this.maxCreateTimeView = FormatUtil.formatDate(maxCreateTime);
	}
	public String getMaxCreateTimeView() {
		return maxCreateTimeView;
	}
}