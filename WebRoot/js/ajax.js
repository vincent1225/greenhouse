
function ajax(url, data, fnSucc, fnFaild)
{
	//1.创建ajax对象
	var oAjax=null;
	
	try{    		//Firefox, Opera 8.0+, Safari
		oAjax=new XMLHttpRequest();
	}catch (e){
        try{    	//Internet Explorer
        	oAjax=new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e){
        	try{
        		oAjax=new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e){}  
        }
	}
	
	//4.接收返回
	//OnReadyStateChange
	oAjax.onreadystatechange=function()
	{	// 4 表示有响应
		if(oAjax.readyState==4)
		{	// 200 表示请求成功
			if(oAjax.status==200)
			{
				fnSucc(oAjax.responseText);
			}
			else
			{
				if(fnFaild)
				{
					fnFaild();
				}
			}
		}
	};
	
	//2.连接服务器
	//open(方法, url, 是否异步)
	oAjax.open('POST',url, true);
	oAjax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	
	
	//3.发送请求
	oAjax.send(data);
}