<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<h1>図書検索結果</h1>
<table border="1">
  <tr>
    <th>書籍ID</th>
    <th>タイトル</th>
    <th>著者</th>
    <th>カテゴリ</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.author}</td>
      <td>${book.category}</td>
    </tr>
  </c:forEach>
</table>
<a href="Usermenuscreen.jsp">メニューに戻る</a>
</body>
</html>
