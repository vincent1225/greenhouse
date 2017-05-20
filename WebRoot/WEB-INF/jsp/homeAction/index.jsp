<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>xxxx集团智能农业大棚管理系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>	
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
	  <frame name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" 
	  		src="${pageContext.request.contextPath}/home_top.action"/>
	  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		    <frame name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" 
		    	src="${pageContext.request.contextPath}/home_left.action" />
		    <frame name="rightFrame" scrolling="yes" id="rightFrame" title="rightFrame" 
		    	src="${pageContext.request.contextPath}/home_right.action" />
	  </frameset>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
