package cn.itcast.erp.invoce.goodstype.vo;

import cn.itcast.erp.invoce.supplier.vo.SupplierModel;

public class GoodsTypeModel {

	private Long uuid;
	
	private String gtname;
	
	private SupplierModel sm;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getGtname() {
		return gtname;
	}

	public void setGtname(String gtname) {
		this.gtname = gtname;
	}

	public SupplierModel getSm() {
		return sm;
	}

	public void setSm(SupplierModel sm) {
		this.sm = sm;
	}
	
}
