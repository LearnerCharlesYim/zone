function checkUsername() {
    const signup = $(".signup-group");
    const username = signup.find("input[name='username']");
    const username_msg = $("#username-msg");
    username_msg.css("color", "red");

    let reg_username = /^\w+$/;
    let status = reg_username.test(username.val().trim());
    if (!status) {
        username.css("border", "1px solid red");
        username_msg.removeClass("glyphicon glyphicon-ok");
        username_msg.text("用户名为字母数字下划线");
    }else {
        $.post("/frontUser/checkUsername", "username=" + username.val().trim(), function (res) {
            if (res.state === 200) {
                //用户名可用
                username.css("border", "");
                username_msg.text("")
                username_msg.addClass("glyphicon glyphicon-ok")
            } else {
                username.css("border", "1px solid red");
                username_msg.removeClass("glyphicon glyphicon-ok");
                username_msg.text(res.message);
                status = false;
            }
        })
    }
    return status;
}

function checkPassword() {
    const signup = $(".signup-group");
    const password = signup.find("input[name='password']");
    const password_msg = $("#password-msg");
    password_msg.css("color", "red");

    let reg_password = /^\w{6,}$/;
    let status = reg_password.test(password.val().trim());
    if (status) {
        password_msg.text("");
        password_msg.addClass("glyphicon glyphicon-ok")
        password.css("border", "");
    } else {
        password_msg.removeClass("glyphicon glyphicon-ok")
        password.css("border", "1px solid red");
        password_msg.text("密码至少6位");
    }
    return status;
}

function checkConfirmedPassword() {
    const signup = $(".signup-group");
    const password1 = signup.find("input[name='password1']");
    const password1_msg = $("#password1-msg");
    password1_msg.css("color", "red");
    let password = signup.find("input[name='password']").val().trim();
    if (password1.val().trim() === "" || password1.val().trim() !== password ) {
        password1_msg.removeClass("glyphicon glyphicon-ok")
        password1.css("border", "1px solid red");
        password1_msg.text("两次密码不一致");
        password1.val("");
        return false;
    } else {
        password1_msg.text("");
        password1_msg.addClass("glyphicon glyphicon-ok")
        password1.css("border", "");
        return true;
    }

}

$(function () {
    const signup = $(".signup-group");
    const signin = $(".signin-group");
    signup.find("input[name='username']").blur(checkUsername);
    signup.find("input[name='password']").blur(checkPassword);
    signup.find("input[name='password1']").blur(checkConfirmedPassword);
    signup.find(".submit-btn").click(function () {
        let username = signup.find("input[name='username']").val();
        let password = signup.find("input[name='password']").val();
        if (checkUsername() && checkPassword() && checkConfirmedPassword()) {
            $.post("/frontUser/register", {username: username, password: password}, function (res) {
                if (res.state === 200) {
                    //注册成功
                    sweetAlert.alertSuccess("注册成功", () => {
                        closeWrapper();
                        $(".mask-wrapper").hide();
                    });
                } else {
                    //注册失败
                    sweetAlert.alertError(res.message);
                }
            })
        }
    })
    
    signin.find(".submit-btn").click(function () {
        let username = signin.find("input[name='username']").val();
        let password = signin.find("input[name='password']").val();
        const login_msg = $("#login-msg");
        $.post("/frontUser/login",{username:username,password:password},function (res) {
            if(res.state === 200){
                login_msg.text("");
                location.reload();
            }else{
                signin.find("input[name='password']").val("");
                login_msg.text(res.message);
            }
        })

    })


    var authBox = $(".auth-box");
    var userMoreBox = $(".user-more-box");
    authBox.hover(function () {
        userMoreBox.show();
    },function () {
        userMoreBox.hide();
    });

});