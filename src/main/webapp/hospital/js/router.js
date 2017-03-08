define(["jquery", "avalon", "common", "director", "controller", 'growl'], function($, avalon, common) {

    var routes = {
        '/usermanage': function() {
            common.getTemp('userManage');
        },
        '/partnermanage': function() {
            common.getTemp('partnerManage');
        },
        '/intentuser': function (){
            common.getTemp('intentUser');
        },
        '/intentuserdetail': function (){
            common.getTemp('intentuserdetail');
        },
        '/rolemanage': function() {
            common.getTemp('roleManage');
        },
        '/usercenter': function() {
            common.getTemp('userCenter');
        },
        '/dashboard': function() {
            common.getTemp('dashboard');
        },

        '/tempmanage': function() {
            common.getTemp('tempManage');
        },

        '/tempadd': function() {
            common.getTemp('tempAdd');
        },

        '/tempview': function() {
            common.getTemp('tempView');
        },

        '/tempedit': function() {
            common.getTemp('tempEdit');
        },

        '/messagepublish': function() {
            common.getTemp('messagePublish');
        },

        '/selectdisturb': function() {
            common.getTemp('selectDisturb');
        },

        '/importaddressee': function() {
            common.getTemp('importAddressee');
        },

        '/addresslist': function() {
            common.getTemp('addressList');
        },

        '/alincompound': function() {
            common.getTemp('alInCompound');
        },

        '/aloutcompound': function() {
            common.getTemp('alOutCompound');
        },

        '/alpatient': function() {
            common.getTemp('alPatient');
        },

        '/disturblib': function() {
            common.getTemp('disturbLib');
        },

        '/importdisturb': function() {
            common.getTemp('importDisturb');
        },

        '/aladdwork': function() {
            common.getTemp('alAddWork');
        },

        '/aleditwork': function() {
            common.getTemp('alEditWork');
        },

        '/aladdpatient': function() {
            common.getTemp('alAddPatient');
        },

        '/aleditpatient': function() {
            common.getTemp('alEditPatient');
        },
        'alimportwork':function(){
        	 common.getTemp('alImportWork');
        },
        '/outbox': function() {
            common.getTemp('outbox');
        },

        '/inbox': function() {
            common.getTemp('inbox');
        },

        '/recyclebin': function() {
            common.getTemp('recycleBin');
        },
        '/department': function() {
            common.getTemp('department');
        },
        '/departmentAdd': function() {
            common.getTemp('departmentAdd');
        },
        '/departmentEdit': function() {
            common.getTemp('departmentEdit');
        },
        '/departmentType': function() {
            common.getTemp('departmentType');
        },
        '/departmentTypeAdd': function() {
            common.getTemp('departmentTypeAdd');
        },
        '/departmentTypeEdit': function() {
            common.getTemp('departmentTypeEdit');
        }
    };

    $(function(){
        var router = Router(routes);
        //router.setRoute("/test");  //设置当前的路由地址(这是是设置应用的初始地址),该方法可以使用js代码跳转页面
        router.init("/usercenter");
        avalon.scan();
    });


});