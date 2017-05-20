<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户查询</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>

</head>
<body>
	<!---查询信息-->
	<div class="AddOrEdit" id="searchDiv">
	<s:form action="user_list" target="listFrm" id="f">
		<table>
		 <caption class="t_title">用户查询</caption>
		  <tr>
			<td class="t_label">登陆名</td>
			<td class="edit"><s:textfield name="loginName"  size="25"/></td>
			<td class="t_label">姓名</td>
			<td class="edit"><s:textfield name="name"  /></td>
		  </tr>
		</table>
		<div class="td_btn">
			<input type="image" src="${pageContext.request.contextPath}/images/search.gif" value=""
				onclick = "document.f.submit();"/>
			<input type="image" src="${pageContext.request.contextPath}/images/exit.gif" 
				onclick="window.parent.document.getElementById('popFrm').style.height=0;return false;"/>		</div>	
	</s:form>
	</div>
	<!--查询信息结束-->
</body>

</html>