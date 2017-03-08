$(function(){
    // 点击科室进行切换
    $(".hsDoctor_content_list li").on("click",function(){
        this.className="active";
        $(this).siblings('li').removeClass('active');
    })
})