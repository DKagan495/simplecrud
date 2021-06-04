
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 04.06.2021
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<style>
    p{
        text-decoration-color: chocolate;
        font-family: "HoloLens MDL2 Assets";
        font-size: 27px;
        font-style: oblique;
    }
    a{
        font-style: oblique;
        font-size: 28px;
        font-family: "Agency FB";
        color: chocolate;
    }
    a hover{
        font-style: oblique;
        font-size: 36px;
        font-family: "Agency FB", sans-serif;
        color: chocolate;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<a href="/books/new"><button>Add a book</button></a><br/>
    <c:forEach var="book" items="${requestScope.bookies}">
        <a href=""><c:out value="${book.name} ${book.author}"/></a><br/>
    </c:forEach>
</body>
</html>
