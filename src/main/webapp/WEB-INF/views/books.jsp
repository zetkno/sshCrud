<%--
  Created by IntelliJ IDEA.
  User: 2026
  Date: 2018/6/15
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>书</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>书名</th>
        <th>作者</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.bookAuthor}</td>
            <td><a href="<c:url value='/book/modifyBook?id=${book.id}' />">编辑</a>
                <a href="<c:url value='/book/deleteBook?id=${book.id}' />">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br />
<a href="<c:url value='/book/newBook' />">添加图书</a>
<a href="<c:url value='/book/searchBook' />">查找图书</a>
</body>
</html>