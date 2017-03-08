define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl'], function($, avalon, common, DataList){
    return function (){
        var $tempSearchForm = $('#temp-search');
        var departmentTypeList = new DataList({
            id: 'departmentTypeList',
            dataUrl: appName + '/rest/departmentType/selectForList',
        });

        var $table = $(departmentTypeList.tDom);
        $table.on('click', '.temp-delete', function(){
            var id = $(this).closest('tr').attr('data-id');
            $.post(appName + '/rest/departmentType/delete', {"departmentTypeId": id}, function(data){

                departmentTypeList.reload();
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

            $.post(appName + '/rest/departmentType/selectForList', $tempSearchForm.serialize(), function(data){
                departmentTypeList.dataParseToVm(data);
            }, 'json');

        });

        avalon.scan($('#departmentTypeList')[0]);
    }
});