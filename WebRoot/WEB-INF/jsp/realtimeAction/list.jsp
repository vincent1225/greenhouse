<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户信息列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet"/>
<link id="base-style" href="${pageContext.request.contextPath}/css/temperature.css" rel="stylesheet"/>
<style>
body{top:100px;
position: absolute;
}
#num{display:none;}
</style>
</head>
<body >
<div class="row-fluid hideInIE8 circleStats">
	<!-- var：别名 -->
	<s:iterator value="sensorDatas" var = "sen" status="statu">
	<input type="button" id='num' value="${equipmentKind}"/>
		<div class="span2" onTablet="span4" onDesktop="span2">
                	<div class="circleStatsItemBox green" >
						<div class="header"></div>
							<span style="position: absolute;top:6px;left:105px;">
								<font size="20">&nbsp;&nbsp;&nbsp;
									(<s:property value="#statu.index+1"/>)
								</font>
							</span>
						<span class="percent">百分之</span>
						<div class="circleStat">
                    		<input type="text" value="${value*100/equipment.valueMax}" class="whiteCircle" />
						</div>		
						<div class="footer"style="top:160px;height:30px;">
							<span class="count" >
								<span class="number">${value}</span>
								<span class="un"></span>
							</span>	
						</div>
                	</div>
				</div>
					
       </s:iterator>   
       </div>
       <script>
				$(function(){
					var num=$('#num').val();
					//num = parseFloat(number)/parseFloat(max);		
					if(num == '1') {$('.header').text("当前空气温度"); $('.un').text("摄氏度(℃)");}
					if(num == '2') {$('.header').text("当前空气湿度"); $('.un').text("百帕(hPa)");}
					if(num == '3') {$('.header').text("当前土壤温度"); $('.un').text("摄氏度(℃)");}
					if(num == '4') {$('.header').text("当前土壤湿度"); $('.un').text("百帕(hPa)");}
					if(num == '5') {$('.header').text("当前光照强度"); $('.un').text("勒克斯(Lux)");}
					if(num == '6') {$('.header').text("当前二氧化碳"); $('.un').text("ppm");}
					if(num == '7') {$('.header').text("当前氨气浓度"); $('.un').text("ppm");}
					if(num == '8') {$('.header').text("当前土壤PH"); $('.un').text("");}
				
				});
			</script> 	
     	
              
				
	<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-migrate-1.0.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.0.custom.min.js"></script> 
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
	<script src='${pageContext.request.contextPath}/js/jquery.dataTables.min.js'></script>
	<script src="${pageContext.request.contextPath}/js/jquery.chosen.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.uniform.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.cleditor.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.elfinder.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.raty.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.uploadify-3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.masonry.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.knob.modified.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.sparkline.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/counter.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<!-- 	
 <ul class="imglist">
    <s:iterator value="recordList">
    <li class="selected">
    <span><img src="images/img01.png" /></span>
    <h2><a href="test.html">${name}</a></h2>
    <p><s:a action="greenhouse_editUI?id=%{id}" cssClass="tablelink" target="popFrm" 
                    			onclick="window.parent.document.getElementById('popFrm').style.height='170px';">编辑</s:a>
	<s:a action="greenhouse_delete?id=%{id}" cssClass="tablelink" 
								onclick="window.parent.document.getElementById   ('popFrm').style.height=0;return confirm('确定要删除吗？')">删除</s:a>
	</p>
    </li>
    </s:iterator> 
  </ul>

<div class="listDiv">
	 	<table class="tablelist">
			<thead>        
				<tr>
					<th>登录名</th>
					<th>姓名</th>
					<th style="width:300px;">岗位</th>
					<th>备注</th>
					<th style="width:150px;">操作</th>
				</tr>
			</thead>
			<tbody>
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
                    		<s:a action="greenhouse_editUI?id=%{id}" cssClass="tablelink" target="popFrm" 
                    			onclick="window.parent.document.getElementById('popFrm').style.height='170px';">编辑</s:a>
							<s:a action="greenhouse_delete?id=%{id}" cssClass="tablelink" 
								onclick="window.parent.document.getElementById   ('popFrm').style.height=0;return confirm('确定要删除吗？')">删除</s:a>
						</td>
					</tr>
				</s:iterator> 
 	</tbody>
		</table> 
</div>-->
<!-- 分页信息 -->
	 <s:form action="greenhouse_list"></s:form>
</body>

</html>
