package cn.itcast.erp.invoce.store.vo;

import cn.itcast.erp.auth.emp.vo.EmpModel;

public class StoreModel {

	private Long uuid;
	
	private String sname;
	private String address;
	
	private EmpModel em;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmpModel getEm() {
		return em;
	}

	public void setEm(EmpModel em) {
		this.em = em;
	}
	
}
