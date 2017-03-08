$(function () {
    //登录提示：
    //var dataArray = $("form").serialize();
    var login = document.getElementById("hs_login_btn");
    //用户名
    var uerName = document.getElementById("userName");
    var userNameRex = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
    var flagUser = false;
    //密码
    var psd = document.getElementById("psd");
    var psdRex = /^[a-zA-Z0-9]\w{5,17}$/;
    var flagPsd = false;
    //提示
    var tip = $("#hs_login_tip");
    //密码验证
    psd.onblur = function () {
        if (!psdRex.test(psd.value.trim())) {
            tip.html("请输入正确的密码").fadeIn(500).delay(1500).fadeOut(500);
            return false;
        }
        flagPsd = true;
    }
//用户名验证
    uerName.onblur = function () {
        if (!userNameRex.test(uerName.value.trim())) {
            tip.html("请输入正确的用户名").fadeIn(500).delay(1500).fadeOut(500);
            return false;
        }
        flagUser = true;
    }
    //登录验证
    login.onclick = function () {
    	
    	if(uerName.value.trim("")==""){
    		 tip.html("用户名不能为空").fadeIn(500).delay(1500).fadeOut(500);
    		 return false;
    	}
    	
    	if(psd.value.trim("")==""){
	   		 tip.html("密码不能为空").fadeIn(500).delay(1500).fadeOut(500);
	   		 return false;
    	}
    	
    	if(flagUser ==false){
    		 if (!userNameRex.test(uerName.value.trim())) {
    	            tip.html("请输入正确的用户名").fadeIn(500).delay(1500).fadeOut(500);
    	            return false;
    	        }
    	        flagUser = true;
        } 
    	
    	if(flagPsd == false){
        	if (!psdRex.test(psd.value.trim())) {
                tip.html("请输入正确的密码").fadeIn(500).delay(1500).fadeOut(500);
                return false;
            }
            flagPsd = true;
        }
        if (flagUser == true && flagPsd == true) {
        	login.type="submit";
        	document.getElementById('hs_login_btn').submit();
           /* $.ajax({
                type: "post",
                data: dataArray,
                dataType: "json",
                url: "hhhh",
                success: function (data) {
                    tip.html("登录成功").fadeIn(500).delay(1000).fadeOut(500);
                },
                error: function () {
                    tip.html("服务器繁忙").fadeIn(500).delay(1000).fadeOut(500);
                }
            })*/
        } 
    
    }
})