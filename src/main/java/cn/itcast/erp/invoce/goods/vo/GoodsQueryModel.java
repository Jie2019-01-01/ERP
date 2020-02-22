package cn.itcast.erp.invoce.goods.vo;

import cn.itcast.erp.utils.base.BaseQueryModel;

public class GoodsQueryModel extends GoodsModel implements BaseQueryModel{

	private Double inMaxPrice;
	private Double outMaxPrice;
	public Double getInMaxPrice() {
		return inMaxPrice;
	}
	public void setInMaxPrice(Double inMaxPrice) {
		this.inMaxPrice = inMaxPrice;
	}
	public Double getOutMaxPrice() {
		return outMaxPrice;
	}
	public void setOutMaxPrice(Double outMaxPrice) {
		this.outMaxPrice = outMaxPrice;
	}
}