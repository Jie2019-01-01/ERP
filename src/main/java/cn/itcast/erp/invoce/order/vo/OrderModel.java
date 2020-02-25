package cn.itcast.erp.invoce.order.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.invoce.orderdetail.vo.OrderDetailModel;
import cn.itcast.erp.invoce.supplier.vo.SupplierModel;
import cn.itcast.erp.utils.format.FormatUtil;

public class OrderModel {

	//	订单类型
	public static final Integer ORDER_ORDERTYPE_OF_BUY = 1;
	public static final Integer ORDER_ORDERTYPE_OF_SALE = 2;
	public static final Integer ORDER_ORDERTYPE_OF_RETURN_BUY = 3;
	public static final Integer ORDER_ORDERTYPE_OF_RETURN_SALE = 4;
	
	public static final String ORDER_ORDERTYPE_OF_BUY_VIEW = "采购";
	public static final String ORDER_ORDERTYPE_OF_SALE_VIEW = "销售";
	public static final String ORDER_ORDERTYPE_OF_RETURN_BUY_VIEW = "采购退货";
	public static final String ORDER_ORDERTYPE_OF_RETURN_SALE_VIEW = "销售退货";

	public static final Map<Integer, String> orderTypeMap = new HashMap<Integer, String>();
	static {
		orderTypeMap.put(ORDER_ORDERTYPE_OF_BUY, ORDER_ORDERTYPE_OF_BUY_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_SALE, ORDER_ORDERTYPE_OF_SALE_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_RETURN_BUY, ORDER_ORDERTYPE_OF_RETURN_BUY_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_RETURN_SALE, ORDER_ORDERTYPE_OF_RETURN_SALE_VIEW);
	}
	
	// 订单状态
	// 定义为3位数
	//	第一位：订单类别	1.采购、2.销售
	//	第二位：第几阶段，例：121中，2表示进入第二阶段
	//	第三位：1.通过、2.未通过
	
	// 采购
	public static final Integer ORDER_STATUS_OF_BUY_NO_CHECK = 111;
	public static final Integer ORDER_STATUS_OF_BUY_PASS = 121;
	public static final Integer ORDER_STATUS_OF_BUY_NO_PASS = 120;
	public static final Integer ORDER_STATUS_OF_BUY_BUYING = 131;
	public static final Integer ORDER_STATUS_OF_BUY_IN_STORE = 131;
	public static final Integer ORDER_STATUS_OF_BUY_COMPLETE = 199;
	// 销售
	public static final Integer ORDER_STATUS_OF_SALE_NO_CHECK = 211;
	public static final Integer ORDER_STATUS_OF_SALE_PASS = 221;
	// 采购视图	
	public static final String ORDER_STATUS_OF_BUY_NO_CHECK_VIEW = "未审核";
	public static final String ORDER_STATUS_OF_BUY_PASS_VIEW = "通过";
	public static final String ORDER_STATUS_OF_BUY_NO_PASS_VIEW = "驳回";
	public static final String ORDER_STATUS_OF_BUY_BUYING_VIEW = "采购中";
	public static final String ORDER_STATUS_OF_BUY_IN_STORE_VIEW = "入库中";
	public static final String ORDER_STATUS_OF_BUY_COMPLETE_VIEW = "完成";
	// 销售视图
	public static final String ORDER_STATUS_OF_SALE_NO_CHECK_VIEW = "未审核";
	public static final String ORDER_STATUS_OF_SALE_PASS_VIEW = "通过";
	
	public static final Map<Integer, String> buyMap = new TreeMap<Integer, String>();
	public static final Map<Integer, String> saleMap = new TreeMap<Integer, String>();
	public static final Map<Integer, String> statusMap = new HashMap<Integer, String>();
	static {
		buyMap.put(ORDER_STATUS_OF_BUY_NO_CHECK, ORDER_STATUS_OF_BUY_NO_CHECK_VIEW);
		buyMap.put(ORDER_STATUS_OF_BUY_PASS, ORDER_STATUS_OF_BUY_PASS_VIEW);
		buyMap.put(ORDER_STATUS_OF_BUY_NO_PASS, ORDER_STATUS_OF_BUY_NO_PASS_VIEW);
		buyMap.put(ORDER_STATUS_OF_BUY_BUYING, ORDER_STATUS_OF_BUY_BUYING_VIEW);
		buyMap.put(ORDER_STATUS_OF_BUY_IN_STORE, ORDER_STATUS_OF_BUY_IN_STORE_VIEW);
		buyMap.put(ORDER_STATUS_OF_BUY_COMPLETE, ORDER_STATUS_OF_BUY_COMPLETE_VIEW);
		
		saleMap.put(ORDER_STATUS_OF_SALE_NO_CHECK, ORDER_STATUS_OF_SALE_NO_CHECK_VIEW);
		saleMap.put(ORDER_STATUS_OF_SALE_PASS, ORDER_STATUS_OF_SALE_PASS_VIEW);
		
		statusMap.putAll(buyMap);
		statusMap.putAll(saleMap);
	}
	
	//-----------------------------
	
	private Long uuid;

	private String orderNum;
	private Integer totalCount;
	
	private Double totalPrice;
	private Integer orderType;
	private Integer status;
	private Long createTime;
	private Long checkTime;
	private String totalPriceView;
	private String orderTypeView;
	private String statusView;
	private String createTimeView;
	private String checkTimeView;
	
	private EmpModel creater;
	private EmpModel checker;
	private EmpModel completer;
	private SupplierModel sm;
	private	Set<OrderDetailModel> odms;
	
	
	
	public Long getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Long checkTime) {
		this.checkTime = checkTime;
		if (checkTime!=null)
				this.checkTimeView = FormatUtil.formatDate(checkTime);
	}

	public String getCheckTimeView() {
		return checkTimeView;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
		this.orderTypeView = orderTypeMap.get(orderType);
	}

	public EmpModel getChecker() {
		return checker;
	}

	public void setChecker(EmpModel checker) {
		this.checker = checker;
	}

	public EmpModel getCompleter() {
		return completer;
	}

	public void setCompleter(EmpModel completer) {
		this.completer = completer;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
		this.totalPriceView = FormatUtil.formatMonmey(totalPrice);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
		this.statusView = statusMap.get(status);
	}

	public String getStatusView() {
		return statusView;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
		this.createTimeView = FormatUtil.formatDate(createTime);
	}

	public SupplierModel getSm() {
		return sm;
	}

	public void setSm(SupplierModel sm) {
		this.sm = sm;
	}

	public EmpModel getCreater() {
		return creater;
	}

	public void setCreater(EmpModel creater) {
		this.creater = creater;
	}

	public Set<OrderDetailModel> getOdms() {
		return odms;
	}

	public void setOdms(Set<OrderDetailModel> odms) {
		this.odms = odms;
	}

	public String getTotalPriceView() {
		return totalPriceView;
	}

	public String getOrderTypeView() {
		return orderTypeView;
	}

	public String getCreateTimeView() {
		return createTimeView;
	}
}
