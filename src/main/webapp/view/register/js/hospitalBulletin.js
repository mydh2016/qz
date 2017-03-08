var flag=true;
$(function(){
      var parent=$("body");
        // 获取子盒子
      var child=$(".hs_bulletin_main ul");
        // 获取topBar的高度
      var topBarHeight=$(".topBar").height();
        // 获取父盒子的高度
      var parentHeight=parent.height();
        // 获取子盒子的高度
      var  childHeight = child.height();
        // 子盒子和父盒子的高度差       
      var  distance=childHeight-parentHeight-topBarHeight;
        
	    // 判断触底
	    function sole(flag){
	    	if(flag){
	    		// 重新获取父盒子高度
	 	       parentHeight=parent.height();
	 	       // 重新获取子盒子高度
	 	       childHeight = child.height();
	 	       // 重新获取高度差
	 	       distance=childHeight-parentHeight;
	 	       // 进行判断
	 	      if(childHeight>parentHeight-topBarHeight){   
	 	          if(Math.ceil(-child.offset().top)==distance){
	 	            // 进行加载
	 	            return true;
	 	          }else{
	 	            return false;
	 	          }
	 	       
	 	      }
	    	}else{
	    		return false;
	    	}
	      
	    }
        
                        

    // 当进行滑动时
      $("body").on("touchmove",function(){
        if(sole(flag)){
        	var startNum=child.children("li").size();
        	var pageNum=5;
            $.ajax({
       				type:"get",
       				url:"/qazitem/rest/app/Notice/All",
       				data:{"startNum":startNum,"pageNum":pageNum},
       				dataType:"json",
       				async:false,
       				success:function(data){
       						console.log(data);
       						 if(data.data.length>=pageNum){
       							var html="";
		       					for(var i=0;i<data.data.length;i++)
		       					{
		       						 html='<li><a href="/qazitem/rest/app/Notice/selectBynotice?publicNoticeId='+data.data[i].publicNoticeId+'">'+
		       						'<h4>"'+data.data[i].publicNoticeName+'"</h4>'+
		       						'<p class="hs_bulletin_main_time">"'+data.data[i].publishedTime1+'"</p>'+'<i class="icon iconfont icon-icon"></i>'+
		       						'</a></li>'
		       						child.append(html);
		       					}
		       				}
       						else{
       							var html2="";
       							for(var i=0;i<data.data.length;i++)
       							{
		       						html2='<li><a href="/qazitem/rest/app/Notice/selectBynotice?publicNoticeId='+data.data[i].publicNoticeId+'">'+
		       						'<h4>"'+data.data[i].publicNoticeName+'"</h4>'+
		       						'<p class="hs_bulletin_main_time">"'+data.data[i].publishedTime+'"</p>'+'<i class="icon iconfont icon-icon"></i>'+
		       						'</a></li>'
		       						child.append(html2);
       						
       							}
       							flag=false;
       						}
       						},
       						error:function(request){
       							flag=false;
       	     				}
       				
          });
        }
    }) 
   
})