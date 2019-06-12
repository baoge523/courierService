<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/12
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/jquery-3.3.1.js"></script>
<input type="radio" name="role" value="horseman" id="horseman" /> 骑手
<input type="radio" name="role" value="user" id="user" checked/> 用户
邮 箱:<input type="text" name="email" id="email"/>
密  码:<input type="text" name="password" id="password">
<input type="submit" value="提交" id="submit">
<script>
    $("#user").click(clicks1);
    function clicks1() {
        function blurs() {
            var email=$("#email").val();
            $.ajax({
                url:"/user/userlogin",
                type:"post",
                data:{"email":email},
                success:function (data) {
                    if(data==2){
                        alert("邮箱错误")
                    }
                }
            })
        }
        function clicks() {
            var email=$("#email").val();
            var password=$("#password").val();
            $.ajax({
                url:"/user/userlogin",
                type:"post",
                data:{"email":email,"password":password},
                success:function (data) {
                    if (data==1){
                        alert("登录成功")
                    }else if(data==2){
                        alert("密码错误")
                    }
                }
            })
        }
        $("#email").blur(blurs);
        $("#submit").click(clicks);
    }
    $("#horseman").click(clicks2);
    function clicks2() {
        function blurs() {
            var email=$("#email").val();
            $.ajax({
                url:"/horse/horsemanlogin",
                type:"post",
                data:{"email":email},
                success:function (data) {
                    if(data==2){
                        alert("邮箱错误")
                    }
                }
            })
        }
        function clicks() {
            var email=$("#email").val();
            var password=$("#password").val();
            $.ajax({
                url:"/user/userlogin",
                type:"post",
                data:{"email":email,"password":password},
                success:function (data) {
                    if (data==1){
                        alert("登录成功")
                    }else if(data==2){
                        alert("密码错误")
                    }
                }
            })
        }
        $("#email").blur(blurs);
        $("#submit").click(clicks);
    }
</script>
</body>
</html>
