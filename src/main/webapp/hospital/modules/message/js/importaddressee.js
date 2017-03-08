define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var $uploadForm = $('#upload-form');

		$uploadForm.on('submit', $uploadForm.serialize(), function(e){
			e.preventDefault();

		});

	}
});