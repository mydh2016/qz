define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){
	var alEditWorkVm = avalon.define({
		$id: 'alEditWork',
		data: {},
		departments:{}
	});

	return function (){
		var $alEditWork = $('#alEditWork'),
			$alEditWorkForm = $('#alEditWorkForm'),
			alId = window.location.href.split('=')[1],
			$con = $('#content').children('div');
		$.post(appName + '/rest/department/selectList', function(data) {
			alEditWorkVm.departments = data.data;
		}, 'json');
		alEditWorkVm.data = {};
		$.post(appName + '/rest/address/selectByPrimaryKey?id=' + alId, function(data){
			alEditWorkVm.data = data.data;
		});

		avalon.scan($alEditWork[0]);

		$alEditWorkForm.on('submit', function(e){
			e.preventDefault();

			$.post(appName + '/rest/address/updateByPrimaryKey', $alEditWorkForm.serialize(), function(data){

				$.notify(
					{message: '保存成功'},
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