// JavaScript Document

(function($){
	$.fn.showList=function(aStr,obj){  //$.fn 扩展插件的方法
		var _this=this;
		var cursor=-1;//列表没有li处于选中状态
		var length=aStr.length;//列表长度
		
		var oUl=$(obj);
		
		var left=_this.offset().left;
		var top=_this.offset().top+_this.height();
		for(var i=0;i<aStr.length;i++){
			var oLi=$("<li>");
			oLi.html(aStr[i]);
			oUl.append(oLi);
			oLi.click(function(){
				_this.attr('value',$(this).html());	
				alert($(this).html());
				_this.focus();
				oUl.empty();
				oUl.css('display','none');
				//oUl.css('z-index','-2');
			});
		};

		oUl.css("border","1px solid blue");
		oUl.css("position","absolute")
		.css("left",left).css("top",top+4)
		.css("width",_this.parent().css("width"));
		
		oUl.find('li').css('list-style','none').css('line-height','20px')
		.css('padding','0 10px').css('font-size','14px')
		.css('background','white').css('border-bottom','1px dotted blue')
		.css('opacity','1');
		oUl.find('li').hover(function(){
			oUl.find('li').css('background','white');
			$(this).css('background','#ddeeff');
		},function(){
			$(this).css('background','white');
		});

		
		$("body").append(oUl);
		
		_this.keydown(function(event){
			if(length>0){
				switch(event.which){
					case 38://向上键
						if(cursor==-1 || cursor==0){//列表中没有选中项
							cursor=length-1;
						}else{
							cursor-=1;
						};
						oUl.find('li').css('background','white');
						oUl.find('li').eq(cursor).css('background','#ddeeff');
						_this.val(oUl.find('li').eq(cursor).html());
						break;
					case 40://向下键
						if(cursor==-1 || cursor==length-1){//列表中没有选中项
							cursor=0;
						}else{
							cursor+=1;
						};
						oUl.find('li').css('background','white');
						oUl.find('li').eq(cursor).css('background','#ddeeff');
						_this.val(oUl.find('li').eq(cursor).html());
						break;
					default:
				}
			}
		});
		_this.blur(function(){
			oUl.css('display','none');
		});
	};
})(jQuery);