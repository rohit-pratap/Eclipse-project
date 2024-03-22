<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Services</title>
<style>
    body {font-family: Arial, sans-serif;}
    .form-group {margin-bottom: 15px;}
    .form-group label {display: block;}
    .form-group input {width: 100%; padding: 10px; font-size: 1em;}
    button {padding: 10px 20px; font-size: 1em;}
</style>
</head>
<body>
    <form action="userServlet" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id">
        </div>
        <div class="form-group">
            <label for="userName">UserName:</label>
            <input type="text" id="username" name="userName">
        </div>
        <div class="form-group">
            <label for="balance">Balance:</label>
            <input type="text" id="balance" name="balance">
        </div>
        <button type="submit" name="action" value="get">GET</button>
        <button type="submit" name="action" value="post">POST</button>
        <button type="submit" name="action" value="put">PUT</button>
        <button type="submit" name="action" value="delete">DELETE</button>
    </form>
</body>
</html>
