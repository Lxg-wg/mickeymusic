//提示框功能的实现
$tip =  $("#tip_frag")
$("#tip_frag input").click(function () {
    $tip.css("display","none")
})
function tipFrag(title,message){
    $("#tip_title").html(title);
    $("#tip_message").html(message);
}
function choseTipFrag() {
    $tip.timer = setTimeout(function () {
        opacity( $tip,-0.1,0);
    },2000)
}
$tip.mouseenter(function () {
    clearInterval($tip.timer)
})

