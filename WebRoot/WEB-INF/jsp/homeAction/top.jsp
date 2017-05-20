<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>xxxx集团智能农业大棚管理系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>	
</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="home_index.action" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    	<li><a href="#" target="rightFrame" class="selected"><img src="images/wyd001.png" title="工作台" /><h2>数据监控</h2></a></li>
    	<li><a href="#" target="rightFrame"><img src="images/wyd002.png" title="模型管理" /><h2>设备控制</h2></a></li>
    	<li><a href="#"  target="rightFrame"><img src="images/wyd003.png" title="模块设计" /><h2>基础信息</h2></a></li>
    	<li><a href="#"  target="rightFrame"><img src="images/wyd004.png" title="常用工具" /><h2>系统管理</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><a href="javascript:window.history.go(-1);">后退</a></li>
	<li><a href="javascript:window.history.go(1);">前进</a></li>
    <li><a href="user_editPwdUI.action?id=${user.id}" target="rightFrame">修改密码</a></li>
    <li><a href="user_logout.action" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>用户名:${user.loginName} 姓名:${user.name}</span><%--
    <i>消息</i>
    <b>5</b>
    --%></div>    
    
    </div>

</body>
</html>
