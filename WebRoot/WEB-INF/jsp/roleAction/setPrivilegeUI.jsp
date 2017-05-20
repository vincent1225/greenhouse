<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>配置权限</title>
<%-- <%@ include file="/WEB-INF/jsp/public/commons.jspf" %> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/file.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.css" />
<script type="text/javascript">
	$(function() {
		// 指定事件处理函数
		$("[name=privilegeIds]").click(function() {
			// 当选中或取消一个权限时，也同时选中或取消所有的下级权限
			$(this).siblings("ul").find("input").attr("checked", this.checked);
			// 当选中一个权限时，也要选中所有的直接上级权限
			if (this.checked == true) {
				$(this).parents("li").children("input").attr("checked", true);
			}
		});
	});
</script>
<style>
</style>
</head>
<body>

	<!--显示表单内容-->
	<div class="formbody">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>首页</li>
				<li>系统管理</li>
				<li>岗位管理——配置权限</li>
			</ul>
		</div>
		<div>
			正在为<span style="color:red;">【${name}】</span>配置权限
		</div>
		<s:form action="role_setPrivilege">
			<s:hidden name="id"></s:hidden>
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--表头-->
						<thead>
							<tr align="left" valign="middle" id="TableTitle">
								<td width="100%" style="padding-left: 15px;padding-top:10px;">
									<input type="checkbox" id="cbSelectAll"
									onClick="$('[name=privilegeIds]').attr('checked', this.checked)" />
									<label for="cbSelectAll">全选</label>
								</td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>
									<!-- 显示树状结构内容 -->
									<ul id="tree">
										<s:iterator value="#application.topPrivilegeList">
											<li><input type="checkbox" name="privilegeIds"
												value="${id}" id="cb_${id}"
												<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
												&nbsp;<label for="cb_${id}"><span class="folder">${name}</span>
											</label>
												<ul>
													<s:iterator value="children">
														<li><input type="checkbox" name="privilegeIds"
															value="${id}" id="cb_${id}"
															<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
															<label for="cb_${id}"><span class="folder">${name}</span>
														</label>
															<ul>
																<s:iterator value="children">
																	<li class="layer3"><input type="checkbox"
																		name="privilegeIds" value="${id}" id="cb_${id}"
																		<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
																		<label for="cb_${id}"><span class="folder">${name}</span>
																	</label></li>
																</s:iterator>
															</ul></li>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<script language="javascript">
				$("#tree").treeview();
			</script>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"	src="${pageContext.request.contextPath}/images/save.gif" /> 
				<a	href="javascript:history.go(-1);">
				<input type="image"	src="${pageContext.request.contextPath}/images/exit.gif" /> 
				<a	href="history.go(-1);">
			</div>
		</s:form>
	</div>
</body>
</html>
