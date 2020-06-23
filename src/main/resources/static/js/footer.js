let $voiceBullet = $("#voice .bullet");
let $voiceProgress = $("#voice progress");
let $seekBarBullet = $("#seekBar .bullet");
let $seekBarProgress = $("#seekBar progress");
let volume = $voiceProgress.val() / 100;
let seekBarBulletLeft = $seekBarBullet.position().left;
let voiceBulletLeft = $voiceBullet.position().left - 126;
let voiceProgressW = $voiceProgress.width();
let seekBarProgressW = $seekBarProgress.width();
let seekBarProgress = document.getElementById("seekBarProgress");
let voiceProgress = document.getElementById("voiceProgress");
let distance = 0;
seekBarProgress.timer = -1;
let album_art = "http://imgcache.qq.com/music/photo/album_300/17/300_albumpic_";

/**
 * 显示音乐信息
 * @param songInfo 音乐实体对象
 * @param current_time 当前播放时间,默为零
 */
function displayMusic(songInfo, current_time = 0) {
    $("#total").html(songInfo["intervalMmss"]);
    $("#song").html(interceptionTooLong(songInfo["songName"], 6));
    $("#singer").html(interceptionTooLong(songInfo["singerName"]), 9);
    seekBarProgress.max = songInfo["interval"];
    seekBarProgress.value = current_time;
    $seekBarBullet.css({left: seekBarBulletLeft + seekBarProgress.value / seekBarProgress.max * seekBarProgressW + "px"})
    distance = seekBarProgress.offsetWidth / songInfo["interval"];
    if (current_time !== 0) {
        seekBarProgress.timer = -1;
    }
    startProgress(seekBarProgress, 1, $seekBarBullet, distance, seekBarBulletLeft, audio);
}

/*添加进度条点击事件*/
$voiceProgress.click(function (event) {
    progressClick($voiceBullet, voiceProgress, voiceBulletLeft, voiceProgressW, event)
    volume = voiceProgress.value / voiceProgress.max;
    if (audio != null) {
        audio.volume = volume;
    }
})
$seekBarProgress.click(function (event) {
    const val = progressClick($seekBarBullet, seekBarProgress, seekBarBulletLeft, seekBarProgressW, event)
    if (audio != null) {
        audio.currentTime = val;
    }
})
/*添加进度条圆球拖拽事件*/
$voiceBullet.mousedown(function (event) {
    progressDrag($voiceBullet, voiceProgress, voiceBulletLeft, voiceProgressW, event);
})
$seekBarBullet.mousedown(function (event) {
    progressDrag($seekBarBullet, seekBarProgress, seekBarBulletLeft, seekBarProgressW, event);
})
$(document).mouseup(function () {
    $(this).off("mousemove");
})

playList.init = true;
// 点击按钮播放下一曲(若已经登录)
$("#next").click(function () {
    if (playList.opt !== -1) {
        playList.opt++;
    } else {
        getMusicHistory()
    }
    if (playList.init && localStorage.getItem("playLink") !== "" && "playLink" != null) {
        let songInfo = JSON.parse(localStorage.getItem("songInfo"));
        playList.opt = (playList.res || []).findIndex((ele) => ele["songId"] === songInfo["songId"])
        playList.opt++
        playList.init = false;
    }
    if (playList.opt === playList.res.length) {
        playList.opt = 0;
    }
    let songInfo = playList.res[playList.opt]
    togglePlayOpt();
    playForSongInfo(songInfo);
})
// 点击按钮播放上一曲(若已经登录)
$("#previous").click(function () {
    if (playList.opt !== -1) {
        playList.opt--;
    } else {
        getMusicHistory()
    }
    if (playList.init && localStorage.getItem("playLink") !== "" && "playLink" != null) {
        let songInfo = JSON.parse(localStorage.getItem("songInfo"));
        playList.opt = (playList.res || []).findIndex((ele) => ele["songId"] === songInfo["songId"])
        playList.opt--
        playList.init = false;
    }
    if (playList.opt === -1) {
        playList.opt = playList.res.length - 1;
    }
    let songInfo = playList.res[playList.opt]
    togglePlayOpt();
    playForSongInfo(songInfo);
})

/**
 * 获得播放列表并保存到playList.res属性中
 */
function getMusicHistory() {
    if(playList.res!=null){
        return
    }
    $.ajax({
        url: "/user/musichistory",
        type: "get",
        async: false,
        data_type: "json",
        contentType: "application/json",
        success: function (res) {
            if (res === "no login") {
                tipFrag("登录", "登录后才可以进行该操作")
            }
            playList.res = res;
            if (playList.opt !== -1) {
                playList.opt = 0;
            }
        },
        error: function () {
            console.log("error")
        }
    })
}

/**
 * 切换音乐选中状态
 */
function togglePlayOpt(){
    if(playList.bl){
        $("#history ul li a").removeClass("opt");
        $("#history ul li a:eq("+(playList.opt)+")").addClass("opt");
    }
}
let loop = $("#loop");
loop.bl = false;
let shuffle = $("#shuffle");
shuffle.bl = false;
let rank = $("#rank");
rank.bl = false;
//循环模式点击事件
loop.click(function () {
    rank.attr("src", "/static/img/icon/rank.png")
    shuffle.attr("src", "/static/img/icon/shuffle.png")
    toggleImg(loop, ["/static/img/icon/loop.png", "/static/img/icon/loop1.png", "/static/img/icon/loop2.png", "/static/img/icon/loop3.png"], 60)
    audio.removeEventListener('ended', shuffle1, false)
    audio.removeEventListener('ended', rank1, false)
    audio.addEventListener('ended', loop1, false);
})

