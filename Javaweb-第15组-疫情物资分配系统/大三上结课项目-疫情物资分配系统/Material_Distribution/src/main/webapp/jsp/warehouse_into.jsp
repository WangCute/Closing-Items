<%--
  Created by IntelliJ IDEA.
  User: 王可爱
  Date: 2022/12/15
  Time: 16:37
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
    <title>政府机构管理中心-入库登记</title>
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
                            <li><a href="#">入库登记</a></li>
                            <li><a href="/jsp/warehouse_issue.jsp">出库登记</a></li>
                            <li><a href="/jsp/warehouse_destruction.jsp">销毁登记</a></li>
                            <li><a href="/InformationServlet">物资信息</a></li>
                        </ul>
                    </li>
                    <li><a href="#">分配管理</a>
                        <ul class="one">
                            <li><a href="/jsp/distribution_examine.jsp">订单审核</a></li>
                            <li><a href="/jsp/distribution_trace.jsp">订单追溯</a></li>
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
            <h1>入库登记</h1>
            <form action="/WarehousServlet" method="post">
                <table>
                    <tr>
                        <td>
                            物资名称：&nbsp<input type="text" name="name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            物资编码：&nbsp<input type="text" name="code">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            物资类型：&nbsp
                            <select name="type">
                                <option>防护类</option>
                                <option>医用类</option>
                                <option>日用类</option>
                                <option>生活类</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            入库时间：&nbsp<input type="date" name="warehous">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            有&nbsp&nbsp效&nbsp&nbsp期：<input type="text" name="valid">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            失效日期：<input type="date" name="invalid">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            物资数量：&nbsp<input type="text" name="number">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            物资单位：&nbsp
                            <select name="company">
                                <option>件</option>
                                <option>盒</option>
                                <option>箱</option>
                                <option>只</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="reset" value="重置" />
                        </td>
                        <td>
                            <input type="submit" value="提交" onclick="tijiao()" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        function tijiao(){
            alert("入库成功！")
        }

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
