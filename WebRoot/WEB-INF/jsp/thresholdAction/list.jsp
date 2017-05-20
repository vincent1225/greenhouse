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
        <th></th>
        <th>最大值</th>
        <th>最小值</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td>温度</td>
        <td><input class="setting"  name="text" type="text" onblur="true"/></td>
        <td><input class="setting"  name="text" type="text" /></td>
        </tr> 
        <tr>
        <td>湿度</td>
        <td><input class="setting"  name="text" type="text" /></td>
        <td><input class="setting"  name="text" type="text" /></td>
        </tr> 
        <tr>
        <td>二氧化碳</td>
        <td><input class="setting"  name="text" type="text" /></td>
        <td><input class="setting"  name="text" type="text" /></td>
        </tr> 
        <tr>
        <td>氨气</td>
        <td><input class="setting"  name="text" type="text" /></td>
        <td><input class="setting"  name="text" type="text" /></td>
        </tr> 
        <tr>
        <td>ph</td>
        <td><input class="setting"  name="text" type="text" /></td>
        <td><input class="setting"  name="text" type="text" /></td>
        </tr> 
        <tr>
        <td colspan="3" style="text-align:center" /><a href="#">保存</a>
        </tr>  
        </tbody>     
</table>
</div>
<!-- 分页信息 -->
	 <s:form action="threshold_list"></s:form>
</body>

</html>
