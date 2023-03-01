<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社区机构管理-物资发放登记</title>
</head>
<body>
    <h1>居民发放登记</h1>
    <form action="/GrantAddServlet" method="post">
        姓名：<input type="text" name="owner" /><br/>
        地址：<input type="text" name="address" /><br/>
        联系电话：<input type="text" name="telephone" /><br/>
        身份证号：<input type="text" name="card_id" /><br/>
        物资名称：<input type="text" name="name" /><br/>
        物资编码：<input type="text" name="code" /><br/>
        物资类型：
        <select name="type">
            <option value="防护类">防护类</option>
            <option value="生活类">生活类</option>
            <option value="日用类">日用类</option>
        </select><br/>
        物资数量：<input type="text" name="number" /><br/>
        物资单位：
        <select name="company">
            <option value="件">件</option>
            <option value="箱">箱</option>
            <option value="盒">盒</option>
        </select><br/>
        发放时间：
        <input type="date" name="time"><br/>
        <input type="submit" value="提交" />
    </form>
</body>
</html>
