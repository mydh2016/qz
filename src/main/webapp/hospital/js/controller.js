define(['jquery', 'avalon', 'pubperm'],function($, avalon, pubperm) {
    var rootVM = avalon.define({
        $id: 'root',
        appPath: '',
        pubperm: pubperm,
        menu: [],
        menuStatus: '',
        menuMsg: '',
        reload: function (){
            getJurisdictionList();
            $(this).addClass('act');
            rootVM.menuMsg = '正在刷新……'
        }
    });

    //获取权限菜单列表
    function getJurisdictionList() {
        $.ajax({
            type: "POST",
            url: "/qazitem/rest/user/getResourcesJsonByUserId",
            //url: '/55.json',
            data: {resourcetTypeid:1},
            dataType: "json",
            success: function(data){
                if(data.resultCode==0){
                    rootVM.menuStatus = '';
                    rootVM.menu = data.data;
                }else{
                    rootVM.menuStatus = 'error';
                    setTimeout(function(){
                        rootVM.menuMsg = data.data;
                        $('#btn-refresh').removeClass('act');
                    }, 1000);
                }

            },
            error: function(){
                rootVM.menuStatus = 'error';
                setTimeout(function(){
                    rootVM.menuMsg = '请求数据失败';
                    $('#btn-refresh').removeClass('act');
                }, 1000);
            }
        });
    }

    getJurisdictionList();

});