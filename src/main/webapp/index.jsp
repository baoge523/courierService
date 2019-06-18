<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form id="uploadForm" enctype="multipart/form-data">
    <input type="file" name="file" id="file" />
    <input type="button" value="点击上传" id="submit1" />
</form>
<img id="img" src="" style="width: 200px;height: 200px"/>
<a id="welcome">欢迎</a>
<script src="js/jquery-3.3.1.js"></script>
<link rel="icon" href="data:;base64,=">
<a href="publish.html">发布</a>
<a href="user.html" id="check">账单</a>
<script>
$("#submit1").click(click1);
function click1() {
    var formData = new FormData($("#uploadForm")[0])//创建一个formdata
    formData.append('file', $('#file')[0].files[0])//把file添加进去，name命名为file
    $.ajax({
        url: "/horse/upload",
        data: formData,
        type: "post",
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.datas.code == 1) {
                alert("上传成功")
            }
            console.log(data.datas.pathimg);
            $("#img").attr("src", data.datas.pathimg)

        }
    })
}

$(function(){
    initData();
});

//加载初始化数据
function initData(){
    $.ajax({
        type:"post",
        dataType: "json",
        url:"/order/findAll",
        success:function(data){
            if(data!=null){
                for(var i=0;i<data.datas.order.length;i++){
                    var htmls;
                    var htmlss;
                    htmls="<tr>+<td>"+"姓名: "+data.datas.order[i].username+"</td>+<td>"+"快递公司 :"+data.datas.order[i].companyName+"</td>+<td>"+"取单号:"+data.datas.order[i].number+"</td>+<td>"+"送达地址 :"+data.datas.order[i].targetAddr+"</td>+<td>"+"金额 :"+data.datas.order[i].money+"</td>+<td>"+"时间 :"+data.datas.order[i].publishTime+"</td></tr>";
                    htmlss="<input type='button' value='接单' id='receiver' onclick='button("+data.datas.order[i].id+")'/>";
                    $("#order").append(htmls,htmlss);
                }
            }
        },
    });
}
function button(orderId) {
    $.ajax({
        url:"/detail/receiver",
        type:"post",
        data:{"orderId":orderId},
        success:function (code) {
            if(code.statusCode==200){
                alert("接单成功")
            }else if(code.statusCode==100){
                alert("已接单，请勿在此接单")
            }
        }
    })
}

</script>
<table id="order">
    <tr>
        <td>快递信息</td>
    </tr>
</table>
</body>
</html>
