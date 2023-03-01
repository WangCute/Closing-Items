<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>政府机构管理中心-居民信息填写</title>
</head>
<body>
    <a href="/IndexServlet">返回</a>
    <br/>
    <form action="/PersonalServlet" method="post">
        姓名：<input type="text" name="name" /><br/>
        性别：
        <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女<br/>
        年龄：<input type="number" min="0" max="150" name="age" /><br/>
        身份证号：<input type="text" name="card_id" /><br/>
        省：
        <select name="province">
            <option value="四川省">四川省</option>
            <option value="云南省">云南省</option>
            <option value="贵州省">贵州省</option>
        </select>
        市：
        <select name="city">
            <option></option>
            <option value="成都市">成都市</option>
            <option value="绵阳市">绵阳市</option>
            <option value="南充市">南充市</option>
            <option value="泸州市">泸州市</option>
            <option value="宜宾市">宜宾市</option>
            <option value="达州市">达州市</option>
            <option value="巴中市">巴中市</option>
            <option value="雅安市">雅安市</option>
            <option value="广安市">广安市</option>
        </select>
        县：
        <select name="county">
            <option></option>
            <option value="巴州区">巴州区</option>
            <option value="恩阳区">恩阳区</option>
            <option value="平昌县">平昌县</option>
            <option value="通江县">通江县</option>
            <option value="南江县">南江县</option>
        </select><br/>
        详细地址：<input type="text" name="address" /><br/>
        联系电话：<input type="text" name="telephone" /><br/>
        <input type="submit" value="提交" onclick="tijiao()" />
    </form>


<script type="text/javascript">
    function tijiao(){
        alert("登记成功！")
    }
</script>
</body>
</html>
