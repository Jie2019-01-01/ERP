<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='curPage']").val(1);
			$("form:first").submit();
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">进货审核</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="order_inCheckList.action" method="post"> 
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td  height="30">下单时间:</td>
						<td>
							<input value="${oqm.createTimeView }" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
							<s:hidden name="oqm.createTime"/>
						</td>
						<td>到</td>
						<td>
							&nbsp;&nbsp;<input value="${oqm.createTimeView }" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
							<s:hidden name="oqm.maxCreateTime"/>
						</td>
						<td>总量:</td>
						<td><s:textfield name="oqm.totalCount" size="14" /></td>
						<td>到 </td>
						<td>&nbsp;&nbsp;<s:textfield name="oqm.maxTotalCount" size="14" /></td>
					</tr>
					<tr>
						<td>总额:</td>
						<td><s:textfield name="oqm.totalPrice" size="14" /></td>
						<td>到</td>
						<td>&nbsp;&nbsp;<s:textfield name="oqm.maxTotalPrice" size="14" /></td>
						<td>下单人:</td>
						<td><s:textfield name="oqm.creater.realName" size="14" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;&nbsp;<a id="query"> 
							<img src="images/can_b_01.gif" border="0" /> </a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td width="30%" height="30">订单号</td>
						<td width="12%">供应商</td>
						<td width="10%">制单人</td>
						<td width="20%">制单时间</td>
						<td width="10%">订单商品总量</td>
						<td width="12%">订单总金额</td>
						<td width="6%">审核</td>
					</tr>
					<s:iterator value="orderList">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30">${orderNum }</td>
							<td>${sm.sname }</td>
							<td>${creater.realName }</td>
							<td>${createTimeView }</td>
							<td>${totalCount }</td>
							<td align="right">${totalPriceView }  元</td>
							<td>
								<s:if test="status==@cn.itcast.erp.invoce.order.vo.OrderModel@ORDER_STATUS_OF_BUY_NO_CHECK">
									<s:a action="order_inCheck.action">
										审核
										<s:param name="om.uuid" value="uuid"/>
									</s:a>
								</s:if>
								<s:else>
									<span style="color:red">${statusView }</span>
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
				<s:include value="../../tools/paging.jsp"/>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
