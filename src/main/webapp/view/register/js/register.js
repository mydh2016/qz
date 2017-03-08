$(function () {
        //用户名
        var inpUser = document.getElementById("userName");
        var userNameRex=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        var flagUser = false;
        //密码
        var inpPsw = document.getElementById("psd");
        var psdRex= /^[a-zA-Z0-9]\w{5,17}$/;
        var flagPsw = false;
        //提示
        var tip = $(".hs_register_tip");
        var regBtn = document.getElementById("hs_register_btn");
        //var dataArray = $("form").serialize();
        //用户名验证
        inpUser.onblur = function () {
        	if(inpUser.value.trim("")==""){
       		 	tip.html("用户名不能为空").fadeIn(500).delay(1500).fadeOut(500);
       		 	return false;
        	}
            if (!userNameRex.test(inpUser.value.trim())) {
                tip.html("请输入正确的用户名").fadeIn(500).delay(1500).fadeOut(500);
                return false;
            }
            flagUser = true;
        }
        //密码验证
        inpPsw.onblur = function () {
          	if(inpPsw.value.trim("")==""){
	      		 tip.html("密码不能为空").fadeIn(500).delay(1500).fadeOut(500);
	      		 return false;
	      	}
	       	
            if (!psdRex.test(inpPsw.value.trim())) {
                tip.html("请输入正确的密码").fadeIn(500).delay(1500).fadeOut(500);
                return false;
            }
            flagPsw = true;
        }
        regBtn.onclick = function (){
        	if(inpUser.value.trim("")==""){
       		 	tip.html("用户名不能为空").fadeIn(500).delay(1500).fadeOut(500);
       		 	return false;
        	}
        	
	       	if(inpPsw.value.trim("")==""){
	      		 tip.html("密码不能为空").fadeIn(500).delay(1500).fadeOut(500);
	      		 return false;
	      	}
	       	
	       	if(flagUser ==false){
	       		 if (!userNameRex.test(inpUser.value.trim())) {
	       	            tip.html("请输入正确的用户名").fadeIn(500).delay(1500).fadeOut(500);
	       	            return false;
	       	        }
	       	        flagUser = true;
	           } 
	       	if(flagPsw == false){
	           	if (!psdRex.test(inpPsw.value.trim())) {
	                   tip.html("请输入正确的密码").fadeIn(500).delay(1500).fadeOut(500);
	                   return false;
	               }
	           	flagPsw = true;
	           }
                if (flagPsw == true && flagUser == true) {
                    regBtn.type="submit";
                    document.getElementById("hs_register_btn").submit();
                   /* $.ajax({
                    type: "post",
                    url: "jjjj",
                    data: dataArray,
                    dataType: "json",
                    error: function (request) {
                        tip.html('注册失败').fadeIn(500).delay(1500).fadeOut(500);
                    },
                    success: function (data) {

                        tip.html('注册失败').fadeIn(500).delay(1500).fadeOut(500);
                    }
                })*/

                } if(flagUser==false) {
                    tip.html('请输入正确的用户名').fadeIn(500).delay(1500).fadeOut(500);
                }if( flagPsw == false){
                    tip.html('请输入正确的用户名').fadeIn(500).delay(1500).fadeOut(500);
                }
        }
    }
)