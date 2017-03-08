define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState', 'bootstrapValidatorZn'], function($, avalon, common, DataList, mEvent, simditor){
	var aladdpatientVm = avalon.define({
		$id: 'aladdpatient',
		type: []
	});

	return function (){
		var $addPatientForm = $('#addPatientForm'),
			$con = $('#content').children('div');

		$.post(appName + '/rest/patientAddress/selectCategory', function(data){
			aladdpatientVm.type = data.data;
		});

		// 表单验证参数
		$addPatientForm.bootstrapValidator({
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
				}
			}
		});

		$addPatientForm.on('submit', function (e){
			e.preventDefault();

			$addPatientForm.data('bootstrapValidator').validate();
			if($addPatientForm.data('bootstrapValidator').isValid()) {
				$.post(appName + '/rest/patientAddress/insert', $addPatientForm.serialize(), function (data){
					if(data.resultCode == 0){
						$.notify(
							{message: '添加成功'},
							{
								type: 'success',
								delay: 6000,
								animate: {
									enter: 'animated bounceIn',
									exit: 'animated bounceOut'
								}
							}
						);
					} else {
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