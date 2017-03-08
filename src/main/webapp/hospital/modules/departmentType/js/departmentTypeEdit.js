define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){
    var tempEditVm = avalon.define({
        $id: 'tempEdit',
        data: {}
    });

    var tempTypeEditVm = avalon.define({
        $id: 'tempTypeEdit',
        bigTypeSelect: '',
        littleTypeSelect: '',
        bigType: {},
        littleType: {}
    });

    return function (){

        var $tempEdit = $('#tempEdit'),
            $tempEditForm = $('#tempEditForm'),
            tempId = window.location.href.split('=')[1];

        tempEditVm.data = {};

        $.post(appName + '/rest/departmentType/selectById?departmentTypeId=' + tempId, function(data){
            tempEditVm.data = data.data;

        });




        avalon.scan($tempEdit[0]);

        $tempEditForm.on('submit', function(e){
            e.preventDefault();

            $.post(appName + '/rest/departmentType/update', $tempEditForm.serialize(), function(data){

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
    }

});