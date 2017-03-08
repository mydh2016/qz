$(function(){
    // 判断当点击二维码时，模态框显示二维码，当点击删除按钮时，模态框显示删除提示
    // 获取二维码元素
    var erweima=$(".icon-erweima");
    var erweimaModel=$(".hsRecordQuery_modal_img");
    // 获取提示框
    var delBtns=$(".btn");
    var tipModel=$(".hsRecordQuery_modal_tip");
    $.each(erweima,function(index,value){
        value.onclick=function(){
            erweimaModel.addClass('active');
            tipModel.removeClass('active');
        }
    })
    $.each(delBtns,function(index,value){
        value.onclick=function(){
            erweimaModel.removeClass('active');
            tipModel.addClass('active');
        }
    })
})

