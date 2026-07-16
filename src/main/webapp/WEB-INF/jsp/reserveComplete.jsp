<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .complete-box {
        width: 400px;
        margin: 100px auto;
        padding: 30px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
    }

    h1 {
        margin-bottom: 30px;
    }

    p {
        margin-bottom: 30px;
    }

    a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #eeeeee;
        color: black;
        text-decoration: none;
        border-radius: 5px;
    }

    a:hover {
        background-color: #dddddd;
    }

</style>

</head>

<body>

<div class="complete-box">

    <h1>予約確認</h1>

    <p>予約が完了しました。</p>

    <a href="UserMenuServlet">
        メニューへ戻る
    </a>

</div>

</body>
</html>