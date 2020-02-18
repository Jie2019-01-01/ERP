<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	$(function(){
		var $curPage = ${curPage};
		var $lastPage = ${lastPage};
		// 根据页数显示或隐藏按钮
		if($curPage==1){
			$('#fir').css('display','none');
			$('#pre').css('display','none');
		}
		if($curPage==$lastPage){
			$('#last').css('display','none');
			$('#next').css('display','none');
		}
		// 首页
		$('#fir').click(function(){
			$('[name=curPage]').val(1);
			$("form:first").submit();
		});
		// 尾页
		$('#last').click(function(){
			$('[name=curPage]').val($lastPage);
			$("form:first").submit();
		});
		// 下一页
		$('#next').click(function(){
			$('[name=curPage]').val($curPage*1+1);
			$("form:first").submit();
		});
		// 上一页
		$('#pre').click(function(){
			$('[name=curPage]').val($curPage-1);
			$("form:first").submit();
		});
	});
</script>
<s:hidden name="curPage"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="51%">&nbsp;</td>
		<td width="13%">共${totalRecords}条记录
		<td width="6%">
			<a id="fir" class="sye">首&nbsp;&nbsp;页</a>
		</td>
		<td width="6%">
			<a id="pre" class="sye">上一页</a>
		</td>
		<td width="6%">
			<a id="next" class="sye">下一页</a>
		</td>
		<td width="6%">
			<a id="last" class="sye">末&nbsp;&nbsp;页</a>
		</td>
		<td width="12%">当前第<span style="color:red;">${curPage}</span>/${lastPage}页</td>
	</tr>
</table>