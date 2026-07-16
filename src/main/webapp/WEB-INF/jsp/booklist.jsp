<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書一覧画面</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .book-box {
        width: 800px;
        margin: 50px auto;
        padding: 30px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
    }

    th {
        background-color: #eeeeee;
    }

</style>

</head>

<body>

<div class="book-box">

    <h1>図書一覧</h1>

    <table>

        <tr>
            <th>書籍ID</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>カテゴリ</th>
            <th>在庫数</th>
        </tr>

       
    </table>

</div>

</body>
</html>