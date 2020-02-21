package cn.itcast.erp.auth.menu.vo;

public class MenuModel {
	
	public static final Long MENU_SYSTEM_OF_UUID = 1L;
	
	private Long uuid;
	private String mname;
	private String murl;
	
	private MenuModel mm;

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
