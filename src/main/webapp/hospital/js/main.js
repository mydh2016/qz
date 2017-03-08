require.config({
    baseUrl:'js',
    paths:{
        'director': 'lib/director',

        'jquery': 'lib/jquery',
        'dialog': 'lib/plugin/jquery.dialog',
        'touch': 'lib/plugin/jquery.touch',
        'ripple': 'lib/plugin/jquery.ripple',
        'tab': 'lib/plugin/jquery.tab',
        'progress': 'lib/plugin/jquery.progress',
        'drag': 'lib/plugin/jquery.drag',
        'dragsize': 'lib/plugin/jquery.dragSize',
        'btnState': 'lib/plugin/jquery.btnstate',

        'highcharts': 'lib/highcharts',

        'avalon': 'lib/avalon.shim',
        'datalist': 'lib/plugin/avalon.datalist.class',


        'bootstrap': 'lib/plugin/bootstrap.min',
        'bootstrapDate': 'lib/plugin/bootstrap-datetimepicker.min',
        'bootstrapDateZn': 'lib/plugin/bootstrap-datetimepicker.zh-CN',
        'growl': 'lib/plugin/bootstrap-notify.min',

        // bootstrap 表单验证插件
        'bootstrapValidator': 'lib/plugin/bootstrapValidator/bootstrapValidator.min',
        'bootstrapValidatorZn': 'lib/plugin/bootstrapValidator/zh_CN',

        'form': 'form',

        'event': 'event',
        'common': 'common',
        'router': 'router',
        'controller': 'controller',
        'cell': 'mod-catalog',

        'root': '../modules/root',
        
        // 权限控制模块
        'pubperm': 'pubPerm',

        // 文本编辑器
        'simditor': 'lib/plugin/simditor/scripts/simditor.min',
        'simple-module': 'lib/plugin/simditor/scripts/module.min',
        'simple-hotkeys': 'lib/plugin/simditor/scripts/hotkeys.min',
        'simple-uploader': 'lib/plugin/simditor/scripts/uploader.min',

        'lightbox': 'lib/plugin/lightbox/jquery.lightbox'
    },

    map: {
        '*': {
            'css': 'lib/plugin/css'
        }
    },

    shim:{
        director: { exports: 'director' },
        highcharts: { exports: 'highcharts' },
        touch: {
            deps: ['jquery'],
            exports: 'touch'
        },
        'lightbox': {
            deps: ['jquery', 'css!lib/plugin/lightbox/jquery.lightbox.min'],
            exports: 'lightbox'
        },
        'bootstrap': {
            deps: ['jquery'],
            exports: 'bootstrap'
        },
        'bootstrapDate': {
            deps: ['jquery', 'bootstrap', 'css!../css/bootstrap-datetimepicker.min'],
            exports: 'bootstrapDate'
        },
        'bootstrapDateZn': {
            deps: ['bootstrapDate'],
            exports: 'bootstrapDateZn'
        },

        // 表单验证插件
        'bootstrapValidator': {
            deps: ['jquery', 'bootstrap', 'css!lib/plugin/bootstrapValidator/bootstrapValidator.min'],
            exports: 'bootstrapValidator'
        },
        'bootstrapValidatorZn': {
            deps: ['bootstrapValidator'],
            exports: 'bootstrapValidatorZn'
        },

        'form': {
            deps: ['jquery'],
            exports: 'form'
        }
    }
});

require(['root', 'router'], function(){


});