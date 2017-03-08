define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){
    var departmentEdit = avalon.define({
        $id: 'departmentEdit',
        data: {},
        departmentType: '',
        departmentTypeArr:{}
    });

    var tempTypeEditVm = avalon.define({
        $id: 'tempTypeEdit',
        bigTypeSelect: '',
        littleTypeSelect: '',
        bigType: {},
        littleType: {}

    });

    return function (){

        var $tempEdit = $('#departmentEdit'),
            $tempEditForm = $('#tempEditForm'),
            tempId = window.location.href.split('=')[1];

        departmentEdit.data = {};

        $.post(appName + '/rest/department/selectById?departmentId=' + tempId, function(data){
            departmentEdit.data = data.data;
            departmentEdit.departmentType = data.data.dptName;

        });




        avalon.scan($tempEdit[0]);

        $tempEditForm.on('submit', function(e){
            e.preventDefault();

            $.post(appName + '/rest/department/update', $tempEditForm.serialize(), function(data){

                $.notify(
                    {message: '修改成功'},
                    {
                        type: 'success',
                        delay: 6000,
                        animate: {
                            enter: 'animated bounceIn',
                            exit: 'animated bounceOut'
                        }
                    }
                );
            });

        });
        $.post(appName + '/rest/departmentType/selectForList', function (data){
            departmentEdit.departmentTypeArr = data.data.dataList;
        });
    }

});