<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約登録</title>
</head>
<body>

<h1>予約登録</h1>

<p>予約を登録しますか？</p>

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

<form action="ReserveCompleteServlet"method="get">
	<input type="submit"value="登録">
</form>

</body>
</html>