<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</script>
<script type="text/javascript">
	$(function(){
		// 提交表单
		$('#submitOrder').click(function(){
			// 解锁
			$('.supplier').attr("disabled",false);
			$('.goodsType').attr("disabled",false);
			$('.goods').attr("disabled",false);
			$('form:first').submit();
		});
		
		// 供应商
		$('.supplier').change(function(){
			var supplierUuid = $(this).val();
			$.post('order_ajaxGetGtmBySm.action',{'supplierUuid':supplierUuid},function(data){
				// 类别
				$('.goodsType').empty();
				var $gtmList = data.gtmList;
				var $op = '';
				for(var i=0; i<$gtmList.length; i++){
					$op += '<option value="'+$gtmList[i].uuid+'">'+$gtmList[i].gtname+'</option>';
				}
				$('.goodsType').append($op);
				// 商品
				$('.goods').empty();
				var $gmList = data.gmList;
				$op = '';
				for(var i=0; i<$gmList.length; i++){
					$op += '<option value="'+$gmList[i].uuid+'">'+$gmList[i].gname+'</option>';
				}
				$('.goods').append($op);
				
				$('.num').val(1);
				$('.prices').val($gmList[0].inPriceView);
				setTotal($('.total').parent());
				setAll();
			});
		});
		
		// 类别
		$('.goodsType').live('change',function(){
			var $tr = $(this).parent().parent();
			var gtmUuid = $(this).val();
			// 获取已使用的商品uuid
			var used = '';
			$('.goods').each(function(){
				used += $(this).val()+',';
			});
			$.post('order_ajaxGetGmByGtm',{'gtmUuid':gtmUuid,'used':used},function(data){
				$tr.children('td:eq(1)').empty();
				var $gmList = data.gmList;
				var $select = $('<select name="" class="goods" style="width:200px">');
				var $op = '';
				for(var i=0; i<$gmList.length; i++){
					$op += '<option value="'+$gmList[i].uuid+'">'+$gmList[i].gname+'</option>';
				}
				$select.append($op);
				$tr.children('td:eq(1)').append($select);
				// 设置单价和数量
				$tr.children('td:eq(2)').children('input').val(1);
				$tr.children('td:eq(3)').children('input').val($gmList[0].inPriceView);
				setTotal($tr);
				setAll();
			});
		});
		
		// 商品
		$('.goods').live('change',function(){
			var $tr = $(this).parent().parent();
			$goodsUuid = $(this).val();
			$.post('order_ajaxGetGmByUuid',{'goodsUuid':$goodsUuid},function(data){
				// 设置单价和数量
				$tr.children('td:eq(2)').children('input').val(1);
				$tr.children('td:eq(3)').children('input').val(data.inPriceView);
				setTotal($tr);
				setAll();
			});
		});
		
		// 上锁
		var flag = true;
		// 新建
		$('#add').click(function(){


			$('.supplier').attr("disabled",true);
			$('.goodsType').attr("disabled",true);
			$('.goods').attr("disabled",true);
			
			if(!flag) {
				alert('频率过快..');
				return 
			}
			flag = false;
			
			var $tr = $('<tr align="center" bgcolor="#FFFFFF"></tr>');
			
			var $td1 = $('<td height="30"></td>');
			var $select = $('<select name="" class="goodsType" style="width:200px"></select>');
			// 获取商品的uuid数组
			var $gm = $('.goods');
			var used = '';
			for(var i=0; i<$gm.length; i++){
				used += $gm[i].value+",";
			}
			// 访问后台，过滤数据
			$.post('order_ajaxGetGtmAndGm.action',{'supplierUuid':$('.supplier').val(),'used':used},function(data){
				var $gtmList = data.gtmList;
				for(var i=0; i<$gtmList.length; i++){
					$op = ('<option value="'+$gtmList[i].uuid+'">'+$gtmList[i].gtname+'</option>');
					$select.append($op);
				}
				$td1.append($select);
				$tr.append($td1);
				
				var $gmList = data.gmList;
				var $td2 = $('<td></td>');
				$select = $('<select name="goodsUuids" class="goods" style="width:200px"></select>');
				if($gmList==null) return;
				for(var i=0; i<$gmList.length; i++){
					$op = ('<option value="'+$gmList[i].uuid+'">'+$gmList[i].gname+'</option>');
					$select.append($op);
				}
				$td2.append($select);
				$tr.append($td2);
				
				var $td3 = $('<td><input name="nums" class="num order_num" style="width:67px;border:1px solid black;text-align:right;padding:2px" type="text" value="1"></td>');
				$tr.append($td3);
				
				var $td4 = $('<td><input name="prices" class="prices order_num" style="width:93px;border:1px solid black;text-align:right;padding:2px" type="text" value="'+$gmList[0].inPriceView+'"> 元</td>');
				$tr.append($td4);
				
				var $td5 = $('<td class="total" align="right">'+$gmList[0].inPriceView+'&nbsp;元</td>');
				$tr.append($td5);
				
				var $td6 = $('<td><a class="deleteBtn delete xiu" value="4"><img src="images/icon_04.gif"> 删除</a></td>');
				$tr.append($td6);
				
				$('#finalTr').before($tr);
				setAll();
				
			});
			
			flag = true;
		});
		
		// 删除一条
		$('.deleteBtn').live('click',function(){
			if($('.deleteBtn').length>1){
				var $tr = $(this).parent().parent();
				$tr.remove();
				setAll();
			}else{
				alert('不要再删了...');
			}
		});
		
		// 采购数量
		$('.num').live('keyup',function(){
			$tr = $(this).parent().parent();
			format_input_num2($(this));
			setTotal($tr);
		});
		// 单价
		$('.prices').live('keyup',function(){
			$tr = $(this).parent().parent();
			format_input_num($(this));
			setTotal($tr);
		});
		
		// 设置合计
		function setTotal(obj){
			var $num = $(obj).children('td:eq(2)').children('input').val();
			var $price = $(obj).children('td:eq(3)').children('input').val();
			$(obj).children('td:eq(4)').html(toFixed($num*$price)+' 元');
			setAll();
		}

		// 设置总计
		function setAll(){
			var sum = 0;
			$('.num').each(function(){
				var $tr = $(this).parent().parent();
				var $price = $tr.children('td:eq(3)').children('input').val();
				var $all = $(this).val() * $price;
				sum += $all;
			});
			$('.all').html(toFixed(sum)+' 元');
		}
		
		function format_input_num(obj){
		   // 清除"数字"和"."以外的字符
		   obj.val(obj.val().replace(/[^\d.]/g,""));
		   // 验证第一个字符是数字
		   obj.val(obj.val().replace(/^\./g,""));
		   // 只保留第一个, 清除多余的
		   obj.val(obj.val().replace(/\.{2,}/g,"."));
		   obj.val(obj.val().replace(".","$#$").replace(/\./g,"").replace("$#$","."));
		   // 只能输入两个小数
		   obj.val(obj.val().replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'));
		}
		
		function format_input_num2(obj){
		   // 清除"数字"和"."以外的字符
		   obj.val(obj.val().replace(/[^\d]/g,""));
		   //第一位数字不能为0
		   obj.val(obj.val().replace(/^[0]+[0-9]*$/gi, "")); 
		}

		function toFixed(num){
			return (Number(num)).toFixed(2);
		}
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">订单管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="order_inSave.action" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="24">&nbsp;</td>
					</tr>
					<tr>
						<td width="68px" height="30">供应商：</td>
						<td width="648px">
							<s:select cssClass="kuan supplier" list="supplierList" cssStyle="width:190px"
								listKey="uuid" listValue="sname" name="om.sm.uuid"/>
						</td>
						<td height="30">
							<a id="add"><img src="images/can_b_02.gif" border="0" /> </a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table id="order" width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td width="25%" height="30">商品类别</td>
						<td width="25%">商品名称</td>
						<td width="10%">采购数量</td>
						<td width="15%">单价</td>
						<td width="15%">合计</td>
						<td width="10%">操作</td>
					</tr>
					<tr align="center" bgcolor="#FFFFFF">
						<td height="30">
							<s:select cssClass="goodsType" list="gtmList" cssStyle="width:200px"
								listKey="uuid" listValue="gtname"/>
						</td>
						<td>
							<s:select cssClass="goods" list="gmList" cssStyle="width:200px"
								listKey="uuid" listValue="gname" name="goodsUuids"/>
						</td>
						<td><s:textfield name="nums" cssClass="num order_num" 
								cssStyle="width:67px;border:1px solid black;text-align:right;padding:2px" 
								value="1"/>
						</td>
						<td>
							<s:textfield name="prices" cssClass="prices order_num" 
								cssStyle="width:93px;border:1px solid black;text-align:right;padding:2px" 
								value="%{#gmList[0].inPriceView}"></s:textfield> 元
						</td>
						<td class="total" align="right">${gmList.get(0).inPriceView }&nbsp;元</td>
						<td>
							<a class="deleteBtn delete xiu" value="4"><img src="images/icon_04.gif" /> 删除</a>
						</td>
					</tr>
					<tr id="finalTr" align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td height="30" colspan="4" align="right">总&nbsp;计:&nbsp;</td>
						<td class="all" width="16%" align="right">${gmList.get(0).inPriceView }&nbsp;元</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<div class="order-botton">
				<div style="margin:1px auto auto 1px;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td>
					    	<a href="javascript:void(0)" id="submitOrder"><img src="images/order_tuo.gif" border="0" /></a>
					    </td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="images/order_tuo.gif" border="0" /></a></td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="images/order_tuo.gif" border="0" /></a></td>
					  </tr>
					</table>
				</div>
			</div>
			</div>
		</s:form>
	</div>
	
	<div class="content-bbg"></div>
</div>
