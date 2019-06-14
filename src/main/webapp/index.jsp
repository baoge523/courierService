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
<a>${sessionScope.username}欢迎</a>
<script src="js/jquery-3.3.1.js"></script>
<link rel="icon" href="data:;base64,=">
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

</script>
</body>
</html>
