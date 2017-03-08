require(['jquery', 'event', 'avalon', 'common', 'dialog', 'progress', 'controller', 'ripple', 'bootstrap', 'form'], function($, mEvent, avalon, common){
    $(function(){
        var $head = $('#header'),
            //$settings = $('#settings'),

            /*$toTop = $('#toTop'),

            $searchBar = $('#searchBar'),
            $searchForm = $('#searchForm'),
            $searchInput = $('#searchInput'),*/

            $win = $(window),
            $settings = $('#settings'),
            $sider = $('#sider'),
            $siderToggle = $('#siderToggle'),
            $wrap = $('#wraper'),
            $con = $wrap.find('#content'),

            $progress = $head.progress();

            vm = avalon.vmodels;

        /*function toTopToggle(){
            if($con.scrollTop()>$win.height()/2){
                $toTop.fadeIn();
            }else{
                $toTop.fadeOut();
            }
        }

        $con.on('scroll', function(){
            toTopToggle();
        });
        toTopToggle();*/

        /*$('#searchBtn').on(mEvent.pointclick, function(){
            $searchBar.addClass('search-open');
        });
        $searchBar.find('.search-close').on(mEvent.pointclick, function(){
            $searchBar.removeClass('search-open');
        });
        $searchForm.on('submit', function(e){
            e.preventDefault();
            window.location.href = "#/playlist/" + $searchInput.val().replace(' ', '+') + '/1';

        });*/

        // 设置框初始化选择
        $settings.children('.select-theme').each(function(){
            var $this = $(this);
            if($this.attr('theme') == vm.root.theme){
                $this.addClass('check');
                return false;
            }
        });

        /*$('#searchBtn').on(mEvent.pointclick, function(){
            $searchBar.addClass('search-open');
        });
        $searchBar.find('.search-close').on(mEvent.pointclick, function(){
            $searchBar.removeClass('search-open');
        });
        $searchForm.on('submit', function(e){
            e.preventDefault();
            window.location.href = "#/playlist/" + $searchInput.val().replace(' ', '+') + '/1';

        });*/
        $('#profile-show').on(mEvent.pointclick, function(){
            var $this = $(this);
            $this.addClass('open');
        });

        $sider.on(mEvent.pointclick, '.sider-item>a', function(){
            $(this).parent().toggleClass('menu').siblings('.sider-item').removeClass('menu');
        }).on(mEvent.pointclick, function(e){
            e.stopPropagation();
        });

        $sider.on(mEvent.pointclick, '.adorn a', function (){
            $sider.find('.adorn').find('a').removeClass('act');
            $(this).addClass('act');

        });

        $siderToggle.bind(mEvent.pointclick, function(e){
            e.stopPropagation();
            $(this).toggleClass('sider-open');
            $wrap.toggleClass('toggle');
        });

        $(document).on(mEvent.pointclick, function() {
            if($win.width() < 768){
                $wrap.removeClass('toggle');
                $siderToggle.addClass('sider-open');
            }
        });

        $('.dropdown-toggle').dropdown();

        common.ie8Handler(function(){
            $head.find('.ripple').ripple({animateClass: 'ripple-light'});
            $wrap.find('.ripple').ripple();

            $(document).ajaxStart(function() {
                $progress.start();
            });
            $(document).ajaxComplete(function() {
                $progress.complete();
            });
        });


    });
});