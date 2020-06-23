/**
 * 根据小球点击的位置设置进度条的值
 * @param bullet 小球控件
 * @param progress 进度条控件
 * @param bulletLeft 小球初始左边距
 * @param progressW 进度条长度
 * @param event 点击事件对象
 * @returns {number} 返回进度条的值
 */
function progressClick(bullet, progress, bulletLeft, progressW, event) {
    let now_x = event.offsetX;
    bullet.css({left: now_x});
    progress.value = (now_x / progressW * progress.max)
    return progress.value;
}

/**
 * 设置进度条的值
 */
function setValue() {
    volume = voiceProgress.value / voiceProgress.max;
    audio.volume = volume;
    audio.currentTime = seekBarProgress.value;
}
/**
 * 根据小球拖拽的位置设置进度条的值
 * @param bullet 小球控件
 * @param progress 进度条控件
 * @param bulletLeft 小球初始左边距
 * @param progressW 进度条长度
 * @param event 点击事件对象
 * @returns {number} 返回进度条的值
 */
function progressDrag(bullet, progress, bulletLeft, progressW, event) {
    let offset_x = bullet.position().left;//x坐标
    /* 获取当前鼠标的坐标 */
    let mouse_x = event.pageX;
    /* 绑定拖动事件 */
    $(document).on("mousemove", function (ev) {
        /* 计算鼠标移动了的位置 */
        let _x = ev.pageX - mouse_x;
        /* 设置移动后的元素坐标 */
        let now_x = (offset_x + _x);
        if (now_x < bulletLeft) {
            now_x = bulletLeft;
        }
        if (now_x > bulletLeft + progressW) {
            now_x = bulletLeft + progressW;
        }
        /* 改变目标元素的位置 */
        bullet.css({left: now_x});
        progress.value=now_x/progressW*progress.max
        console.log(progress.value)
    });
    setValue()
    return progress.value;
}

/**
 * 开始进度条动画
 * @param eleProgress 进度条控件
 * @param step 进度条挪动的步长
 * @param eleBullet 小球控件
 * @param distance 小球挪动的步长
 * @param bulletLeft 小球的左边距
 */
function startProgress(eleProgress, step, eleBullet, distance, bulletLeft) {
    function reset() {
        clearInterval(eleProgress.timer);
        eleProgress.value = 0;
        eleBullet.css("left", bulletLeft)
        $("#now").html("00:00");
    }
    step = step / 10.0;
    distance = distance / 10.0;
    if (eleProgress.timer !== -1) {
        reset();
    }
    eleProgress.timer = setInterval(function () {
        eleProgress.value = eleProgress.value + step;
        eleBullet.css("left", eleBullet.position().left + distance + "px");
        if (eleProgress.value===eleProgress.max) {
            reset();
        }
    }, 100)
}
