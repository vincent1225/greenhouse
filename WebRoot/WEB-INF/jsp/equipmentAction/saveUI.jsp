<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>

<script>
function save(){
	try{
		//throw new Error("测试异常!");
		if(validateInput()){
			form1.submit();
		}
	}catch(e){
		alert(e.message);
		return false;
	};
}
</script>
<style>
	#inputList input{width:22px;}
</style>
</head>
<body >
	<!--添加用户信息-->
	<div class="AddOrEdit" id="addgreenhouseDiv">
	<s:form id="form1" action="greenhouse_%{ id == null ? 'add' : 'edit'}" target="listFrm" >
    	<s:hidden name="id" id="id"></s:hidden>
		<table style="table-layout:fixed;">
		  <thead>
			<tr class="t_title">
				<td colspan="6">添加大棚</td>
			</tr>
		  </thead>
		  <tr>
		  <td class="t_label">隶属园区名字</td><td class="t_edit" style="position:relative;"><s:textfield id="park" name="park"  cssClass="notNull"/> </td>
		  <td class="t_label">大棚编号</td><td class="t_edit" style="position:relative;"><s:textfield id="greenhouseId" name="greenhouseId"  cssClass="notNull"/> </td>
		  <td class="t_label">大棚名</td><td class="t_edit" style="position:relative;"><s:textfield id="name" name="name"  cssClass="notNull"/> </td>
			</tr>
			<tr>
			<td class="t_label">备注</td>	<td><s:textfield name="remark"/></td>
		  </tr>
	
		</table>
		<div class="td_btn" >
			<input id="saveBtn" type="image" src="${pageContext.request.contextPath}/images/save.gif" 
				onclick="save();return false;"/>
			<input type="image" src="${pageContext.request.contextPath}/images/exit.gif" 
				onclick="window.parent.document.getElementById('popFrm').style.height=0;return false;"/>
		</div>
	</s:form>
	
	</div>
</body>
</html>
