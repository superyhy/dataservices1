$("#pwdBtn").click(function () {
        var oldPassword = $("#oldPassword").val();
        var newPassword = $("#newPassword").val();
        var inputPassword = $("#inputPassword").val();
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        if (oldPassword == "" || newPassword == "" || inputPassword == "") {

            layer.msg("信息不完整，请填写信息!",{icon: 0});
        }else {
            if (oldPassword != password) {
                layer.msg("原密码错误!",{icon: 0});
            }else{
                if(newPassword!=inputPassword){
                    layer.msg("两次密码输入不一致！",{icon: 0});
                }else{
                    $.ajax({

                        url: "/changePassword",//请求地址

                        data: {id: id, passWord: newPassword},//提交的数据

                        type: "GET",//提交的方式

                        dataType: "JSON", //返回类型 TEXT字符串 JSON XML

                        success: function (data) {
                            if(data){
                                layer.msg("操作成功",{icon: 1}, function (index) {
                                    CloseWin();
                                })
                            }else {
                                layer.msg("修改失败", {icon: 0}, function () {
                                    location.reload(); // 页面刷新
                                    return false
                                })
                            }
                        }
                    })
                }
            }
        }
    });
})

//关闭页面
function CloseWin(){
    parent.location.reload(); // 父页面刷新
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}