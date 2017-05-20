<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>欢迎登录智能农业大棚管理系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico" />    
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico" />    
<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico" />  	

<script src="js/cloud.js" type="text/javascript"></script> 
 <object classid="clsid:CA69969C-2F27-41D3-954D-A48B941C3BA7" TYPE="application/xhanhan-activex" id="Biokey1" width="0" height="0"></object>
<style>
.redTip{color: red;font-size: 9999px;}
</style>
<script  for="Biokey1" event="OnCapture(ActionResult,ATemplate)" type="text/javascript" language="javascript">
	if(ActionResult==true){
		var sTemplate=Biokey1.EncodeTemplate1(ATemplate);  // 转为base64串
		//alert(sTemplate);
		var status = Biokey1.IdentificationFromStrInFPCacheDB(fpcHandle,sTemplate,9,3);
		if(status==-1){
			alert("非注册用户，请与管理员联系");
		}else{
			form1.loginName.value=aStr[status][0];
			form1.password.focus();
		}
	}
</script>
<script>
	$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    });  
	}); 
// 在被嵌套时就刷新上级窗口
if(window.parent != window){
	window.parent.location.reload(true);
}
</script> 
</head>
<body style="background-color:#4bca41; background-image:url(${pageContext.request.contextPath}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<s:form action="user_login" name="form1">
	<s:hidden name="finger" id="finger" ></s:hidden>
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
	    <ul>
		    <li><s:textfield name="loginName" size="20" tabindex="1" cssClass="loginuser" id="loginNameInput"/></li>
		    <li><s:password name="password" id="loginpwd" size="20" tabindex="2" cssClass="loginpwd" showPassword="false" /></li>
		    <li><s:submit cssClass="loginbtn" value="登录" tabindex="3" /></li>
	    </ul>  <span class="redTip"><s:fielderror/></span>
    	<%--<div class="formtext"><b><s:fielderror/></b></div>
    --%></div>
    </div>
   
    </s:form>
    <div style="width:100%;position:absolute;bottom:0;overflow:hedden;height:50px;color:#666;text-align:center;">
    版权所有:&copy;*****信息技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开发：*********有限公司
    </div>
</body>

</html>
