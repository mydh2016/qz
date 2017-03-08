define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

    return function (){
        var $mssagePushForm = $('#mssagePushForm'),
            $con = $('#content').children('div'),
            $modelContent = $('#modelContent'),
            addressjson,
            noDisturbojson;

        var allist;

        var mssagePush = avalon.vmodels['mssagePush'] ? avalon.vmodels['mssagePush'] : avalon.define({
            $id: 'mssagePush',
            data: []
        });
        mssagePush.data = [];
        
        var mssagePushObj = {};

        var disturb_ = avalon.define({
            $id: 'disturb_',
            data: []
        });
        var disturb_Obj = {};

        var rule = avalon.define({
            $id: 'rule',
            type: 1,
            cycle: 1
        });

        rule.$watch('type', function (a, b){
            if(a == 2) {
                $('#onceTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            } else if(a == 3) {
                var $timeBar = $('#timeBar');
                var timeItemHtml = $timeBar.html();
                $('#addTimeItem').on('click', function (){
                    $(timeItemHtml).appendTo($timeBar).find('input').datetimepicker({
                        format: 'yyyy-mm-dd hh:00',
                        container: $con,
                        todayHighlight: true,
                        language: 'zh-CN',
                        autoclose: true,

                        minView: 1,
                        maxView: 2
                    });
                });

                $timeBar.on('click', 'i', function (){
                    if($timeBar.children().length > 1) {
                        $(this).parent().remove();
                    }
                });

                $timeBar.find('input').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            }

        });

        rule.$watch('cycle', function (a, b) {
            if (a == 1) {
                $('#onceTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            } else if (a == 2){
                $('#dayTime').datetimepicker({
                    format: 'hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    startView: 1
                });
                $('#dayStartTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
                $('#dayEndTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            } else if (a == 3){
            	$('#weakTime').datetimepicker({
                    format: 'hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    startView: 1
                });
                $('#weekStartTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
                $('#weekEndTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            } else if (a == 4){
                $('#monthTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    startView: 2
                }).on('changeDate', function(e){
                    var val,
                        $target = $(e.target),
                        day = e.date.getDate();
                    if(day > 28) {
                        val = $target.val();
                        setTimeout(function(){
                            $target.val(val.replace(day, '28'));
                        }, 50);

                        $.notify(
                            {message: '因每个月有28天至31天不等，为了防止漏发或出错，当选择日期大于28号时，系统自动为您设置为28号，如果您觉着此行为不妥，请尝试其他发送规则例如“自定义发送”。'},
                            {
                                type: 'warning',
                                delay: 32000,
                                animate: {
                                    enter: 'animated bounceIn',
                                    exit: 'animated bounceOut'
                                }
                            }
                        );
                        return false;
                    }
                });

                $('#monthStartTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
                $('#monthEndTime').datetimepicker({
                    format: 'yyyy-mm-dd hh:00',
                    container: $con,
                    todayHighlight: true,
                    language: 'zh-CN',
                    autoclose: true,
                    minView: 1,
                    maxView: 2
                });
            }
        });

        function dataAddToVmByMobile (vm, data, obj){
            var list = data.data.dataList,
                arr = [];
            for(var i = 0; i < list.length; i ++) {
                obj[list[i].telphone] = list[i];
            }
            for(var j in obj) {
                arr.push(obj[j]);
            }
            vm.data = arr;

            return arr;
        }

        avalon.scan($con[0]);

        $('#btnImportTemp').on('click', function () {
            $.post('modules/message/templist.html', function(data){
                var $temp = $(data);
                $temp.dialog({
                    title: '选择模板',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                                $.post(appName + '/rest/model/selectByPrimaryKey?id=' + $temp.find('input:checked').val(), function(data){
                                    $modelContent.val(data.data.modelContent);
                                    $modelContent.next().val(data.data.id);
                                    $.notify(
                                        {message: '选择成功'},
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

                                close();
                            }
                        },
                        cancel: {
                            label: '取消',
                            className: 'btn-default',
                            handler: function (close) {
                                close();
                            }
                        }
                    }
                });

                var templist = new DataList({
                    id: 'templist',
                    dataUrl: appName + '/rest/model/selectForList?modelStatus=' + 1,
                    modelStatus: {
                        1: '启用',
                        2: '停用'
                    }
                });

                avalon.scan($temp[0]);
            });

        });

        $('#btnClearCont').on('click', function(){
            $modelContent.val('');
        });

        var $btnClass = $('#btnClass'),
            $btnClassMenu = $btnClass.find('.dropdown-menu'),
            $btnAlAdd = $('#btnAlAdd');

        $btnClassMenu.on('click', 'a', function (e){
            var $this = $(this);
            e.preventDefault();
            $btnAlAdd.text($this.text());
            $btnAlAdd.attr('type', $this.attr('type'));
        });

        $btnAlAdd.on('click', function() {
            var type = $(this).attr('type'),
                url = '',
                vmId = 'allist',
                htmlUrl = 'modules/message/allist.html',
                sendUrl = appName + '/rest/sendMessage/selectAddress';

            if(type == 1){
                url = appName + '/rest/address/selectForList?status=1';
            } else if(type == 2){
                url = appName + '/rest/address/selectForList?status=2';
            } else if(type == 3) {
                url = appName + '/rest/patientAddress/selectForList';
                vmId = 'patientList';
                htmlUrl = 'modules/message/patientlist.html';
                sendUrl = appName + '/rest/sendMessage/selectPatientAddress';
            }
            $.post(htmlUrl, function(data){
                var $temp = $(data);
                $temp.dialog({
                    title: '选择联系人',
                    height: '400',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                                $temp.find('#allistForm').serialize();
                                $.post(sendUrl, $temp.find('#allistForm').serialize(), function(data) {
                                    addressjson = dataAddToVmByMobile(mssagePush, data, mssagePushObj);

                                    $.notify(
                                        {message: '选择成功'},
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

                                close();
                            }
                        },
                        cancel: {
                            label: '取消',
                            className: 'btn-default',
                            handler: function (close) {
                                close();
                            }
                        }
                    }
                });

                allist = new DataList({
                    id: vmId,
                    dataUrl: url,
                    sex: {
                        1: '男',
                        2: '女'
                    }
                });

                var $alSearch = $('#al-search');
                $alSearch.on('submit', function (e){
                    e.preventDefault();

                    $.post(url, $alSearch.serialize(), function(data){
                        allist.dataParseToVm(data);
                    }, 'json');

                });

                avalon.scan($temp[0]);
            });

        });

        $('#btnImportPerson').on('click', function() {
            $.post('modules/message/importperson.html', function(data){
                var $temp = $(data);
                $temp.dialog({
                    title: '导入收信人',
                    buttons: {
                        ok: {
                            label: '确认导入',
                            className: 'btn-primary',
                            handler: function (close) {
                                var formData = new FormData($uploadForm[0]);
                                $.ajax({
                                    url: appName + '/rest/sendMessage/upload' ,
                                    type: 'POST',
                                    data: formData,
                                    async: false,
                                    cache: false,
                                    contentType: false,
                                    processData: false,
                                    success: function (data) {
                                        addressjson = dataAddToVmByMobile(mssagePush, data, mssagePushObj);
                                        $.notify(
                                            {message: '导入成功'},
                                            {
                                                type: 'success',
                                                delay: 6000,
                                                animate: {
                                                    enter: 'animated bounceIn',
                                                    exit: 'animated bounceOut'
                                                }
                                            }
                                        );
                                    },
                                    error: function (data) {
                                        $.notify(
                                            {message: data.data},
                                            {
                                                type: 'danger',
                                                delay: 6000,
                                                animate: {
                                                    enter: 'animated bounceIn',
                                                    exit: 'animated bounceOut'
                                                }
                                            }
                                        );
                                    }
                                });

                                close();
                            }
                        },
                        cancel: {
                            label: '取消',
                            className: 'btn-default',
                            handler: function (close) {
                                close();
                            }
                        }
                    }
                });

                var $uploadForm = $('#upload-form');

                avalon.scan($temp[0]);
            });
        });

        $('#btnSelectDisturb').on('click', function() {
            $.post('modules/message/disturblist.html', function(data){
                var $temp = $(data);
                $temp.dialog({
                    title: '选择免打扰',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                                $.post(appName + '/rest/sendMessage/selectNoDisturb', $temp.find('#disturbForm').serialize(), function(data) {
                                    dataAddToVmByMobile(disturb_, data, disturb_Obj, noDisturbojson);
                                    $.notify(
                                        {message: '选择成功'},
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

                                close();
                            }
                        },
                        cancel: {
                            label: '取消',
                            className: 'btn-default',
                            handler: function (close) {
                                close();
                            }
                        }
                    }
                });

                var disturb_list = new DataList({
                    id: 'disturb_list',
                    dataUrl: appName + '/rest/noDisturb/selectForList'
                });

                avalon.scan($temp[0]);
            });
        });

        $mssagePushForm.on('submit', function(e){
            e.preventDefault();

            $.post(appName + '/rest/sendMessage/insert', $mssagePushForm.serialize() + '&addressjson=' +  JSON.stringify(addressjson) + '&noDisturbojson=' + JSON.stringify(noDisturbojson), function (data){
            	if(data.resultCode=="0"){
            		window.location.href="#/outbox";
            	}else{
	                $.notify(
	                    {message: data.data},
	                    {
	                        type: 'success',
	                        delay: 6000,
	                        animate: {
	                            enter: 'animated bounceIn',
	                            exit: 'animated bounceOut'
	                        }
	                    }
	                );
            	}
            });

        });


    }

});