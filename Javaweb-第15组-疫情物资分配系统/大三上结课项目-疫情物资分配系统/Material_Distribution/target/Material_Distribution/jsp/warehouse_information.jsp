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
    <title>政府机构管理中心-物资信息</title>
    <style>
        input:nth-child(2){
            width: 300px;
        }
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
                            <li><a href="/IssueServlet">出库登记</a></li>
                            <li><a href="/jsp/warehouse_destruction.jsp">销毁登记</a></li>
                            <li><a href="#">物资信息</a></li>
                        </ul>
                    </li>
                    <li><a href="#">分配管理</a>
                        <ul class="one">
                            <li><a href="/ExamineServlet">订单审核</a></li>
                            <li><a href="/TraceServlet">订单追溯</a></li>
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
            <h1>物资信息</h1>
            <div>
                <form action="/InformationServlet" method="post">
                    <input type="checkbox" name="stock" value="true"><span>仅查看库存大于0的数据&nbsp;&nbsp;</span>
                    <input type="text" name="name" placeholder="输入想查询的物资名称或编码"/>
                    <input type="submit" value="查询" />
                </form>
            </div>
            <table>
                <tr>
                    <td>名称</td>
                    <td>编码</td>
                    <td>类型</td>
                    <td>入库时间</td>
                    <td>有效期</td>
                    <td>失效日期</td>
                    <td>库存</td>
                    <td>单位</td>
                    <td>操作</td>
                </tr>
                <%--通过jstl循环输出--%>
                <c:forEach items="${requestScope.modelList}" var="item" varStatus="status">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.code}</td>
                        <td>${item.type}</td>
                        <td>${item.warehous}</td>
                        <td>${item.valid}</td>
                        <td>${item.invalid}</td>
                        <td>${item.stock}</td>
                        <td>${item.company}</td>
                        <td><a href="/jsp/information_update.jsp?id=${item.id}">修改</a></td>
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
