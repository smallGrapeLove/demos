<%--

  Created by IntelliJ IDEA.
  User: huan.xu
  Date: 2019/2/14
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>file_list</title>
</head>
<body>
<a href="download?fileName=<s:property value='uploadFileFileName'/>"><s:property value="uploadFileFileName"/></a>
</body>
</html>
