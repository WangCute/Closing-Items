<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/18
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../css/nav.css" rel="stylesheet" type="text/css" />
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery-1.12.4.js"></script>
    <title>政府机构管理中心</title>
</head>
<style>
    td{
        border: 1px solid black;
    }
</style>
<body>
    <div class="warehouse_issue">
        <div class="nav navbar-default navbar-fixed-top">
            <div class="log">LOG</div>
            <div class="container">
                <ul class="menu">
                    <li>
                        <a href="#">主页</a>
                    </li>
<%--                    <li><a href="#">仓库管理</a>--%>
<%--                        <ul class="one">--%>
<%--                            <li><a href="/jsp/warehouse_into.jsp">入库登记</a></li>--%>
<%--                            <li><a href="/IssueServlet">出库登记</a></li>--%>
<%--                            <li><a href="/jsp/warehouse_destruction.jsp">销毁登记</a></li>--%>
<%--                            <li><a href="/InformationServlet">物资信息</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                    <li><a href="#">分配管理</a>--%>
<%--                        <ul class="one">--%>
<%--                            <li><a href="/ExamineServlet">订单审核</a></li>--%>
<%--                            <li><a href="/TraceServlet">订单追溯</a></li>--%>
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
            <h1>主页</h1>
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
