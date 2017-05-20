<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户信息列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<script>
</script>
</head>
<body>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>系统管理</li>
			<li>阈值管理</li>
		</ul>
    </div>
    <div class="rightinfo">
	<iframe frameborder="0" id="popFrm" name="popFrm" width="100%" height="0" src="" scrolling="no"></iframe>

    <div class="tools">
    	<ul class="tab">
        <li id="btn1"  class="selected"><span></span>阈值管理</li>
        </ul>
		<ul class="toolbar">
		<li id="SearchBtn"><span><img src="images/ico06.png" width="20"/></span>查询</li>
		<li id="AddHSBtn"><span><img src="images/t01.png" width="20"/></span>添加换热站</li>
    	</ul>
	</div>
    <iframe  id="listFrm" name="listFrm" width="100%" height="1000px" scrolling="yes" frameborder="0" scrolling="yes" 
    	src="${pageContext.request.contextPath}/threshold_list.action"></iframe>
    </div>
</body>
</html>
