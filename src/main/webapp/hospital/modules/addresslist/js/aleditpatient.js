define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){
	var aleditpatientVm = avalon.define({
		$id: 'aleditpatient',
		data: {},
		type: []
	});

	return function (){
		var $aleditpatient = $('#aleditpatient'),
			$aleditpatientForm = $('#aleditpatientForm'),
			alId = window.location.href.split('=')[1],
			$con = $('#content').children('div');

		aleditpatientVm.data = {};

		$.post(appName + '/rest/patientAddress/selectCategory', function(data){
			aleditpatientVm.type = data.data;
		});
		$.post(appName + '/rest/patientAddress/selectByPrimaryKey?id=' + alId, function(data){
			aleditpatientVm.data = data.data;
		});

		avalon.scan($aleditpatient[0]);

		$aleditpatientForm.on('submit', function(e){
			e.preventDefault();

			$.post(appName + '/rest/patientAddress/update', $aleditpatientForm.serialize(), function(data){
				if(data.resultCode == 0){
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