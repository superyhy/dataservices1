//角色下拉框
layui.use(['form', 'upload', 'layer'], function () {
    var form = layui.form;

    //检查项目添加到下拉框中
    $.ajax({
        url: '/queryRoleSpinner',
        dataType: 'json',
        type: 'get',
        success: function (data) {
            $.each(data, function (index, item) {
                $('#roleNameList').append(new Option(item.roleName, item.id));// 下拉菜单里添加元素
            });
            layui.form.render("select");
            //重新渲染 固定写法
        }
    })

})

//从url中获取?后面传的ID
function getQueryString(name) {
    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
}

var id = getQueryString("role_id");

//编辑时，数据回显
// $.ajax({
//
//     url:"/getRoleById/"+id,
//     type: "GET",//提交的方式
//     dataType: "JSON", //返回类型 TEXT字符串 JSON XML
//     success: function (data){
//
//         layui.use('form',function () {
//             var form=layui.form;
//             form.val(
//                 "show-data",{                   //"show-data"对应的是 form标签开头的 lay-filter="show-data"
//                     "roleName":data.roleName,
//                     "role":data.role,
//                     "roleDescribe":data.roleDescribe,
//                 });
//         })
//
//     }
// })

//将从url中传入的ID，赋值到前端hidden标签中
$("[name='id']").val(id);

//完成数据修改操作
layui.use(['layer','form'], function() {
    var layer = layui.layer;
    var form = layui.form;
    //提交监听事件
    form.on('submit(edit-form)', function (data) {
        params = data.field;
        // data.field=JSON.stringify(data.field);
        submit($, params);
        return false;
    })

    // var obj = document.getElementById('closeBtn');
    // obj.addEventListener('click', function cancel() {
    //     CloseWin();
    // });
})

//提交
function submit($,params){
    $.ajax({

        url: "/updateUserAccess",//请求地址

        data: JSON.stringify(params),//提交的数据转JSON

        type: "post",//提交的方式

        dataType: "JSON", //返回类型 TEXT字符串 JSON XML

        contentType: "application/json;charset=UTF-8", //定义数据格式为JSON

        success: function (data) {
            if (data) {
                layer.msg("操作成功",{icon: 1}, function (index) {
                    CloseWin();
                })
            }
            else{
                layer.msg("修改失败", {icon: 0}, function () {
                    location.reload(); // 页面刷新
                    return false
                })
            }
        }
    })
}

//关闭页面
function CloseWin(){
    parent.location.reload(); // 父页面刷新
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}


