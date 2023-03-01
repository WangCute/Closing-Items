<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/17
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>订单审核-修改</title>
</head>
<body>
    <h1>物资修改</h1>
    <div>
        <form action="/ExamineUpdateServlet?id=${param.id}" method="post">
            <span>名称：</span>
            <input type="text" name="name"/><br/>
            <span>编码：</span>
            <input type="text" name="code"/><br/>
            <span>类型：</span>
            <select name="type">
                <option value="防护类">防护类</option>
                <option value="医用类">医用类</option>
                <option value="日用类">日用类</option>
                <option value="生活类">生活类</option>
            </select><br/>
            <span>数量：</span>
            <input type="number" min="0" name="number"/><br/>
            <span>单位：</span>
            <select name="company">
                <option value="件">件</option>
                <option value="盒">盒</option>
                <option value="箱">箱</option>
                <option value="只">只</option>
            </select><br/>
            <input type="submit" value="提交" />
        </form>
    </div>
</body>
</html>
