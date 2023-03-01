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
    <title>政府机构管理中心-销毁登记</title>
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
                            <li><a href="#">销毁登记</a></li>
                            <li><a href="/InformationServlet">物资信息</a></li>
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
            <h1>销毁登记</h1>
            <form action="/DestructionServlet" method="post">
                <table>
                    <tr>
                        <td>名称:</td>
                        <td><input type="text" name="name" /></td>
                    </tr>
                    <tr>
                        <td>编码:</td>
                        <td><input type="text" name="code" /></td>
                    </tr>
                    <tr>
                        <td>数量:</td>
                        <td><input type="number" name="number" /></td>
                    </tr>
                    <tr>
                        <td>单位:</td>
                        <td>
                            <select name="company">
                                <option value="件">件</option>
                                <option value="盒">盒</option>
                                <option value="箱">箱</option>
                                <option value="只">只</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="reset" value="重置" />
                        </td>
                        <td>
                            <input type="submit" value="提交" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        if (${requestScope.number}){
            alert("销毁成功！")
        }else {
            alert("销毁量不能大于库存量！")
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
