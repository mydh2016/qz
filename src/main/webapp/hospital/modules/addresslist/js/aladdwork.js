define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState', 'bootstrapValidatorZn'], function($, avalon, common, DataList, mEvent, simditor){

	var aladdworkVm = avalon.define({
		$id: 'aladdwork',
		departments: []
	});

	return function (){
		var $aladdworkForm = $('#aladdworkForm'),
			$con = $('#content').children('div');

		$.post(appName + '/rest/department/selectList', function(data) {
			aladdworkVm.departments = data.data;
		}, 'json');

		// 表单验证参数
		$aladdworkForm.bootstrapValidator({
			feedbackIcons: {
				valid: 'fa fa-check',
				invalid: 'fa fa-remove',
				validating: 'fa fa-refresh'
			},
			fields : {
				name: {
					validators : {
						notEmpty : {}
					}
				},
				telphone: {
					validators : {
						notEmpty : {},
						regexp: {
							regexp: /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i,
							message: '请输入正确的手机号'
						}
					}
				},
				departmentId: {
					validators : {
						notEmpty : {}
					}
				}
			}
		});

		$aladdworkForm.on('submit', function (e){
			e.preventDefault();

			$aladdworkForm.data('bootstrapValidator').validate();
			if($aladdworkForm.data('bootstrapValidator').isValid()) {
				$.post(appName + '/rest/address/insert', $aladdworkForm.serialize(), function (data){
					if(data.resultCode=="0"){
						$.notify(
							{message: "保存成功"},
							{
								type: 'success',
								delay: 6000,
								animate: {
									enter: 'animated bounceIn',
									exit: 'animated bounceOut'
								}
							}
						);
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

		});

		$('#dateBirth').datetimepicker({
			format: 'yyyy-mm-dd',
			container: $con,
			todayHighlight: true,
			language: 'zh-CN',
			autoclose: true,
			minView: 2,
			maxView: 2
		});

	}
});