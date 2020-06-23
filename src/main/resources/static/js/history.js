let playList =$("#playList")
playList.sendAjax = true;
playList.res = null;
playList.opt=-1;

playList.bl = false;
//播放列表点击显示用户的播放列表,若未登录则提示用户登录
playList.click(function () {
    let imgs = ["/static/img/icon/music.png","/static/img/icon/music1.png","/static/img/icon/music2.png","/static/img/icon/music3.png"]
    if (playList.finish||typeof playList.finish == "undefined") {
        toggleImg(playList, imgs, 60);
    }
    if (!playList.sendAjax){
        return;
    }
    playList.sendAjax=!playList.sendAjax;
    $.ajax({
        url:"/user/musichistory",
        type:"get",
        async:false,
        data_type:"json",
        contentType:"application/json",
        success:function (res) {
            if(res==="no login"){
                $("#history ul ").append(" <p id=\"login_tip\" >登录之后才能查看播放记录,点击<a>登录</a></p>")
                $("#login_tip").click(function () {
                    $("#history").css({"opacity":0,"display":"none"})
                    if(parseFloat($("#login_reg").css("opacity"))<1) {
                        $("#user").trigger("click")
                    }
                })
                return;
            }
            $("#history ul #login_tip").remove()
            $("#history ul li ").remove();
            playList.res = res;
            for (let key of res ) {
                $("#history ul ").append("<li ><a>" + key["songName"] + "</a><span>" + key["singerName"] + "</span></li>");
            }
            if(playList.opt===-1){
                $("#history ul li a:eq(0)").addClass("opt");
                playList.opt=0;
            }
            $("#history ul li").click(function () {
                let index = $(this).index();
                $("#history ul li a").removeClass("opt");
                $("#history ul li a:eq("+index+")").addClass("opt");
                displayAlbumArt(res[index]["albumId"])
                playList.opt = index
                playForSongInfo(res[index]);
            })
        },
        error:function () {
            console.log("error")
        }
    })
});
