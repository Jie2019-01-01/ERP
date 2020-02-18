package cn.itcast.erp.auth.emp.vo;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.utils.format.FormatUtil;

public class EmpModel {

	public static final String EMP_LOGIN_OF_INFO = "loginEm";
	
	public static final Integer EMP_GENDER_OF_MAN = 1;
	public static final Integer EMP_GENDER_OF_WOMEN = 0;
	public static final String EMP_GENDER_OF_MAN_VIEW = "男";
	public static final String EMP_GENDER_OF_WOMEN_VIEW = "女";
	
	public static final Map<Integer, String> genderMap = new HashMap<Integer, String>();
	static {
		genderMap.put(EMP_GENDER_OF_MAN, EMP_GENDER_OF_MAN_VIEW);
		genderMap.put(EMP_GENDER_OF_WOMEN, EMP_GENDER_OF_WOMEN_VIEW);
	}
	
	private Long uuid;
	
	private String userName;
	private String pwd;
	private String realName;
	private String email;
	private String tele;
	private String address;
	
	private Integer gender;
	private Long birth;
	private Long lastLoginTime;
	private String lastLoginTimeView;
	private String genderView;
	private String birthView;
	
	private DepModel dm;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
		this.genderView = genderMap.get(gender);
	}

	public Long getBirth() {
		return birth;
	}

	public void setBirth(Long birth) {
		this.birth = birth;
		this.birthView = FormatUtil.formatDate(birth);
	}

	public DepModel getDm() {
		return dm;
	}

	public void setDm(DepModel dm) {
		this.dm = dm;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		this.lastLoginTimeView = FormatUtil.formatDate(lastLoginTime);
	}

	public String getLastLoginTimeView() {
		return lastLoginTimeView;
	}

	public String getGenderView() {
		return genderView;
	}

	public String getBirthView() {
		return birthView;
	}
}
