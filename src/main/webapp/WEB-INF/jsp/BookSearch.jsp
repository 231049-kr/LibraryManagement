<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .search-box {
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

    input[type="text"] {
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

<div class="search-box">

    <h1>図書検索</h1>

    <form action="BookSearchResult" method="post">

        書名：
        <input type="text" name="title">
        <br>

        著者：
        <input type="text" name="author">
        <br>

        分類：
        <input type="text" name="category">
        <br>

        <input type="submit" value="検索">

    </form>

</div>

</body>
</html>