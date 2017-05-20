<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>实时信息列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>实时数据管理</li>
			<li>实时信息采集</li>
		</ul>
    </div>
    <div class="rightinfo">
   <s:form  target="listFrm" id="f">
    <div class="tools">
    	<ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=1';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;空气温度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=2';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;空气湿度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=3';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;土壤温度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=4';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;土壤湿度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=5';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;光照强度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=6';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;二氧化碳</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=7';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;氨气浓度</li>
        </ul>
        <ul class="tab" onclick="javascript:document.f.action='${pageContext.request.contextPath}/realtime_list.action?equipmentKind=8';document.f.submit()">
       <li id="btn1"  class="selected">&nbsp;土壤PH</li>
        </ul>
        <ul class="toolbar" style="height:50px">
        <li>
		<!--  list : 源数据 (可以在action方法里从数据库获取list) -->
		<%--listKey : 下拉选项的key --%>
		<%--listValue : 下拉选项的value  --%>
		<%--name 传给action --%>
		<font size="20">园区选择:</font>	
			<s:select 
			style="border: none;outline:none"
			list="parks"
			listKey="id" 
			listValue="name"
			name ="park_id"  
			></s:select>
		<font size="20">大棚选择:</font>	
			<s:select 
			style="border: none;outline:none"
			list="greenhouses"
			listKey="id"
			listValue="name"
			name = "greenhouse_id"
			></s:select>
		</li>
    	</ul>
	</div>
	</s:form>
    <iframe  id="listFrm" name="listFrm" width="100%" height="1000px" scrolling="yes" frameborder="0" scrolling="yes" 
    	src="${pageContext.request.contextPath}/realtime_list.action"></iframe>
    </div>
</body>
</html>
