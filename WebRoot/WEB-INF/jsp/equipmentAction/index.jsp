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
			<li>大棚管理</li>
			<li>大棚信息管理</li>
		</ul>
    </div>
    <div class="rightinfo">
    <iframe  marginheight="0" marginwidth="0" frameborder="0" scrolling="no" width="100%" height="0" id="popFrm" name="popFrm" ></iframe>
    <div class="tools">
    	<ul class="tab">
        <li id="btn1"  class="selected"><span></span>大棚信息展示</li>
        </ul>
		<ul class="toolbar">
			<s:a target="popFrm" action="greenhouse_queryUI" onclick="javascript:document.getElementById('popFrm').style.height='95px';">
				<li><span>
					<img src="${pageContext.request.contextPath}/images/ico06.png" width="20"/>
					</span>查询
				</li>
			</s:a>
			<s:a target="popFrm" action="greenhouse_addUI" onclick="javascript:document.getElementById('popFrm').style.height='145px';">
				<li><span>
					<img src="${pageContext.request.contextPath}/images/t01.png" width="20"/>
					</span>添加大棚
				</li>
			</s:a>	
    	</ul>
	</div>
    <iframe  id="listFrm" name="listFrm" width="100%" height="1000px" scrolling="yes" frameborder="0" scrolling="yes" 
    	src="${pageContext.request.contextPath}/greenhouse_list.action"></iframe>
    </div>
</body>
</html>
