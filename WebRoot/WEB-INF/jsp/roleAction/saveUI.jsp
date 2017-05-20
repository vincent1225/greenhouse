<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岗位设置</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<script type="text/javascript">
function save(){
	try{
		//throw new Error("测试异常!");
		if(validateInput()){
			form1.submit();
		}
	}catch(e){
		alert(e.message);
		return false;
	}
}
</script>

</head>
<body >
	<!--添加岗位信息-->
	<div class="AddOrEdit" >
	<s:form id="form1" action="role_%{ id == null ? 'add' : 'edit'}" target="listFrm" >
    	<s:hidden name="id" id="id"></s:hidden>
		<table style="table-layout:fixed;">
			<caption class="t_title">添加岗位</caption>
		  <tr>
			<td class="t_label">岗位名称</td>
			<td class="t_edit" style="position:relative;"><s:textfield id="name" name="name"  size="25"	/> </td>
			</tr>
			<tr>
			<td class="t_label">岗位说明</td>		<td><s:textfield name="remark" id="remark" size="25"/></td>
		</tr>
		</table>
		<div class="td_btn" >
			<input id="saveBtn" type="image" src="${pageContext.request.contextPath}/images/save.gif" value="" 
				onclick="save();return false;"/>
			<input type="image" src="${pageContext.request.contextPath}/images/exit.gif" 
				onclick="window.parent.document.getElementById('popFrm').style.height=0;return false;"/>		</div>
	</s:form>
	
	</div>
	<!--添加换热站信息结束-->
</body>
</html>
