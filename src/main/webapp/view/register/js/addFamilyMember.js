$(function(){

    // 姓名
    var userName=$(".userName");
    var regUser= /^[\u4e00-\u9fa5]{2,4}$/;
    var tipUser="姓名输入不正确";
    var tipUserKong="姓名不能为空";
    var flagUser=false; 
    // 姓名验证
     userName.blur(function(){
        if(userName.val().trim("")==""){
            tip(tipUserKong);
            return false;
        }
        validate(userName,regUser,tipUser,flagUser);
    })
   
    // 手机号
     var phone=$(".phone");
    var regPhone=/^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;
    var tipPhone="请输入正确的手机号码";
    var tipPhoneKong="手机号不能为空";
    var flagPhone=false;
     // 手机验证
    phone.blur(function(){      
        if(phone.val().trim("")===""){
            tip(tipPhoneKong);
            return false;
        }
        validate(phone,regPhone,tipPhone,flagPhone);
    })
    // 身份证号
    var ID=$(".ID");
    var regID=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    var tipID="请输入正确的身份证号";
    var tipIDKong="身份证号不能为空";
    var flagID=false;
     // 身份证验证
    ID.blur(function(){
        if(ID.val().trim("")==""){
            tip(tipIDKong);
            return false;
        }
        validate(ID,regID,tipID,flagID);
    })
    // 提示
    var tipName=$(".hs_addFamMem_tip");
    // 提交
    var submit=$(".btn");

    // 验证方法
    function validate(input,reg,tipHtml,flag){
        if(!reg.test(input.val().trim(""))){
            tip(tipHtml);
            return false;
        }
        flag=true;
    }
    // 提示方法
    function tip(tipHtml){
        tipName.html(tipHtml).fadeIn(500).delay(1500).fadeOut(500);
    }
    // 提交
    submit.on("click",function(){
       if(userName.val().trim("")==""){
            tip(tipUserKong);
            return false;
        }
        if(phone.val().trim("")==""){
            tip(tipPhoneKong);
            return false;
        }
        if(ID.val().trim("")==""){
            tip(tipIDKong);
            return false;
        }
        if(flagUser==false){
             if(!regUser.test(userName.val().trim(""))){
                tip(tipUser);
                return false;
            }
            flagUser=true;
        }
        if(flagPhone==false){
            if(!regPhone.test(phone.val().trim(""))){
                tip(tipPhone);
                return false;
            }
            flagPhone=true;
        }
        if(flagID==false){
            if(!regID.test(ID.val().trim(""))){
                tip(tipID);
                return false;
            }
            flagID=true;
        }
        if(flagID==true&&flagUser==true&&flagPhone==true){
            // 进行提交
        }
       
    })

    // 姓名
    var userName=$(".userName");
    var regUser= /^[\u4e00-\u9fa5]{2,4}$/;
    var tipUser="姓名输入不正确";
    var tipUserKong="姓名不能为空";
    var flagUser=false; 
    // 姓名验证
     userName.blur(function(){
        if(userName.val().trim("")==""){
            tip(tipUserKong);
            return false;
        }
        validate(userName,regUser,tipUser,flagUser);
    })
    // 手机号
     var phone=$(".phone");
    var regPhone=/^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;
    var tipPhone="请输入正确的手机号码";
    var tipPhoneKong="手机号不能为空";
    var flagPhone=false;
     // 手机验证
    phone.blur(function(){      
        if(phone.val().trim("")===""){
            tip(tipPhoneKong);
            return false;
        }
        validate(phone,regPhone,tipPhone,flagPhone);
    })
    // 身份证号
    var ID=$(".ID");
    var regID=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    var tipID="请输入正确的身份证号";
    var tipIDKong="身份证号不能为空";
    var flagID=false;
     // 身份证验证
    ID.blur(function(){
        if(ID.val().trim("")==""){
            tip(tipIDKong);
            return false;
        }
        validate(ID,regID,tipID,flagID);
    })
    // 提示
    var tipName=$(".hs_addFamMem_tip");
    // 提交
    var submit=$(".btn");

    // 验证方法
    function validate(input,reg,tipHtml,flag){
        if(!reg.test(input.val().trim(""))){
            tip(tipHtml);
            return false;
        }
        flag=true;
    }
    // 提示方法
    function tip(tipHtml){
        tipName.html(tipHtml).fadeIn(500).delay(1500).fadeOut(500);
    }
    // 提交
    submit.on("click",function(){
       if(userName.val().trim("")==""){
            tip(tipUserKong);
            return false;
        }else if(phone.val().trim("")==""){
            tip(tipPhoneKong);
            return false;
        }else  if(ID.val().trim("")==""){
            tip(tipIDKong);
            return false;
        }else if(flagUser==false){
            tip(tipUser);
            return false;
        }else if(flagPhone==false){
            tip(tipPhone);
            return false;
        }else if(flagID==false){
            tip(tipID);
            return false;
        }else if(flagID==true&&flagUser==true&&flagPhone==true){
            // 进行提交
        	$("form").submit();
        }
       
    })

})