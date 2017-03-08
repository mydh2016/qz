$(function() {
    // 给日期添加点击效果
    var keyRight = $(".hsDepartment_table_rowYou");
    var keyLeft = $(".hsDepartment_table_rowZuo");
    var parentNodeWidth = $(".hsDepartment_table_date").width();
    var childNode = $(".hsDepartment_table ul");
    var childLis = $(".hsDepartment_table ul li");
    var pic = 0;
    keyRight.on("click", function() {
        pic++;
        var target = -pic * parentNodeWidth;
        if (pic == Math.floor(childLis.length/21)-1) {
            animate(childNode, -5 * parentNodeWidth);
        } else if (pic > Math.floor(childLis.length/21)-1) {
            pic = Math.floor(childLis.length / 21);
            return false;
        }
        animate(childNode, target);
    })
    keyLeft.on("click", function() {
            if (pic <= 0) {
                pic = 0;
                animate(childNode, 0);
            } else {
                pic--;
                var target = -pic * parentNodeWidth;
                animate(childNode, target);
            }
        })
        // 添加日期
    var liWeeks = $(".week");
    var liDates = $(".date");
    date(liWeeks, liDates);
    // 日期
    function date(liWeeks, lis) {
        var currentDate = new Date();
        //    获取年
        var year = currentDate.getFullYear();
        //    获取月份
        var month = currentDate.getMonth() + 1;
        //  获取日期
        var day = currentDate.getDate();
        //    获取星期
        var week = currentDate.getDay();

        //   未来日期
        var futureDay = day + 29;
        //    日期记录
        var j = 1;
        //    判断年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            //        闰年
            if (month == 1) {
                for (var i = 0; i < lis.length; i++) {
                    if (day + i <= 31) {
                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
                    } else if (day + i >= 32) {
                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
                    }
                }
            } else if (month == 2) {
                for (var i = 0; i < lis.length; i++) {
                    if (day + i <= 29) {
                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
                    } else if (day + i >= 30) {
                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
                    }
                }
            }
        } else {
            //        平年
            if (month == 1) {
                for (var i = 0; i < lis.length; i++) {
                    if (day + i <= 31) {
                        lis[i].innerHTML = year + "-" + '1' + "-" + (day + i);
                    } else if (day + i >= 32) {
                        lis[i].innerHTML = year + "-" + '2' + "-" + (j++);
                    } else if (day + i == 59) {
                        lis[i].innerHTML = year + "-" + '3' + "-" + (1);
                    }
                }
            } else if (month == 2) {
                for (var i = 0; i < lis.length; i++) {
                    if (day + i <= 28) {
                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
                    } else if (day + i >= 29) {
                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
                    }
                }
            }
        }
        //    平年
        if (month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
            for (var i = 0; i < lis.length; i++) {
                if (day + i <= 31) {
                    lis[i].innerHTML = year + "-" + month + "-" + (day + i);
                } else if (day + i >= 32) {
                    lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
                }
            }
        } else if (month == 12) {
            for (var i = 0; i < lis.length; i++) {
                if (day + i <= 31) {
                    lis[i].innerHTML = year + "-" + "12" + "-" + (day + i);
                } else if (day + i >= 32) {
                    lis[i].innerHTML = (year + 1) + "-" + "1" + "-" + (j++);
                }
            }

        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            for (var i = 0; i < lis.length; i++) {
                if (day + i <= 30) {
                    lis[i].innerHTML = year + "-" + month + "-" + (day + i);
                } else if (day + i >= 31) {
                    lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
                }
            }
        }
        //计算周几

        for (var k = 0; k < liWeeks.length; k++) {
            if ((week + k) % 7 == 0) {
                liWeeks[k].innerHTML = "星期日"
            } else if ((week + k) % 7 == 1) {
                liWeeks[k].innerHTML = "星期一"
            } else if ((week + k) % 7 == 2) {
                liWeeks[k].innerHTML = "星期二"
            } else if ((week + k) % 7 == 3) {
                liWeeks[k].innerHTML = "星期三"
            } else if ((week + k) % 7 == 4) {
                liWeeks[k].innerHTML = "星期四"
            } else if ((week + k) % 7 == 5) {
                liWeeks[k].innerHTML = "星期五"
            } else if ((week + k) % 7 == 6) {
                liWeeks[k].innerHTML = "星期六"
            }
        }
    }
    // 轮播图
    function animate(obj, target) {
        clearInterval(obj.timer);
        obj.timer = setInterval(function() {
            var leader = obj.offsetLeft;
            var step = 30;
            step = leader < target ? step : -step;
            if (Math.abs(target - leader) >= Math.abs(step)) {
                leader = leader + step;

                obj.css("left", leader);
            } else {
                obj.css("left", target);
                clearInterval(obj.timer);
            }
        }, 18);
    }
})