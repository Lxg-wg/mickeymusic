let reg_id = /^\d{6,20}$/
let reg_password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
let reg_nickname = /^[\u4e00-\u9fa5_a-zA-Z0-9]{2,10}$/
$("#toLogin").click(function () {
    $("#reg").css("display", "none");
    $("#login").css("display", "block");
})
$("#toReg").click(function () {
    $("#reg").css("display", "block");
    $("#login").css("display", "none");
})
let log_reg = $("#login_reg");
toggleOpacity($("#user"), log_reg, 0.03, 1, 0);
//登录
$("#send_login").click(function () {
    let id = $("#userId").val();
    let password = $("#password").val();
    $tip.css("display", "inline-block")
    $tip.css("opacity", "1")
    if (reg_id.test(id) && reg_password.test(password)) {
        let data = {
            "userId": id,
            "password": password,
            "autoLogin": $("#autoLogin").get(0).checked
        }
        let res = sendFormForAjax("/user/login", $("login"), data)
        if (res ==="false") {
            tipFrag("登录", "账号或密码错误")
        } else {
            tipFrag("登录", "登录成功")
            $("#login_reg").css({display:"none",opacity:0})
            isLogin();
        }
    } else {
        tipFrag("登录", "账号或密码格式错误")
    }
    choseTipFrag();
});
//注册
$("#send_reg").click(function () {
    let nickname = $("#nickname").val();
    let password = $("#reg_password").val();
    $tip.css("display", "inline-block")
    $tip.css("opacity", "1")
    if (reg_nickname.test(nickname) && reg_password.test(password)) {
        let data = {"nickname": nickname, "password": password}
        let res = sendFormForAjax("/user/reg", $("reg"), data)
        if (res === "false") {
            tipFrag("注册", "注册失败!")
        } else {
            tipFrag("注册", "注册成功,请记住你的账号:"+res)
            $("#toLogin").trigger("click");
            $("#userId").val(res);
            $("#password").val(password);
        }
    } else {
        tipFrag("格式错误", "昵称长度2~10之间,密码必须包含数字和字母,长度在6~20之间")
    }
    choseTipFrag()
});
isLogin()

/**
 * 用于判断是否登录
 * @returns {*} 返回boolean值,判断是否登录
 */
function isLogin() {
    let isLogin;
    $.ajax({
        url: "/user/isLogin",
        type: "get",
        async: false,
        data_type: "json",
        contentType: "application/json",
        success: function (res) {
            isLogin = res;
            let userStatus =$("#userStatus img");
            if (isLogin){
                userStatus.attr({alt:"已登录",title:"已登录"})
                userStatus.attr("src", "../../../static/img/icon/correct.png")
            }else{
                userStatus.attr({alt:"未登录",title:"未登录"})
                userStatus.attr("src", "../../../static/img/icon/error.png")
            }
        },
        error: function () {
            console.log("error")
        }
    });
    return isLogin
}
