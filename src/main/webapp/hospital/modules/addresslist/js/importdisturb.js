define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var $uploadForm = $('#upload-form');

		$uploadForm.on('submit', function(e){
			e.preventDefault();

			var formData = new FormData($uploadForm[0]);
			$.ajax({
				url: appName + '/rest/noDisturb/upload' ,
				type: 'POST',
				data: formData,
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
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

		});

	}
});