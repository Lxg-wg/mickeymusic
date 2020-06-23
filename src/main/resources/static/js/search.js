window.audio = $("#audio")[0];
//点击播放时间
$("#songList li").click(function () {
    const songList = window.songList;
    const songInfo = songList[$(this).index()];
    $("#songList li a" ).removeClass("opt")
    $("#songList li:eq("+$(this).index()+") a" ).addClass("opt")
    playForSongInfo(songInfo)
});


