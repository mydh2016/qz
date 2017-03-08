define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl'], function($, avalon, common, DataList){
    var tempTypeManageVm = avalon.define({
        $id: 'tempTypeManage',
        bigTypeSelect: '',
        littleTypeSelect: '',
        bigType: {},
        littleType: {}
    });

    return function (){
        var $tempSearchForm = $('#temp-search');
        var tempManageList = new DataList({
            id: 'tempManageList',
            dataUrl: appName + '/rest/model/selectForList',
            modelStatus: {
                1: '启用',
                2: '停用'
            }
        });

        var $table = $(tempManageList.tDom);

        $.post(appName + '/rest/model/selectParentType', function (data){
            tempTypeManageVm.bigType = data.data;
        });
        tempTypeManageVm.$watch("bigTypeSelect" ,function(a, b) {
            $.post(appName + '/rest/model/selectChildrenType', {modelParentType: a}, function (data){
                tempTypeManageVm.littleType = data.data;
            });
        });

        $table.on('click', '.temp-delete', function(){
            var id = $(this).closest('tr').attr('data-id');
            $.post(appName + '/rest/model/deleteByPrimaryKey', {id: id}, function(data){

                tempManageList.reload();
                $.notify(
                    {message: '删除成功'},
                    {
                        type: 'success',
                        delay: 6000,
                        animate: {
                            enter: 'animated bounceIn',
                            exit: 'animated bounceOut'
                        }
                    }
                );

            }, 'json');
        });

        $tempSearchForm.on('submit', function (e){
            e.preventDefault();

            $.post(appName + '/rest/model/selectForList', $tempSearchForm.serialize(), function(data){
                tempManageList.dataParseToVm(data);
            }, 'json');

        });
    }
});