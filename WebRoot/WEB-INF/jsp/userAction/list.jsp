<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户信息列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
<div class="listDiv">
		<table class="tablelist">
			<thead>
				<tr>
					<th>登录名</th>
					<th>姓名</th>
					<th style="width:300px;">角色</th>
					<th>备注</th>
					<th style="width:150px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- 显示数据列表 -->
				<s:iterator value="recordList">
					<tr>
						<td>${loginName}</td>
						<td>${name}</td>
						<td style="width:300px;">
							<s:iterator value="roles">
                				${name}
                			</s:iterator></td>
                		<td>${description}&nbsp;</td>
						<td style="width:150px;">
                    		<s:a action="user_editUI?id=%{id}" cssClass="tablelink" target="popFrm" 
                    			onclick="window.parent.document.getElementById('popFrm').style.height='170px';">编辑</s:a>
							<s:a action="user_delete?id=%{id}" cssClass="tablelink" 
								onclick="window.parent.document.getElementById   ('popFrm').style.height=0;return confirm('确定要删除吗？')">删除</s:a>
							<s:a action="user_initPassword?id=%{id}" cssClass="tablelink" onclick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a>						</td>
					</tr>
				</s:iterator> 
			</tbody>
		</table>
</div>
<!-- 分页信息 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
	 <s:form action="user_list"></s:form>
</body>

</html>
