<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>商品管理系统</title>
</head>
<body>
    <table border="1" align="center" width="600px">
        <caption style="font-size: 30px">商品列表</caption>
        <thead>
        <th>勾选</th><th>名称</th><th>价格</th><th>详情</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="product">
            <tr>
                <td><input type="checkbox" name="item" value="${product.id}"/></td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.detail}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
