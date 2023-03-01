<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--引入jstl核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../css/nav.css" rel="stylesheet" type="text/css" />
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery-1.12.4.js"></script>
    <title>主页</title>
    <style>
        .notice{
            width: 500px;
            height: 300px;
            border: 2px solid black;
            position: absolute;
            right: 30%;
            top: 200px;
            text-align: center;
        }
        .notice td{
            width: 100px;
        }
    </style>
</head>
<body>
<div class="warehouse_issue">
    <div class="nav navbar-default navbar-fixed-top">
        <div class="log">LOG</div>
        <div class="container">
            <ul class="menu">
                <li>
                    <a href="/jsp/government.jsp">主页</a>
                </li>
                <li><a href="#">物资信息</a></li>
                <li><a href="/jsp/organization_Login.jsp">政府中心</a></li>
                <li><a href="#">群众中心</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>
        </div>
        <div class="personal">
            
        </div>
    </div>

    <!--主体-->
    <div class="main">
        <h1>主页</h1>
        <div class="notice">
            <h3>公告公示</h3>
            <table>
                <c:forEach items="${requestScope.listNotice}" var="item" varStatus="status">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.type}</td>
                    <td style="display: none">${item.content}</td>
                    <td>${item.time}</td>
                    <td><a href="/jsp/notice_information.jsp?name=${item.name}&content=${item.content}">查看详情</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('.menu li').hover(function(){
            $(this).children('ul').show();
        },function(){
            $(this).children('ul').hide();
        });
    });
</script>
</body>
</html>

