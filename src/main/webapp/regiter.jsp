<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/12
  Time: 11:56
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
邮箱：<input type="text" name="email" id="email"/><br/>
用户名：<input type="text" name="username" id="username"/><br/>
密码：<input type="text" name="password" id="password"/><br/>
电话：<input type="text" name="tel" id="tel"/><br/>
<input type="submit" value="注册" id="submit"/>
<script>
    $("#user").click(clicks1);
    function clicks1() {
        $("#email").blur(blurs);
        function blurs() {
            var email=$("#email").val();
            $.ajax({
                url:"/user/userlogin",
                type:"post",
                data:{"email":email},
                success:function (data) {
                    if(data==1){
                        alert("邮箱存在,请重新输入")
                    }
                }
            })
        }
        $("#username").blur(blurs1);
        function blurs1() {
            var username=$("#username").val();
            $.ajax({
                url:"/user/userlogin",
                type:"post",
                data:{"username":username},
                success:function (data) {
                    if (data==1){
                        alert("用户名存在，请重新输入")
                    }
                }
            })
        }
        $("#submit").click(submit1);
        function submit1() {
            var email=$("#email").val();
            var username=$("#username").val();
            var password=$("#password").val();
            var tel=$("#tel").val();
            $.ajax({
                url:"/user/userregister",
                type:"post",
                data:{"email":email,"username":username,"password":password,"tel":tel},
                success:function (data) {
                    if (data==1) {
                        alert("注册成功")
                    }
                }
            })
        }
    }

    $("#horseman").click(clicks2);
    function clicks2() {
        $("#email").blur(blurs);
        function blurs() {
            var email=$("#email").val();
            $.ajax({
                url:"/horse/horsemanlogin",
                type:"post",
                data:{"email":email},
                success:function (data) {
                    if(data==1){
                        alert("邮箱存在,请重新输入")
                    }
                }
            })
        }
        $("#username").blur(blurs1);
        function blurs1() {
            var username=$("#username").val();
            $.ajax({
                url:"/horse/horsemanlogin",
                type:"post",
                data:{"username":username},
                success:function (data) {
                    if (data==1){
                        alert("用户名存在，请重新输入")
                    }
                }
            })
        }
        $("#submit").click(submit1);
        function submit1() {
            var email=$("#email").val();
            var username=$("#username").val();
            var password=$("#password").val();
            var tel=$("#tel").val();
            $.ajax({
                url:"/horse/horseregister",
                type:"post",
                data:{"email":email,"username":username,"password":password,"tel":tel},
                success:function (data) {
                    if (data==1) {
                        alert("注册成功")
                    }
                }
            })
        }
    }

</script>
<a href="/horse/horsemanlogin"></a>
</body>
</html>
