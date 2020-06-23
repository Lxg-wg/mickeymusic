/**
 * 传入的控件点击时,切换另一个控件的透明度及显示状态
 * @param clickEle 被点击控件
 * @param targetEle 要改变的控件
 * @param step 每次改变透明度的步长
 * @param target 改变透明度的目标
 * @param now 控件现在透明度
 */
function toggleOpacity(clickEle, targetEle, step, target, now) {
    clickEle.click(function () {
        targetEle.css("display", "inline-block");
        //当前动画没完成再次点击无效
        if (typeof targetEle.finish == "undefined" || targetEle.finish) {
            if (targetEle.css("opacity") !== "1") {
                opacity(targetEle, step, target);
            } else {
                opacity(targetEle, -step, now);
            }
        }
    })
}

/**
 * 改变元素的透明度
 * @param ele 要改变的元素
 * @param step 透明度的步长
 * @param target 目标
 */
function opacity(ele, step, target) {
    ele.finish = false;
    ele.op = 1 - target;
    ele.timer = setInterval(function () {
        ele.op += step
        if (step < 0) {
            if (ele.op <= target) {
                ele.op = target;
                clearInterval(ele.timer);
                ele.css("display", "none");
                ele.finish = true;
            }
        } else {
            if (ele.op >= target) {
                ele.op = target;
                clearInterval(ele.timer);
                ele.finish = true;
            }
        }
        ele.css("opacity", ele.op)
    }, 1000 / 60)
}

/**
 * 根据歌曲信息播放歌曲及显示歌曲的信息
 * @param songInfo 歌曲信息
 */
function playForSongInfo(songInfo) {
    let playLink = "";
    $.ajax({
        url: "/mickey/play",
        type: "post",
        async: false,
        data_type: "json",
        contentType: "application/json",
        data: JSON.stringify({"songInfo": songInfo}),
        success: function (res) {
            if (res !== "-1") {
                playLink = res;
            }
        },
        error: function () {
            console.log("error")
        }
    });
    if (!audio.paused) {
        audio.pause();
    }
    localStorage.setItem("songInfo", JSON.stringify(songInfo))
    playForPlayLink(playLink,songInfo)
    displayMusic(songInfo);
    displayAlbumArt(songInfo["albumId"])
}

/**
 * 根据歌曲播放链接
 * @param playLink 播放链接
 * @param songInfo 歌曲信息
 * @param current_time 当前歌曲播放进度,可不选
 */
function playForPlayLink(playLink, songInfo, current_time = 0) {
    window.audio.src = playLink
    audio.autoplay = true;
    try {
        audio.play();
    }catch (e) {
        tipFrag("音乐异常","获取资源失败")
    }

    localStorage.setItem("playLink", playLink);
    $("#playToggle").attr("src", "/static/img/icon/pause.png");
    audio.volume = volume;
    audio.currentTime = current_time
    audio.ontimeupdate = function () {
        let val = $seekBarProgress.val();
        localStorage.setItem("current_time", "" + audio.currentTime);
        let m = Math.floor(val / 60);
        let s = Math.floor(val % 60);
        $("#now").html((m > 9 ? m : "0" + m) + ":" + (s > 9 ? s : "0" + s));
    }
    return audio
}

/**
 * 通过ajax的方式发送表单
 * @param url 请求的链接地址
 * @param formEle 表单元素
 * @param data 发送的数据
 * @returns {string} 返回字符判断是否发送成功
 */
function sendFormForAjax(url, formEle, data) {
    let res = "";
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            res = result;
        },
        error: function () {
            res = "false"
        }
    })
    return res;
}