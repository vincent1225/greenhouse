<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<script type="text/javascript">
window.onload = function(){ 
	var oldPwd = document.getElementById("oldPwd");
	var password = document.getElementById("password");
	var newPwd = document.getElementById("newPwd");
	/*oldPwd.onblur = function(){
		ajax('user_checkOldPwd.action','oldPwd='+ Trim(oldPwd.value),function(str){
			alert(str);
			if(str=="0"){
				alert("非原密码，请重新输入!");
				oldPwd.focus();
				return false;
			}
		});		
	};*/
	newPwd.onblur =function(){
		if(Trim(password.value)!=Trim(newPwd.value)){
			alert("两次密码不一致，请重新输入！");
			return false;
		}
	};
};

function save(){
	try{
		//throw new Error("测试异常!");
		if(validateInput()){
			form1.submit();
		}
	}catch(e){
		alert(e.message);
		return false;
	}
}
</script>

</head>
<body >
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>修改密码</li>
		</ul>
    </div>
    
    <div class="rightinfo">
   	 <div class="tools">
    
	<div class="AddOrEdit" >
	<s:form id="form1" name="form1" action="user_editPwd" style="margintop:10px;">
    	<s:hidden name="id" id="id"></s:hidden>
		<table >
			<caption class="t_title">修改密码</caption>
		  <%--<tr >
			<td class="t_label"><span class="redTip">*</span>原密码</td>
			<td class="t_edit" >
			<input id="oldPwd" name="oldPwd" type="password" class="notNull" style="width:399px;"/> </td>
			</tr>
		  <tr>--%>
		  <td class="t_label">新密码</td>
			<td class="t_edit"><input type="password" id="password" name="password"  class="notNull" style="width:399px;"/> </td>
			</tr>
			<tr>
			<td class="t_label">新密码确认</td><td><input name="newPwd" id="newPwd"  class="notNull" type="password"style="width:399px;"/>
			 <span class="redTip"><s:fielderror fieldName="pwd"/></span>
			</td>
		</tr>
		</table>
		<div class="td_btn" >
			<input id="saveBtn" type="image" src="${pageContext.request.contextPath}/images/save.gif" value="" 
				onclick="save()"/>	
		</div>
	</s:form>
	
	</div>
    
    </div>
    </div>
    
</body>
</html>
