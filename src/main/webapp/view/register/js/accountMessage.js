$(function () {
//1.点击修改信息，input框变成可编辑状态
//    2.点击取消，就回到初始状态，并且把input框禁掉
//    3.点击确定，判断是否将用户信息填写正确
//    4.如果正确，则返回页面
    var accountMsg = $(".hs_accontMsg_btn");
    var inps = $(".hs_accontMsg_info input");
    var whether = $(".hs_accontMsg_whether");
    var cancel = $(".hs_accontMsg_whether_cancel");
    var confirm = $(".hs_accontMsg_whether_confirm");
    var dataArray=$("form").serialize();
    accountMsg.on("click", function () {
        $.each(inps, function (index, item) {
            $(item).removeAttr("disabled");
        })
        accountMsg.css("display", "none");
        whether.css("display", "block");
        $(".sex").css("display", "none");
        $(".chooseSex").css("display", "block");
        cancel.on("click", function () {
        	location.reload();
           /* $.each(inps, function (index, item) {
                $(item).attr("disabled", true);
            })
            $(".sex").css("display", "block");
            $(".chooseSex").css("display", "none");
            accountMsg.css("display", "block");
            whether.css("display", "none");*/
        });

        //性别选择
        var female=$("#female");
        var male=$("#male");
        female.on("click",function(){
            female.attr("checked",true);
            male.attr("checked",false);
            female.attr("name","gender");
            female.attr("value","女");
        })
        male.on("click",function(){
            female.attr("checked",false);
            male.attr("checked",true);
            male.attr("name","gender");
            male.attr("value","男");
            
        })
        //名字
        var userName=$(".addUserName");
        var rexUser= /^[\u4e00-\u9fa5]{2,4}$/;
        var tipUser="姓名输入不正确";
        var tipUserKong="姓名不能为空";
        var flagUser=false;
        // 姓名验证
        userName.blur(function(){
            if(userName.val().trim("")==""){
                tip(tipUserKong);
                return false;
            }
            validate(userName,rexUser,tipUser,flagUser);
        })
        //手机号码
        var phone=$(".phone");
        var rexPhone=/^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;
        var tipPhone="请输入正确的手机号码";
        var tipPhoneKong="手机号不能为空";
        var flagPhone=false;
        // 手机验证
        phone.blur(function(){
            if(phone.val().trim("")==""){
                tip(tipPhoneKong);
                return false;
            }
            validate(phone,rexPhone,tipPhone,flagPhone);
        })
        //身份证号
        var ID=$(".ID");
        var rexID=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var tipID="请输入正确的身份证号";
        var tipIDKong="身份证号不能为空";
        var flagID=false;
        // 身份证验证
        ID.blur(function(){
            if(ID.val().trim("")==""){
                tip(tipIDKong);
                return false;
            }
            validate(ID,rexID,tipID,flagID);
        })
        //提示信息
        var tipName=$(".hs_accontMsg_tip");

        // 验证方法
        function validate(input,rex,tipHtml,flag){
            if(!rex.test(input.val().trim(""))){
                tip(tipHtml);
                return false;
            }
            flag=true;
        }
        // 提示方法
        function tip(tipHtml){
            tipName.html(tipHtml).fadeIn(500).delay(1500).fadeOut(500);
        }
    confirm.on("click",function(){
            if(flagUser==false){
                if(userName.val().trim("")==""){
                    tip(tipUserKong);
                    return false;
                }else{
                     if(rexUser.test(userName.val().trim(""))){
                        flagUser=true;
                    }else{
                        tip(tipUser);
                        return false;
                     }
                }
            }
            if(flagPhone==false){
                if(phone.val().trim("")==""){
                    tip(tipPhoneKong);
                    return false;
                }else{
                    if(rexPhone.test(phone.val().trim(""))){
                        flagPhone=true;
                    }else{
                        tip(tipPhone);
                        return false;
                     }
                }
            }
            if(flagID==false){
                if(ID.val().trim("")==""){
                    tip(tipIDKong);
                }else{
                     if(rexID.test(ID.val().trim(""))){
                        flagID=true;
                    }else{
                        tip(tipID);
                        return false;
                     }
                }
            }
         if(flagUser==true&&flagPhone==true&&flagID==true){
            //进行提交
            // 成功之后
         	$("form").submit();
                 /*$.each(inps, function (index, item) {
                $(item).attr("disabled", true);
            })
             $(".chooseSex").css("display", "none");
            whether.css("display", "none");
            accountMsg.css("display", "block");*/
        }

    })

})
})
