<%--
  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/14
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <form method="post" action="upload" enctype="multipart/form-data">
        File:<input type="file" name="uploadFile"/><br/>
        Readme:<input type="text" name="readme"/><br/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
