<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>岗位信息列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
<div class="listDiv">
		<table class="tablelist" style="table-layout:fixed;">
			<thead>
				<tr>
					<th style="width:150px;" >岗位名称</th>
					<th>岗位说明</th>
					<th style="width:150px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- 显示数据列表 -->
				<s:iterator value="recordList">
					<tr>
						<td style="width:150px;">${name}</td>
						<td >${remark}</td>
						<td style="width:150px;">
							<s:a action="role_editUI?id=%{id}" cssClass="tablelink" target="popFrm" 
								onclick="window.parent.document.getElementById('popFrm').style.height='121px';">编辑</s:a>
							<s:a action="role_delete?id=%{id}" cssClass="tablelink" 
								onclick="window.parent.document.getElementById('popFrm').style.height=0;return confirm('确定要删除吗？')">删除</s:a>
							<s:a action="role_setPrivilegeUI?id=%{id}" cssClass="tablelink" target="rightFrame">设置权限</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
</div>
<!-- 分页信息 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
		<s:form action="role_list"></s:form>
</body>

</html>
