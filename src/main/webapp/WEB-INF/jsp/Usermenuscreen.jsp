<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者メニュー画面</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .menu-box {
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

    .menu-link {
        display: block;
        width: 250px;
        margin: 15px auto;
        padding: 12px;
        background-color: #eeeeee;
        color: black;
        text-decoration: none;
        border-radius: 5px;
    }

    .menu-link:hover {
        background-color: #dddddd;
    }

</style>

</head>

<body>

<div class="menu-box">

    <h1>メニュー</h1>

    <a href="BookSearch" class="menu-link">
        図書検索
    </a>

    <a href="Reserve" class="menu-link">
        予約
    </a>

    <a href="UserInfomation" class="menu-link">
        自身の情報照会
    </a>

    <a href="LoanHistory" class="menu-link">
        貸出状況確認
    </a>

</div>

</body>
</html>