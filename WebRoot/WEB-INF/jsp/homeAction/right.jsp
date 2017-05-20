<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>xxxx集团智能农业大棚管理系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>	
<script>

function resizeimg(obj)
{
	//alert(window.screen.availHeight);
	maxW = document.body.availWidth;
	maxH = window.screen.availHeight;
    var imgW=obj.width;
    var imgH=obj.height;
    if(imgW>maxW||imgH>maxH){       
        var ratioA=imgW/maxW;
        var ratioB=imgH/maxH;               
        if(ratioA>ratioB){
            imgW=maxW;
            imgH=maxW*(imgH/imgW);
        }else{
            imgH=maxH;
            imgW=maxH*(imgW/imgH);
        }  
        obj.width=imgW;
        obj.height=imgH;
    }
}


</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    	<li>>首页</li>
    </ul>
    </div>
    <div class="welinfo">
    <span><img src="${pageContext.request.contextPath}/images/dapeng.jpg"  alt="大棚"  width="1100" height="600" onload="resizeimg(this);" /></span>
    </div>
    <%--
    <div class="mainindex">
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>你好【${user.name}】，欢迎使用信息管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    </div>
    </div>
	--%>
</body>

</html>
