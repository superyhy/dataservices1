//var roleName="${role}";
//根据登录的角色，判断是否显示管理中心入口
var ul=document.getElementById("index_appbar")
var li=document.createElement("li");

if("admin"==role) {
       li.innerHTML = '<li class="layui-nav-item">'+ '<a href="/gotoDataManagerPage">数据管理中心</a>'+'</li>';
        li.setAttribute("class","layui-nav-item");
        // var a = document.createElement("a");
        //a.setAttribute("href","/gotoDataManagerPage")
        //a.setAttribute("text","数据管理中心")
        //li.append(a);
        ul.append(li);
}