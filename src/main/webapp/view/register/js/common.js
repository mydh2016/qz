function swipe(parentBox,childBox) {
        /**
         * 1.滑动Y轴方向的滑动  touch时间y手方向的坐标轴的改变
         * 2.确定滑动区间
         * 3.确定定位区间
         * 4.点击分类要求改变样式
         * 5.点击过后 要判断是否有滑动的位子，当前被点击的盒子要求  滑动到和顶部对其的位子 transition
         * 6.点击的时候 要判断是否有滑动的位子 没有滑动的位子保持不动
         * */
        //父盒子高度
        var parentHeight = parentBox.height();
        console.log(parentHeight)

    //子盒子高度
        var childHeight = childBox.height();
        // 子盒子距顶部的距离
        var childTop=childBox[0].offsetTop;
        //滑动和定位区间
        //定位区间
        var maxPosition = 0;
        var minPosition = parentHeight-childTop- childHeight;
        //滑动区间b
        var maxSwipe = maxPosition;
        var minSwipe = minPosition;
        //当前定位
        var currentY = 0;
        //加过渡
        var addTransition = function () {
            childBox[0].style.transition = "all 0.3s";
            childBox[0].style.webkitTransition = "all 0.3s";
        }
        //清楚过渡
        var removeTransition = function () {
            childBox.css("transition", "none");
            childBox.css("webkitTransition", "none");
        }
        //定位
        var setTranslateY = function (translateY) {
        	if(minPosition<0){
        		childBox[0].style.transform = "translateY(" + translateY+ "px)";
                childBox[0].style.webkitTransform = "translateY(" + translateY + "px)";
        	}else{
        		childBox[0].style.transform = "translateY(" + 0+ "px)";
                childBox[0].style.webkitTransform = "translateY(" + 0 + "px)";
        	}
            

        }
        //1.滑动Y轴方向的滑动
        var startY = 0;
        var moveY = 0;
        var distanceY = 0;
        var isMove = false;
        childBox[0].addEventListener("touchstart", function (e) {
            startY = e.touches[0].clientY;
        })
        childBox[0].addEventListener("touchmove", function (e) {
            var moveY = e.touches[0].clientY;
            distanceY = moveY - startY;
            //清除过渡
            removeTransition();
            //在滑动区间内滑动
            if ((currentY + distanceY ) < maxSwipe && (currentY + distanceY ) > minSwipe) {
                setTranslateY(currentY + distanceY);
            }
            isMove = true;
        })
        childBox[0].addEventListener("touchend", function (e) {
            if ((currentY + distanceY) > maxPosition) {
                currentY = maxPosition;
                addTransition();
                setTranslateY(currentY);
            } else if ((currentY + distanceY) < minPosition) {
                currentY = minPosition;
                addTransition(currentY);
            } else {
                currentY = currentY + distanceY
//                addTransition(currentY);
            }
            startY = 0;
            moveY = 0;
            distanceY = 0;
            isMove = false;
        })

    }
