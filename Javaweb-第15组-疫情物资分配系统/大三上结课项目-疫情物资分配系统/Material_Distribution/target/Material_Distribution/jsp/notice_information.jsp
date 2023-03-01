<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>政府机构管理中心-公告公示详细信息</title>
</head>
<style>
    .zhuti{
        width: 100%;
        text-align: center;
    }
</style>
<body>
    <a href="/IndexServlet">返回</a>
    <div class="zhuti">
        <h2>${param.name}</h2>
        <p>${param.content}</p>
        <a href="/jsp/personal.jsp">点击此链接前往登记！</a>
    </div>
</body>
</html>
