<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/bootstrap.js"></script>
<script src="../js/jquery-1.12.4.js"></script>
<html>
<head>
    <title>物资申请-新增</title>
</head>
<body>
<h1>物资申请</h1>
    <form action="/ApplyAddServlet" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">名称</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder=" " name="name">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">编码</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder=" " name="code">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">类型</label>
            <select class="form-control" name="type">
                <option>防护类</option>
                <option>医用类</option>
                <option>日用类</option>
                <option>生活类</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">数量</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder=" " name="number">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">单位</label>
            <select class="form-control" name="company">
                <option>件</option>
                <option>盒</option>
                <option>箱</option>
                <option>只</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">区域人数</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder=" " name="people">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">紧急程度</label>
            <select class="form-control" name="urgency">
                <option>默认</option>
                <option>中</option>
                <option>高</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">日期</label>
            <input type="date" class="form-control" id="exampleInputEmail1" placeholder=" " name="apply_date">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</body>
</html>
