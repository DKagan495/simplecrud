<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 05.06.2021
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<style>
    input{
        height: 36px;
        width: 436px;
        font-size: 30px;
        font-family: Arial;
        border-radius: 12px;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New book</title>
</head>
<body>
<h1>Add a new book</h1>
<form method="post">
    <label for="name">Name:</label><input type="text" name="name" id="name"><br/>
    <label for="author">Author:</label><input type="text" name="author"  id="author"><br/>
    <label for="year">Year:</label><input type="text" name="year" id="year"><br/>
    <label for="cost">Cost:</label><input type="text" name="cost" id="cost"><br/>
    <input type="submit" value="Add">
</form>
</body>
</html>
