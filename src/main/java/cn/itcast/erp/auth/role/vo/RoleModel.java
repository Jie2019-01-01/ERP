package cn.itcast.erp.auth.role.vo;

import java.util.Set;

import cn.itcast.erp.auth.menu.vo.MenuModel;
import cn.itcast.erp.auth.res.vo.ResModel;

public class RoleModel {

	private Long uuid;
	
	private String rname;
	private String rcode;
	
	private Set<ResModel> reses;
	private Set<MenuModel> mms;
	
	public Set<MenuModel> getMms() {
		return mms;
	}
	public void setMms(Set<MenuModel> mms) {
		this.mms = mms;
	}
	public Set<ResModel> getReses() {
		return reses;
	}
	public void setReses(Set<ResModel> reses) {
		this.reses = reses;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
}
