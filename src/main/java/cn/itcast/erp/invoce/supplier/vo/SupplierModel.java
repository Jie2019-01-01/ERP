package cn.itcast.erp.invoce.supplier.vo;

import java.util.HashMap;
import java.util.Map;

public class SupplierModel {

	public static final Integer SUPPLIER_PATTERN_OF_DELIVER = 0;
	public static final Integer SUPPLIER_PATTERN_OF_TAKE = 1;
	public static final String SUPPLIER_PATTERN_OF_DELIVER_VIEW = "送货";
	public static final String SUPPLIER_PATTERN_OF__VIEW = "自取";
			
	public static final Map<Integer, String> patternMap = new HashMap<Integer, String>();
	static {
		patternMap.put(SUPPLIER_PATTERN_OF_DELIVER, SUPPLIER_PATTERN_OF_DELIVER_VIEW);
		patternMap.put(SUPPLIER_PATTERN_OF_TAKE, SUPPLIER_PATTERN_OF__VIEW);
	}
	
	private Long uuid;
	
	private String sname;
	private String address;
	private String tele;
	private String contact;
	
	private Integer pattern;
	private String patternView;

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

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getPattern() {
		return pattern;
	}

	public void setPattern(Integer pattern) {
		this.pattern = pattern;
		this.patternView = patternMap.get(pattern);
	}

	public String getPatternView() {
		return patternView;
	}
}
