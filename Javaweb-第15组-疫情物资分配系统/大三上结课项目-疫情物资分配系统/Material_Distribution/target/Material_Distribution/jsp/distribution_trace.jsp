<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/15
  Time: 16:37
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
    <title>政府机构管理中心-订单追溯</title>
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
                        <a href="/jsp/government.jsp">主页</a>
                    </li>
                    <li><a href="#">仓库管理</a>
                        <ul class="one">
                            <li><a href="/jsp/warehouse_into.jsp">入库登记</a></li>
                            <li><a href="/jsp/warehouse_issue.jsp">出库登记</a></li>
                            <li><a href="/jsp/warehouse_destruction.jsp">销毁登记</a></li>
                            <li><a href="/jsp/warehouse_information.jsp">物资信息</a></li>
                        </ul>
                    </li>
                    <li><a href="#">分配管理</a>
                        <ul class="one">
                            <li><a href="/jsp/distribution_examine.jsp">订单审核</a></li>
                            <li><a href="#">订单追溯</a></li>
                        </ul>
                    </li>
                    <li><a href="#">公告管理</a>
                        <ul class="one">
                            <li><a href="/jsp/notice_add.jsp">添加公告</a></li>
                            <li><a href="#">公告信息</a></li>
                        </ul>
                    </li>
<%--                    <li><a href="#">分发管理</a>--%>
<%--                        <ul class="one">--%>
<%--                            <li><a href="/jsp/distribute_apply.jsp">物资申请</a></li>--%>
<%--                            <li><a href="/jsp/distribute_grant.jsp">物资分发</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
                </ul>
            </div>
            <div class="personal">
                <p>${sessionScope.login.account}</p>
                <a href="/jsp/organization_Login.jsp">退出登录</a>
            </div>
        </div>

        <!--主体-->
        <div class="main">
            <h1>订单追溯</h1>
            <div>
                <form action="/TraceServlet" method="post">
                    <select name="state">
                        <option value="全部">全部</option>
                        <option value="待审批">待审批</option>
                        <option value="已审批">已审批</option>
                        <option value="已出库">已出库</option>
                        <option value="已签收">已签收</option>
                    </select>
                    <input type="text" name="order" placeholder="输入查询的订单号"/>
                    <input type="submit" value="查询"/>
                </form>
            </div>
            <table>
                <tr>
                    <td>订单号</td>
                    <td>地区编码</td>
                    <td>名称</td>
                    <td>编码</td>
                    <td>类型</td>
                    <td>数量</td>
                    <td>单位</td>
                    <td>区域人数</td>
                    <td>申请日期</td>
                    <td>紧急程度</td>
                    <td>状态</td>
                </tr>
                <c:forEach var="item" items="${requestScope.applyList}" varStatus="status">
                    <tr>
                        <td>${item.order}</td>
                        <td>${item.region_id}</td>
                        <td>${item.name}</td>
                        <td>${item.code}</td>
                        <td>${item.type}</td>
                        <td>${item.number}</td>
                        <td>${item.company}</td>
                        <td>${item.people}</td>
                        <td>${item.apply_date}</td>
                        <td>${item.urgency}</td>
                        <td>${item.state}</td>
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
