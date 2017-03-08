$(function(){
    // 点击添加出现添加内容
    var add=$(".hsAppInfo_person_choose_info .addBtn");
    var addTable=$(".hsAppInfo_person_choose_add");
    add.on("click",function(){
        addTable.fadeIn(300);
    })
})