function loop1() {
    getMusicHistory();
    playForSongInfo(playList.res[playList.opt]);
    togglePlayOpt()
}
//随机模式点击事件
shuffle.click(function () {
    loop.attr("src", "/static/img/icon/loop.png")
    rank.attr("src", "/static/img/icon/rank.png")

    toggleImg(shuffle, ["/static/img/icon/shuffle.png", "/static/img/icon/shuffle1.png", "/static/img/icon/shuffle2.png", "/static/img/icon/shuffle3.png"], 100);
    audio.removeEventListener('ended', loop1, false)
    audio.removeEventListener('ended', rank1, false)
    audio.addEventListener('ended', shuffle1, false);
})

function shuffle1() {
    getMusicHistory();
    playList.opt=Math.floor(Math.random() * playList.res.length-1);
    playForSongInfo(playList.res[playList.opt]);
    togglePlayOpt();

}
//顺序模式点击事件
rank.click(function () {
    loop.attr("src", "/static/img/icon/loop.png")
    shuffle.attr("src", "/static/img/icon/shuffle.png")
    toggleImg(rank, ["/static/img/icon/rank.png", "/static/img/icon/rank1.png", "/static/img/icon/rank2.png", "/static/img/icon/rank3.png"], 100);
    audio.removeEventListener('ended', loop1, false);
    audio.removeEventListener('ended', shuffle1, false);
    audio.addEventListener('ended', rank1, false);
})

function rank1() {
    getMusicHistory();
    $("#next").trigger("click")
}

/**
 *
 * 字符过长时截取
 * @param str 要截取的字符
 * @param len   最大长度
 * @returns {string|*} 返回截取后的字符
 */
function interceptionTooLong(str, len) {
    if (str.length > len) {
        return str.substring(0, len) + "...";
    }
    return str;
}
//点击该变播放状态
$("#playToggle").click(function () {
    if (audio != null) {
        if (audio.paused) {
            $(this).attr("src", "/static/img/icon/pause.png")
            audio.play()
            startProgress(seekBarProgress, 1, $seekBarBullet, distance, seekBarBulletLeft, audio);

        } else {
            $(this).attr("src", "/static/img/icon/play.png")
            audio.pause()
            clearInterval(seekBarProgress.timer)
            seekBarProgress.timer = -1;
        }
    }
})

/**
 * 切换底部音乐栏的显示状态,若正在动画中则点击无效
 * @param footer 音乐栏对象
 * @param bottom    底边距
 */
function startToggleMusicBar(footer, bottom) {
    if (typeof footer.flag !== "undefined" && footer.flag === false) {
        return;
    }
    footer.flag = false;
    let target = footer.height();
    let tr = true;
    let step = 0;
    if (bottom < 0) {
        target = 0;
        tr = false;
    }
    footer.timer = setInterval(function () {
        step = Math.ceil((target + bottom) / 20);
        if (-2 < step && step <= 0) {
            step = -2
        }
        step = -step;
        bottom = bottom + step;
        footer.css("bottom", bottom + "px")
        if (tr) {
            if (-bottom > target) {
                clearInterval(footer.timer)
                footer.flag = true;
            }
        } else {
            if (bottom >= target) {
                clearInterval(footer.timer)
                footer.flag = true;
            }
        }
    }, 10)
}

let toggleMusicBar = $("#toggleMusicBar");
let footer = $("#footer");
//底部音乐栏点击事件
toggleMusicBar.click(function () {
    startToggleMusicBar(footer, parseInt(footer.css("bottom")), 3);
})
//点击playList切换播放列表显示
toggleOpacity(playList, $("#history"), 0.03, 1, 0);
window.onpageshow = function (e) {
    setTimeout("toggleSound()", 1);
}

/**
 * 本地有歌曲信息时,则自动播放
 */
function toggleSound() {
    if (localStorage.getItem("playLink") !== "" && "playLink" != null) {
        let songInfo = JSON.parse(localStorage.getItem("songInfo"));
        let current_time = parseFloat(localStorage.getItem("current_time"));
        displayAlbumArt(songInfo["albumId"])
        playForPlayLink(localStorage.getItem("playLink"), songInfo, current_time)
        displayMusic(songInfo, current_time)
    }

}
/**
 * 根据albumId显示封面
 * @param albumId 专辑的id
 */
function displayAlbumArt(albumId) {
    try {
        $("#album_art").attr("src", album_art + albumId + "_0.jpg")
    }catch (e) {
        $("#album_art").attr("src","/static/img/icon/timg.jpg")

    }

}

/**
 * 根据图片数组实现图片的渐变动画
 * @param ele 图片控件元素
 * @param imgs 图片数组
 * @param interval 切换间隔时长
 */
function toggleImg(ele, imgs, interval) {
    if (ele.bl) {
        imgs.reverse();
    }
    ele.i = 0
    clearInterval(ele.timer)
    ele.timer = setInterval(function () {
        ele.attr("src", imgs[ele.i]);
        ele.i++
        if (ele.i === imgs.length) {
            clearInterval(ele.timer);
            ele.bl = !ele.bl;
        }
    }, interval)
}