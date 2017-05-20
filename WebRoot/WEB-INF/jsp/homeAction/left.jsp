<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>导航菜单</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>	

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});
</script>
<style>
	.menuson{
		list-style-type:none;
		clear:both;		
	}
	.title{
		clear:both;
	}
</style>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>业务导航</div>
    <dl class="leftmenu">
        
    <!-- 显示一级菜单 -->
    <s:iterator value="#application.topPrivilegeList" status="L">
    <s:if test="#session.user.hasPrivilegeByName(name)">
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/images/leftico0${(L.index+1)%4}.png" /></span>
    	${name}
    </div>
    	<!-- 显示二级菜单 -->
    	<ul class="menuson">
	    	<s:iterator value="children">
		    	<s:if test="#session.user.hasPrivilegeByName(name)">
					<li>
						<cite></cite>
						<a href="${pageContext.request.contextPath}${url}.action" target="rightFrame">${name}</a>
						<i></i>
					</li>
				</s:if>
			</s:iterator>
		</ul>
    </dd>
    </s:if>
    </s:iterator>
    
    </dl>
    
</body>
</html>
