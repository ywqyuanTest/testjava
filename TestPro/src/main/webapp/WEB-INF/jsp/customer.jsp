<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xm001
  Date: 2016/3/14
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>客户列表</h1>
<table>
  <tr>
    <th>客户名称</th>
    <th>联系人</th>
    <th>电话号码</th>
    <th>邮箱地址</th>
    <th>操作</th>
  </tr>

  <c:forEach var="customer" items="${customerList}">
    <tr>
    <th>${customer.name}</th>
    <th>${customer.remark}</th>
    <th>${customer.telphone}</th>
    <th>${customer.email}</th>
    <th>
      <a href="#">编辑</a>
      <a href="#">删除</a>
    </th>
    </tr>
  </c:forEach>



</table>
</body>
</html>
