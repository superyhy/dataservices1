
var basePath="http://localhost:8082/";
//登录验证
$("#button").click(function(){

    //第一步：取数据,这里用到了用户名和密码

    var username=$("#username").val();

    var password=$("#password").val();

    //第二步：验证数据，这里需要从数据库调数据，我们就用到了ajax
    if(username==""||password==""){
         var layer=layui.layer;
         layer.msg("信息不完整，请填写信息");
    }
    else {
        $.ajax({

            url: "/login",//请求地址

            data: {username: username, password: password},//提交的数据

            type: "GET",//提交的方式

            dataType: "JSON", //返回类型 TEXT字符串 JSON XML

            success: function (data) {


                if (data) {

                    window.location.href = "/gotoIndexPage";

                } else {
                    var layer=layui.layer;
                    layer.msg("用户名或密码错误");
                }

            }

        })
    }

})