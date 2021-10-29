function closeWrapper() {
    const signin_form = $('.signin-group');
    const signup_form = $('.signup-group');
    const login_msg = $("#login-msg");
    signin_form.find('input[name="username"]').val('');
    signin_form.find('input[name="password"]').val('');
    signin_form.find(".msg").text("");
    signin_form.find(".msg").removeClass("glyphicon glyphicon-ok");


    signup_form.find('input[name="username"]').val('');
    signup_form.find('input[name="password"]').val('');
    signup_form.find('input[name="password1"]').val('');
    signup_form.find(".msg").text("");
    signup_form.find(".msg").removeClass("glyphicon glyphicon-ok");

    login_msg.text("");


}


// 点击登录按钮，弹出模态对话框
$(function () {
    $(".login-btn").click(function () {
        $('.scroll-wrapper').css({'left':0});
        $(".mask-wrapper").fadeIn("normal");
    });

    $(".close-btn").click(function () {
        closeWrapper();
        $(".mask-wrapper").fadeOut("normal");

    });
});

$(function () {
    $(".signin-btn").click(function () {
        $('.scroll-wrapper').css({'left':-400});
        $(".mask-wrapper").show();
    });
    $(".close-btn").click(function () {
        closeWrapper();
        $(".mask-wrapper").fadeOut("normal");

    });
});

$(function () {
    $(".switch").click(function () {
        var scrollWrapper = $(".scroll-wrapper");
        var currentLeft = scrollWrapper.css("left");
        currentLeft = parseInt(currentLeft);
        if(currentLeft < 0){
            scrollWrapper.animate({"left":'0'});
        }else{
            scrollWrapper.animate({"left":"-400px"});
        }
    });
});