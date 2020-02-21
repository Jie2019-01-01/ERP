package cn.itcast.erp.auth.menu.vo;

import java.util.Set;

import cn.itcast.erp.auth.role.vo.RoleModel;

public class MenuModel {
	
	public static final Long MENU_SYSTEM_OF_UUID = 1L;
	
	private Long uuid;
	private String mname;
	private String murl;
	
	private MenuModel mm;
	
	private Set<RoleModel> rms;
	
	public Set<RoleModel> getRms() {
		return rms;
	}

	public void setRms(Set<RoleModel> rms) {
		this.rms = rms;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public MenuModel getMm() {
		return mm;
	}

	public void setMm(MenuModel mm) {
		this.mm = mm;
	}
}
