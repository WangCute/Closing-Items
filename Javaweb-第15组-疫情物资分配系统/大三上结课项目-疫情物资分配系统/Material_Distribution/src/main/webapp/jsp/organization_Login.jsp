<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/18
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>政府机构管理中心-登录</title>
</head>
<body>
    <h1>登录</h1>
    <div>
        <form action="/LoginServlet" method="post">
            <span>工号：</span>
            <input type="text" name="account" /><br/>
            <span>密码：</span>
            <input type="password" name="password" /><br/>
            <input type="submit" value="登录" />
        </form>
    </div>
    <h5 style="color:red;">${requestScope.account}</h5>
</body>
</html>
