$(function(){

    /*
     * Text Feild
     */

    //Add blue animated border and remove with condition when focus and blur
    $('body').on('focus', '.form-control', function(){
        $(this).closest('.fg-line').addClass('fg-toggled');
    })
        .on('blur', '.form-control', function(){
            var p = $(this).closest('.form-group');
            var i = p.find('.form-control').val();

            if (p.hasClass('fg-float')) {
                if (i.length == 0) {
                    $(this).closest('.fg-line').removeClass('fg-toggled');
                }
            }
            else {
                $(this).closest('.fg-line').removeClass('fg-toggled');
            }
        });
});