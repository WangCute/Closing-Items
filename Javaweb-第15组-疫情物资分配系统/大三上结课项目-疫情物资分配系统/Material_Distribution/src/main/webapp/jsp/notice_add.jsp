<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>政府机构管理中心-公告公示添加</title>
</head>
<body>
    <h1>公告公示添加</h1>
    <form action="/NoticeAddServlet" method="post">
        标题：<input type="text" name="name" /><br/>
        内容：<textarea name="content"></textarea><br/>
        类型：
        <select name="type">
            <option value="通知">通知</option>
            <option value="公示">公示</option>
            <option value="其他">其他</option>
        </select>
        <br/>
        日期：
        <input type="date" name="time"><br/>
        <input type="submit" value="提交" />
    </form>
</body>
</html>
