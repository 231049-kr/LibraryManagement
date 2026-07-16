<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    .result-box {
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

    input[type="submit"] {
        padding: 6px 15px;
        cursor: pointer;
    }

    a {
        display: inline-block;
        margin-top: 20px;
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

<div class="result-box">

<h1>図書検索結果</h1>

<%
List<Book> books =
    (List<Book>) request.getAttribute("books");
%>

<table>

<tr>
    <th>ID</th>
    <th>タイトル</th>
    <th>著者</th>
    <th>出版社</th>
    <th>在庫</th>
    <th>操作</th>
</tr>

<%
for (Book book : books) {
%>

<tr>

    <td><%= book.getBookId() %></td>
    <td><%= book.getTitle() %></td>
    <td><%= book.getAuthor() %></td>
    <td><%= book.getPublisher() %></td>
    <td><%= book.getQuantity() %></td>

    <td>

<%
    if (book.getQuantity() > 0) {
%>

        <form action=" method="post">

            <input type="hidden"
                   name="book_id"
                   value="<%= book.getBookId() %>">

            <input type="submit"
                   value="予約する">

        </form>

<%
    } else {
%>

        在庫なし

<%
    }
%>

    </td>

</tr>

<%
}
%>

</table>

<a href="UserMenuServlet">
    メニューに戻る
</a>

</div>

</body>
</html>