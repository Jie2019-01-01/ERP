<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<span class="page_title">进货订单管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="order_inList.action" method="post"> 
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="30">订单状态</td>
						<td> 
							<s:select list="@cn.itcast.erp.invoce.order.vo.OrderModel@buyMap" 
								cssClass="kuan" headerKey="-1" headerValue="---请-选-择--" 
								cssStyle="width:113px" name="oqm.status"/>
						</td>
						<td>下单人:</td>
						<td><s:textfield name="oqm.creater.realName" size="14" /></td>
						<td>总量:</td>
						<td><s:textfield name="oqm.totalCount" size="14" /></td>
						<td>到 </td>
						<td>&nbsp;&nbsp;<s:textfield name="oqm.MaxTotalCount" size="14" /></td>
						<td><a id="query"> 
							<img src="images/can_b_01.gif" border="0" /> </a>
						</td>
					</tr>
					<tr>
						<td>下单时间:</td>
						<td>
							<s:textfield name="oqm.createTimeView" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
							<s:hidden name="oqm.createTime"/>
						</td>
						<td>到</td>
						<td>
							<s:textfield name="oqm.maxCreateTimeView" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
							<s:hidden name="oqm.maxCreateTime"/>
						</td>
						<td>总额:</td>
						<td><s:textfield name="oqm.totalPrice" size="14" /></td>
						<td>到</td>
						<td>&nbsp;&nbsp;<s:textfield name="oqm.maxTotalPrice" size="14" /></td>
						<td>
							<a href="order_inInput.action">
								<img src="images/can_b_02.gif" border="0" /> 
							</a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td width="15%" height="30">订单号</td>
						<td width="19%">供应商</td>
						<td width="10%">制单人</td>
						<td width="20%">制单时间</td>
						<td width="10%">订单商品总量</td>
						<td width="12%">订单总金额</td>
						<td width="5%">详情</td>
						<td width="9%">订单状态</td>
					</tr>
					<s:iterator value="orderList">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30">${orderNum }</td>
							<td>${sm.sname }</td>
							<td>${creater.realName }</td>
							<td>${createTimeView }</td>
							<td>${totalCount }</td>
							<td align="right">${totalPriceView } 元</td>
							<td>
								<a href="inDetailList.jsp" class="xiu">详情</a>
							</td>
							<td>${statusView}</td>
						</tr>
					</s:iterator>
				</table>
				<s:include value="../../tools/paging.jsp"/>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
