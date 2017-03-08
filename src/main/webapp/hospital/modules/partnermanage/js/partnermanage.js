define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl', 'bootstrapValidatorZn'], function($, avalon, common, DataList){

    var addPartnerVm = avalon.define({
        $id: 'partnerData',
        data: {},
        upload: 0,
        addUser: 0,

        hospLevel: [],

        currentProvince: '',
        province: [],
        currentCities: '',
        cities: [],
        currentAreas: '',
        areas: []
    });

    var cityData = [];

    addPartnerVm.$watch("currentProvince", function(a, b) {
        addPartnerVm.currentProvince =  a;

        for(var i = 0; i < cityData.length; i ++) {
            if(cityData[i].province == a) {
                addPartnerVm.cities = cityData[i].citys;
                addPartnerVm.currentCities = cityData[i].citys[0].city;
                break;
            }
        }
    });

    addPartnerVm.$watch("currentCities", function(a, b) {
        addPartnerVm.currentCities = a;

        for(var j = 0; j < addPartnerVm.cities.length; j ++) {
            if(addPartnerVm.cities[j].city == a) {
                addPartnerVm.areas = addPartnerVm.cities[j].areas;
                addPartnerVm.currentAreas = addPartnerVm.cities[j].areas[0].area;
                break;
            }
        }

    });

    return function (){
        var $con = $ ('#content').children('div'),
            $searchForm = $('#partner-search');

        var partnerList = new DataList({
            id: 'partnerList',
            dataUrl: appName + '/rest/partner/getPartners?status=1'
        });

        var $table = $(partnerList.tDom);

        $('#dateStart').datetimepicker({
            format: 'yyyy-mm-dd',
            container: $con,
            todayHighlight: true,
            language: 'zh-CN',
            autoclose: true,
            minView: 2,
            maxView: 2
        });
        $('#dateEnd').datetimepicker({
            format: 'yyyy-mm-dd',
            container: $con,
            todayHighlight: true,
            language: 'zh-CN',
            autoclose: true,
            minView: 2,
            maxView: 2
        });

        $searchForm.on('submit', function (e){
            e.preventDefault();
            var t = new Date().getTime();
            $.post(appName + '/rest/partner/getPartners', $searchForm.serialize()+"&t="+t, function(data){
            	partnerList.dataParseToVm(data);
            }, 'json');
        });

        $table.on('click', '.partner-edit', function(){
            var partnerId = $(this).closest('tr').attr('data-partnerId');
            var $dialogContent;
            $.ajax({
                type: "POST",
                async: false,
                url: "modules/partnermanage/editpartner.html",
                success: function(data){
                    $dialogContent = $(data).dialog({
                        title: '编辑医院',
                        height: '460',
                        width:'850',
                        buttons: {
                            ok: {
                                label: '修改',
                                className: 'btn-primary',
                                handler: function (close) {
                                    $editPartnerForm.data('bootstrapValidator').validate();
                                    if($editPartnerForm.data('bootstrapValidator').isValid()) {
                                        $.post(appName + '/rest/partner/saveOrUpdatePartner', $editPartnerForm.serialize(), function(data){
                                            partnerList.reload();
                                            if(data.resultCode==0){
                                                $.notify(
                                                    {message: '编辑成功'},
                                                    {
                                                        type: 'success',
                                                        delay: 6000,
                                                        animate: {
                                                            enter: 'animated bounceIn',
                                                            exit: 'animated bounceOut'
                                                        }
                                                    }
                                                );
                                                close();
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
                                    }

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

                    var $editPartnerForm = $('#edit-partner-form');

                    // 表单验证参数
                    $editPartnerForm.bootstrapValidator({
                        feedbackIcons: {
                            valid: 'fa fa-check',
                            invalid: 'fa fa-remove',
                            validating: 'fa fa-refresh'
                        },
                        fields : {
                            companyName: {
                                validators : {
                                    notEmpty : {}
                                }
                            },
                            ssid: {
                                validators : {
                                    notEmpty : {}
                                }
                            }
                        }
                    });

                    addPartnerVm.currentProvince = '';
                    addPartnerVm.currentCities = '';
                    addPartnerVm.currentAreas = '';
                }
            });

            $.post(appName + '/rest/partner/getHospLevel', function (data) {
                if(data.resultCode == '0') {
                    addPartnerVm.hospLevel = data.data;
                }
            }, 'json');

            $.ajax({
                type: "POST",
                async: false,
                url: appName + "/rest/partner/getPartnerById",
                data: {partnerId: partnerId},
                dataType: "json",
                success: function(data){
                	addPartnerVm.data = data;
                	addPartnerVm.addUser = 1;
                	
                	addPartnerVm.currentProvince = data.province;
                    addPartnerVm.currentCities = data.city;
                    addPartnerVm.currentAreas = data.area;
                   
                	
                    avalon.scan($dialogContent[0]);
                }
            });
            
            $.post('cities.json', function (data){
            	var thisProvinceData, thisCityData;

                cityData = data;
            	addPartnerVm.province = data;

                for(var i = 0; i < data.length; i ++) {
                    if(data[i].province == addPartnerVm.currentProvince) {
                        thisProvinceData = data[i].citys;
                        break;
                    }
                }

                addPartnerVm.cities = thisProvinceData;

                for(var j = 0; j < thisProvinceData.length; j ++) {
                    if(thisProvinceData[j].city == addPartnerVm.currentCities) {
                        thisCityData = thisProvinceData[j].areas;
                        break;
                    }
                }

                addPartnerVm.areas = thisCityData;
            	
            }, 'json');


        })
            .on('click', '.partner-delete', function(){
                var partnerId = $(this).closest('tr').attr('data-partnerId');
                $.post(appName + '/rest/partner/deletePartner', {partnerId: partnerId}, function(data){
                	partnerList.reload();
                    $.notify(
                            {message: '成功'},
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

         var $addPartner = $('#add-partner');
         $addPartner.on('click', function(){
            $.post('modules/partnermanage/addpartner.html', function(data){
                var $dialog = $(data);
                $dialog.dialog({
                    title: '添加医院',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                                $addPartnerForm.data('bootstrapValidator').validate();
                                if($addPartnerForm.data('bootstrapValidator').isValid()) {
                                    $.post(appName + '/rest/partner/saveOrUpdatePartner', $addPartnerForm.serialize(), function(data){
                                        if(data.resultCode==0){
                                            partnerList.reload();
                                            $.notify(
                                                {message: '创建成功'},
                                                {
                                                    type: 'success',
                                                    delay: 6000,
                                                    animate: {
                                                        enter: 'animated bounceIn',
                                                        exit: 'animated bounceOut'
                                                    }
                                                }
                                            );
                                            close();
                                        }else{
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
                                }

                            }
                        },
                        cancel : {
                            label: '取消',
                            className: 'btn-default',
                            handler: function (close) {
                                close();
                            }
                        }
                    }
                });

                var $addPartnerForm = $('#addPartnerForm');

                // 表单验证参数
                $addPartnerForm.bootstrapValidator({
                    feedbackIcons: {
                        valid: 'fa fa-check',
                        invalid: 'fa fa-remove',
                        validating: 'fa fa-refresh'
                    },
                    fields : {
                        companyName: {
                            validators : {
                                notEmpty : {}
                            }
                        },
                        ssid: {
                            validators : {
                                notEmpty : {}
                            }
                        }
                    }
                });

                $.post(appName + '/rest/partner/getHospLevel', function (data) {
                    if(data.resultCode == '0') {
                        addPartnerVm.hospLevel = data.data;
                    }
                }, 'json');

                $.post('cities.json', function (data){
                    var thisProvinceData, thisCityData;

                    cityData = data;
                	addPartnerVm.province = data;
                    addPartnerVm.currentProvince =  '甘肃省';

                    for(var i = 0; i < data.length; i ++) {
                        if(data[i].province == '甘肃省') {
                            thisProvinceData = data[i].citys;
                            break;
                        }
                    }

                    addPartnerVm.currentCities = '兰州市';
                    addPartnerVm.cities = thisProvinceData;

                    for(var j = 0; j < thisProvinceData.length; j ++) {
                        if(thisProvinceData[j].city == '兰州市') {
                            thisCityData = thisProvinceData[j].areas;
                            break;
                        }
                    }

                    addPartnerVm.areas = thisCityData;
                }, 'json');

                avalon.scan($dialog[0]);
            });
        });
        
    }

});