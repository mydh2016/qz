define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var selectDisturbList = new DataList({
			id: 'selectDisturbList',
			dataUrl: '/模板列表接口'
		});

		avalon.scan();

	}
});