//var roleName="${role}";
//根据登录的角色，判断是否显示管理中心入口
var ul=document.getElementById("index_appbar")
var li=document.createElement("li");

if("admin"==role) {
       li.innerHTML = '<li class="layui-nav-item">'+ '<a href="/gotoDataManagerPage">数据管理中心</a>'+'</li>';
        //这一步，引入样式（重要），否则页面不会呈现效果
        li.setAttribute("class","layui-nav-item");
        // var a = document.createElement("a");
        //a.setAttribute("href","/gotoDataManagerPage")
        //a.setAttribute("text","数据管理中心")
        //li.append(a);
        ul.append(li);
}

//点击密码修改，前往密码修改页面
function changePassword() {
    // var tr_s = $(obj).parent().parent();//获取到tr元素
    // var data_id = tr_s.find("td:eq(0)").children(":radio").val();//定位到第一个radio的元素获取隐藏的主键
    course_tab_show('密码修改','./gotoPassWord');//打开修改的基本信息层
}

//点击基本资料，前往个人主页
function personalPage() {
    course_tab_show('个人资料','./gotoPersonalPage');
}

function course_tab_show(title,url){
    layui.use("layer",function() {

        layer.open({
            type: 2,
            area: ['500px', '400px'],  //弹出层页面比例
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url
        });
    });
}


