$(function(){
    var changes=$(".change");
    var flag=[true,true];
    $.each(changes,function(index,item){
        item.onclick=function(){
            if(flag[index]){
                $(this).siblings().removeAttr("disabled");
                $(this).html("取消");
                flag[index]=false;
            }else{
                if(index==0){
                    $(this).siblings().off("blur"); 
                    $(this).siblings().val(emailVal)   
                }else{
                    $(this).siblings().off("blur"); 
                     $(this).siblings().val(phoneVal)
                }                         
                $(this).siblings().attr("disabled","true");
                $(this).html("修改");
                flag[index]=true;
            }

        }
    })
    // 邮箱验证
    var email=$(".email");
    var regEmail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
    var emailVal=email.val();
    var flagEmail=false;
    email.on("blur",function(){
        if(email.val().trim("")==""){
            tip("邮箱不能为空");
            return false;
        }
        validate(email,regEmail,"邮箱输入有误",flagEmail);
    })
    // 手机验证
    var phone=$(".phone");
    var phoneVal=phone.val();
    var regPhone=/^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;
    var flagPhone=false;
    phone.on("blur",function(){
        if(phone.val().trim("")==""){
            tip("手机号不能为空");
            return false;
        }
        validate(phone,regPhone,"手机号输入有误",flagPhone);
    })
    var tipName=$(".hs_security_tip");

    // 验证
      function validate(input,reg,tipHtml,flag){
        if(!reg.test(input.val().trim(""))){
            tip(tipHtml);
            return false;
        }
        flag=true;
    }
    function tip(tipHtml){
        tipName.html(tipHtml).fadeIn(500).delay(1500).fadeOut(500);
    }
 
    var submit=$(".btn");
    submit.on("click",function(){
        if(email[0].hasAttribute("disabled")==true&&phone[0].hasAttribute("disabled")==true){
            tipName.html("请在可修改状态下提交").fadeIn(500).delay(1500).fadeOut(500);
            return false;
        }
        if(email.val().trim("")==""){
            tip("邮箱不能为空");
            return false;
        }
        if(phone.val().trim("")==""){
            tip("手机号不能为空");
            return false;
        }
        if(flagEmail==false){
             if(!regEmail.test(email.val().trim(""))){
                tip(tipEmail);
                return false;
            }
            flagEmail=true;
        }
         if(flagPhone==false){
            if(!regPhone.test(phone.val().trim(""))){
                tip(tipPhone);
                return false;
            }
            flagPhone=true;
        }
        if(flagEmail==true&&flagPhone==true){
            // 进行提交
            $("form").submit();
        }
        
    })
})

