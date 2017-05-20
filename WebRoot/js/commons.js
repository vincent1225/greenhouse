// JavaScript Document
//

$(function(){
	$("input[type='text']").keydown(function(event){
		if(event.which==13){
			return false;
		}
	});
	$("input[name='selectAll']").click(function(){
		$('.tablelist tbody input[type="checkbox"]').each(function(){
			$(this).attr('checked',$("input[name='selectAll']").attr('checked'));
		});							   
	});	
});
/** 
 * 获取当前系统日期
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

/** 关闭上端编辑窗口 */
function closePopFrm(str){
	var con=confirm(str);
	if(con){
		return true;
	}
	return false;
}
/** 通过类名查找元素 */
function getElementsByClass(idName,sClassName){//obj:在哪个元素内查，sCName:类名
	var obj=document.getElementById(idName);
	var oAll=obj.getElementsByTagName("*");
	var oResult=[];
	for(var i=0;i<oAll.length;i++){
		if(oAll[i].className==sClassName){
			oResult.push(oAll[i]);
		}
	}
	return oResult;
}
/** 为指定文本框定义输入格式 */
function formatInput(){
	var aInput=document.getElementsByTagName("input");
	for(var i=0;i<aInput.length;i++){
		aInput[i].autoComplete="off";
		//鼠标悬浮提示文本框内容
		aInput[i].onmouseover=function(){
			this.title=this.value;
		};
		//光标离开显示规范日期格式
		aInput[i].onblur=function(){
			if(this.className=="dateOnly" || this.className=="dateNotNull"){
				this.value=strToDate($.trim(this.value));
			}
		};
		if(aInput[i].className=="dateOnly" || aInput[i].className=="dateNotNull"){
			aInput[i].onblur=function(){
				this.value=strToDate($.trim(this.value));
			};
			aInput[i].onkeydown=function(ev){
				var oEvent=ev||event;
				if(oEvent.keyCode==9) return true;//tab
				if(oEvent.keyCode==46) return true;//del
				if(oEvent.keyCode<=57 && oEvent.keyCode>=48) return true;//0~9
				if(oEvent.keyCode<=105 && oEvent.keyCode>=96) return true;//小键盘0~9
				if(oEvent.keyCode==37 || oEvent.keyCode==39 || oEvent.keyCode==8) return true;//左右方向键、退格
				return false;
			};
		}
		aInput[i].onfocus=function(){
			this.select();
		};
		if(aInput[i].className=="intOnly" || aInput[i].className=="dateOnly" || aInput[i].className=="yearOnly"){
			aInput[i].maxLength="10";
			aInput[i].onkeydown=function(ev){
				var oEvent=ev||event;
				if(oEvent.keyCode==9) return true;//tab
				if(oEvent.keyCode==46) return true;//del
				if(oEvent.keyCode<=57 && oEvent.keyCode>=48) return true;//0~9
				if(oEvent.keyCode<=105 && oEvent.keyCode>=96) return true;//小键盘0~9
				if(oEvent.keyCode==37 || oEvent.keyCode==39 || oEvent.keyCode==8) return true;//左右方向键、退格
				return false;
			};
		}
		if(aInput[i].className=="numericOnly"){
			aInput[i].maxLength="15";
			aInput[i].onkeydown=function(ev){
				var oEvent=ev||event;
				if(oEvent.keyCode==9) return true;//tab
				if(oEvent.keyCode==46) return true;//del
				if(oEvent.keyCode<=57 && oEvent.keyCode>=48) return true;//0~9
				if(oEvent.keyCode==37 || oEvent.keyCode==39 || oEvent.keyCode==8) return true;//左右方向键、退格
				if(oEvent.keyCode<=105 && oEvent.keyCode>=96) return true;//小键盘0~9
				if(oEvent.keyCode==190 && this.value.indexOf('.')<0)return true;//只能输入一个点
				if(oEvent.keyCode==110 && this.value.indexOf('.')<0)return true;//只能输入一个点,小键盘
				return false;
			};
		}
	}
}
function strToDate(str) {
	var date=str;
	if((str.length==6 || str.length==8) && str.indexOf('-')<0){
		date="-"+str.substr(str.length-2,2);
		date="-"+str.substr(str.length-4,2)+date;
		if(str.length==6)date="20"+str.substr(0,2)+date;
		if(str.length==8)date=str.substr(0,4)+date;
	}
	 return date;
}
/** 提交表单时判断文本框内容不能为空 */
function validateInput(){
	var flag=true;
	if (flag){
		$('.yearOnly').each(function(i,val){
			if($.trim(val.value)==""){
				alert($(this).parent().prev().text()+"不能为空!");
				flag=false;
				return false;
			}else{
				var reg=/^2\d{3}$/;
				if(reg.test(val.value)==false){
					alert($(this).parent().prev().text()+"格式错误!");
					flag=false;
					return false;
				}
			}
		});
	}
	if (flag){
		$('.dateNotNull').each(function(i,val){
			if($.trim(val.value)==""){
				alert("请填写"+$(this).parent().prev().text()+"!");
				flag=false;
				return false;
			}else{
				var reg=/((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/ig;
				val.value=strToDate(val.value);
				if(reg.test(val.value)==false){
					alert($(this).parent().prev().text()+"日期格式有误!");
					flag=false;
					return false;
				}
			}
		});
	}
	if (flag){
		$('.notNull').each(function(i,val){
			if($.trim(val.value)==""){
				alert("请填写"+$(this).parent().prev().text()+"!");
				flag=false;
				return false;
			}
		});
	}
	if (flag){
		$('.intOnly').each(function(i,val){
			if($.trim(val.value)==""){
				alert("请填写"+$(this).parent().prev().text()+"!");
				flag=false;
				return false;
				try{
					eval($.trim(val.value));
				}catch(e){
					alert("请输入合法的数字！");
					flag=false;
					return false;
				}
			}
		});
	}
	if (flag){
		$('.numericOnly').each(function(i,val){
			if($.trim(val.value)==""){
				alert("请填写"+$(this).parent().prev().text()+"!");
				flag=false;
				return false;
			}
			try{
				eval($.trim(val.value));
			}catch(e){
				alert("请输入合法的数字！");
				flag=false;
				return false;
			}
		});
	}
	
	if (flag){
		$('.dateOnly').each(function(i,val){
			if($.trim(val.value)!=""){
				var reg=/((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/ig;
				val.value=strToDate(val.value);
				if(reg.test(val.value)==false){
					alert($(this).parent().prev().text()+"日期格式有误!");
					flag=false;
					return false;
				}
			}
		});
	}
	return flag;
}
$(function(){//每个网页加载时自动执行
	formatInput();
});
//设置cookies
function setCookie(name,value)
{
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

//读取cookies
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]);
    else
        return null;
}

//删除cookies
function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
} 