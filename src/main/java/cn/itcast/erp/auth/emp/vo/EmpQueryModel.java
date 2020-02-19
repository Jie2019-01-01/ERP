package cn.itcast.erp.auth.emp.vo;

import cn.itcast.erp.utils.base.BaseQueryModel;
import cn.itcast.erp.utils.format.FormatUtil;

public class EmpQueryModel extends EmpModel implements BaseQueryModel{

	private Long maxBirth;
	private String maxBirthView;
	public Long getMaxBirth() {
		return maxBirth;
	}

	public void setMaxBirth(Long maxBirth) {
		this.maxBirth = maxBirth;
		this.maxBirthView = FormatUtil.formatDate(maxBirth);
	}

	public String getMaxBirthView() {
		return maxBirthView;
	}
}
