/* ==================================================
 avalon数据表格类 datalist v0.1 2015.12.21 by 培恒
 根据avalon的版本兼容情况可以兼容到ie6，也可以使用放弃兼容低版本浏览器的avalon版本，当然效率也贵更高
 依赖jquery avalon
 参数：
 id {string} dom元素的id也是生成的datalist的唯一标识，数据表格将生成在改dom元素中
 listData {array} 初始数据在datalist刷新前的默认数据
 dataUrl {string} 数据来源
 pageSize {number} 每页多少条
 ================================================== */

define(["jquery", "avalon"], function($, avalon) {

    function DataList(settings) {
        var defaults = {
            $id: '',
            id: '',
            data: {},
            listData: [],
            dataUrl: '',
            pageSize: 10,
            currentPage: 1,
            pageCount: 0,
            total: 0,
            pagination: [1],
            paginationMaxShowPage: 9
        };

        var set = $.extend({}, defaults, settings);
        set.$id = set.id;

        this.id = set.id;
        this.tDom = document.getElementById(set.id);
        this.$pagination = $(this.tDom).find('.pagination');
        this.data = set.data;
        this.listData = set.listData;
        this.dataUrl = set.dataUrl;
        this.vm = avalon.vmodels[set.id] ? avalon.vmodels[set.id] : avalon.define(set);
        this.parameter = {};

        this.init();
    }

    DataList.prototype = {
        init: function (){
            var _this = this;
            var vm = this.vm;
            /*var $table = $(this.tDom);*/

            vm.$watch("pageSize", function(a, b) {
                _this.changePagination();
                vm.currentPage = 1;
                _this.ajaxPage(1, vm.pageSize);
            });
            vm.$watch("currentPage", function(a, b) {
                _this.changePagination();
            });
            vm.$watch("pageCount", function(a, b) {
                _this.changePagination();
            });

            avalon.scan(this.tDom);
            if(_this.dataUrl) {
                _this.ajaxPage(vm.currentPage, vm.pageSize);
            } else {
                _this.dataParseToVm(_this.data);
            }

            /*var $allChecksBtn = $table.find('.allselect'),
                $tbody = $table.find('tbody');

            $tbody.on('click', function(){
                var $checks = $tbody.find(":checkbox");
                if($checks.filter(":checked").length < $checks.length){
                    $allChecksBtn[0].checked = false;
                }
            });

            $allChecksBtn.on('click', function(){
                var $checks = $tbody.find(":checkbox");
                if(this.checked){
                    $checks.each(function(){
                        this.checked = true;
                    });
                }else{
                    $checks.each(function(){
                        this.checked = false;
                    });
                }
            });*/

            this.paginationInit();

        },

        paginationInit: function (){
            var $pagination = this.$pagination,
                $lastBtnTooltip = $pagination.find('.page-last').find('.tooltip'),
                $nextBtnTooltip = $pagination.find('.page-next').find('.tooltip'),
                vm = this.vm,
                _this = this;

            $pagination.on('click', 'a', function(e){
                e.preventDefault();
            });

            $pagination.on('click', '.page-last', function(e){
                var $this = $(this);

                var $pageItems = $this.siblings('.page-num');
                var ind = $pageItems.filter('.active').index('.page-num');

                if(ind <= 0) {
                    $lastBtnTooltip.fadeIn();
                    setTimeout(function(){
                        $lastBtnTooltip.fadeOut();
                    }, 2500);
                    return false;
                }

                vm.currentPage --;
                _this.ajaxPage(vm.currentPage, vm.pageSize);
            });

            $pagination.on('click', '.page-num', function(){
                var $this = $(this),
                    num = $this.text();

                if(_this.isPageNmu(num)){
                    if(vm.currentPage == Number(num)) {
                        return false;
                    }
                    vm.currentPage = Number(num);
                } else {
                    return false;
                }

                _this.ajaxPage(vm.currentPage, vm.pageSize);
            });

            $pagination.on('click', '.page-next', function(){
                var $this = $(this);

                var $pageItems = $this.siblings('.page-num');
                var ind = $pageItems.filter('.active').index('.page-num');

                if(ind >= $pageItems.length - 1) {
                    $nextBtnTooltip.fadeIn();
                    setTimeout(function(){
                        $nextBtnTooltip.fadeOut();
                    }, 2500);
                    return false;
                }

                vm.currentPage ++;
                _this.ajaxPage(vm.currentPage, vm.pageSize);
            });

        },

        ajaxPage: function (currentPage, pageSize, parameter){
            var _this = this;
            if(parameter) {
                if(typeof parameter == 'string'){
                    var parameterObj = {};
                    parameter.split('&').forEach(function(param){
                        param = param.split('=');
                        parameterObj[param[0]] = param[1];
                    });

                    this.parameter = parameterObj;
                } else {
                    this.parameter = parameter;
                }

            }

            $.extend(this.parameter,
                {
                    currentPage: currentPage,
                    pageSize: pageSize
                }
            );

            $.post(
                _this.dataUrl,
                _this.parameter,
                function (data){
                    _this.dataParseToVm(data);
                },
                'json'
            );
        },

        reload: function(){
            this.ajaxPage(this.vm.currentPage, this.vm.pageSize);
        },

        isPageNmu: function (num){
            num = Number(num);
            return !isNaN(num) && typeof num === 'number';
        },

        dataParseToVm: function(data){
            var vm = this.vm;
            vm.listData = data.data.dataList;
            vm.total = data.data.pageCountAll;
            vm.pageCount = Math.ceil(data.data.pageCountAll / vm.pageSize);
        },

        dataAddToVm: function(data){
            var vm = this.vm;
            vm.listData = vm.listData.concat(data.data.dataList);
            vm.total = data.data.pageCountAll;
            vm.pageCount = Math.ceil(data.data.pageCountAll / vm.pageSize);
        },

        changePagination: function (){
            var vm = this.vm,
                pageCount = vm.pageCount,
                str = '',
                strEnd = '',
                pMaxShowPage = vm.paginationMaxShowPage,
                gap = parseInt((pMaxShowPage - 4)/2),
                currentPage = vm.currentPage;

            var start, end;

            if(pageCount > pMaxShowPage) {
                if(currentPage - gap < 3){
                    start = 1;
                } else {
                    start = currentPage - gap;
                    str = '1,...,'
                }
                if(currentPage + gap >= pageCount - 1) {
                    end = pageCount;
                } else {
                    end = currentPage + gap;
                    strEnd = ',...,' + pageCount.toString();
                }
                for(var i = start; i <= end; i ++) {
                    if(i == end) {
                        str += i;
                    } else {
                        str += i + ','
                    }

                }

                str += strEnd;

            } else {
                for(var j = 1; j <= pageCount; j ++) {
                    if(j == pageCount) {
                        str += j;
                    } else {
                        str += j + ',';
                    }
                }
            }

            vm.pagination = str.split(',');

        }

    };

    return DataList;
});

