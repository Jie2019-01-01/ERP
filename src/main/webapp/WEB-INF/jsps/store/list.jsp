<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='curPage']").val(1);
			$("form:first").submit();
		});
	});
	function showMsg(msg,uuid){
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML=msg;
		top.$('hid-action').value="store_delete.action?sm.uuid="+uuid;
		top.lock.show();
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">仓库管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="store_list.action" method="post"> 
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="10%">仓库名称:</td>
						<td width="30%" colspan="4"><s:textfield name="sqm.sname" size="20" /></td>
							
						<td width="10%">管&nbsp;理&nbsp;员:</td>
						<td  width="30%"><s:textfield name="sqm.em.realName" size="20" /></td>
						
						<td width="">
							<a id="query"><img src="images/can_b_01.gif" border="0" /> </a></td>
							
						<td>
							<a href="store_input.action"><img src="images/can_b_02.gif" border="0" /> </a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td width="17%" height="30">仓库名称</td>
						<td width="17%">仓库管理员</td>
						<td width="30%">仓库地址</td>
						<td width="16%">操作</td>
					</tr>
					<s:iterator value="storeList">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30">${sname }</td>
							<td>${em.realName }</td>
							<td align="left">&nbsp;${address }</td>
							<td>
								<img src="images/icon_3.gif" /> 
								<span style="line-height:12px; text-align:center;">
									<s:a action="store_input.action" cssClass="xiu">
										修改
										<s:param name="sm.uuid" value="uuid"/>
									</s:a>
								</span> 
								<img src="images/icon_04.gif" /> 
								<span style="line-height:12px; text-align:center;"> 
									<a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除该项数据？',${uuid})">删除</a>
								</span>
							</td>
						</tr>
					</s:iterator>
				</table>
				<s:include value="../tools/paging.jsp"/>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
