<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/26
  Time: 18:59
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
    <title>社区机构管理中心-居民信息</title>
    <style>
        td{
            border: 1px white solid;
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
                    <a href="/jsp/community.jsp">主页</a>
                </li>
                <%--                    <li><a href="#">仓库管理</a>--%>
                <%--                        <ul class="one">--%>
                <%--                            <li><a href="/jsp/warehouse_into.jsp">入库登记</a></li>--%>
                <%--                            <li><a href="/jsp/warehouse_issue.jsp">出库登记</a></li>--%>
                <%--                            <li><a href="/jsp/warehouse_destruction.jsp">销毁登记</a></li>--%>
                <%--                            <li><a href="/jsp/warehouse_information.jsp">物资信息</a></li>--%>
                <%--                        </ul>--%>
                <%--                    </li>--%>
                <%--                    <li><a href="#">分配管理</a>--%>
                <%--                        <ul class="one">--%>
                <%--                            <li><a href="/jsp/distribution_examine.jsp">订单审核</a></li>--%>
                <%--                            <li><a href="#">订单追溯</a></li>--%>
                <%--                        </ul>--%>
                <%--                    </li>--%>
                <li><a href="#">分发管理</a>
                    <ul class="one">
                        <li><a href="/OrderServlet">订单签收</a></li>
                        <li><a href="/TraceCommunityServlet">订单追溯</a></li>
                        <li><a href="/GrantServlet">物资分发</a></li>
                    </ul>
                </li>
                <li><a href="#">社区管理</a>
                    <ul class="one">
                        <li><a href="/CommunityPersonalServlet">居民信息</a></li>
                        <li><a href="/ApplyServlet">物资申请</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="personal">
            <p>${sessionScope.login.account}</p>
            <a href="/jsp/organization_Login.jsp">退出登录</a>
        </div>
    </div>

    <!--主体-->
    <div class="main">
        <h1>居民信息</h1>
        <div>
            总人数：<span>${requestScope.number}</span>
        </div>
        <table>
            <tr>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>身份证号</td>
                <td>详细地址</td>
                <td>电话</td>
            </tr>
            <c:forEach items="${requestScope.listPersonal}" var="item" varStatus="status">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.sex}</td>
                    <td>${item.age}</td>
                    <td>${item.card_id}</td>
                    <td>${item.address}</td>
                    <td>${item.telephone}</td>
                </tr>
            </c:forEach>
        </table>
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

