<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大棚查询</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>

</head>
<body>
	<!---查询信息-->
	<div class="AddOrEdit" id="searchDiv">
	<s:form action="greenhouse_list" target="listFrm" >
		<table>
		 <caption class="t_title">大棚查询</caption>
		  <tr>
			<td class="t_label">大棚名字</td>
			<td class="edit"><s:textfield name="name"  size="25"/></td>
		  </tr>
		</table>
		<div class="td_btn">
			<input type="image" src="${pageContext.request.contextPath}/images/search.gif" value=""/>
			<input type="image" src="${pageContext.request.contextPath}/images/exit.gif" 
				onclick="window.parent.document.getElementById('popFrm').style.height=0;return false;"/>		</div>	
	</s:form>
	</div>
	<!--查询信息结束-->
</body>

</html>