<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .login-box {
        width: 350px;
        margin: 100px auto;
        padding: 30px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
    }

    h1 {
        margin-bottom: 30px;
    }

    input[type="text"],
    input[type="password"] {
        width: 200px;
        padding: 8px;
        margin: 8px;
    }

    input[type="submit"] {
        padding: 10px 30px;
        margin-top: 15px;
        cursor: pointer;
    }

</style>

</head>

<body>

<div class="login-box">

<h1>ログイン</h1>

<form action="LoginServlet" method="post">

    ID：
    <input type="text" name="name">
    <br>

    PW：
    <input type="password" name="password">
    <br>

    <input type="submit" value="ログイン">


</form>

</div>

</body>
</html>
