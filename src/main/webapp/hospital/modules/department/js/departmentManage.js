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
        var departmentList = new DataList({
            id: 'departmentList',
            dataUrl: appName + '/rest/department/selectForList',
            isSpecial:{
            	1:"是",
            	2:"否"
            }
        });

        var $table = $(departmentList.tDom);
        $table.on('click', '.temp-delete', function(){
            var id = $(this).closest('tr').attr('data-id');
            $.post(appName + '/rest/department/delete', {"departmentId": id}, function(data){

                departmentList.reload();
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

            $.post(appName + '/rest/department/selectForList', $tempSearchForm.serialize(), function(data){
                departmentList.dataParseToVm(data);
            }, 'json');

        });

        avalon.scan($('#departmentList')[0]);
    }
});