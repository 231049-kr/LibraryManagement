<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認</title>

<style>
  table {
    border-collapse: collapse;
    width: 100%;
    margin: 20px 0;
  }

  th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
  }

  th {
    background-color: #f2f2f2;
  }

  button {
    padding: 8px 16px;
    cursor: pointer;
  }
</style>

</head>
<body>

<h1>図書検索</h1>

<form action="ReserveRegist" method="post">

    書籍ID：
    <input type="text" name="book_id">

    書名：
    <input type="text" name="title">

    著者：
    <input type="text" name="author">

    カテゴリ：
    <input type="text" name="category">

    出版社：
    <input type="text" name="publisher">

    <br><br>

    <button type="submit">検索</button>

</form>

<br>

<a href="UserMenuServlet">メニューに戻る</a>

</body>
</html>