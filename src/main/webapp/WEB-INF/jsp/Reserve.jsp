<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<h1>図書一覧（予約対象）</h1>

<c:if test="${empty bookList}">
  <p>利用可能な図書がありません。</p>
</c:if>

<c:if test="${not empty bookList}">
  <table>
    <thead>
      <tr>
        <th>書籍ID</th>
        <th>書名</th>
        <th>著者</th>
        <th>カテゴリ</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${bookList}">
        <tr>
          <td>${book.id}</td>
          <td>${book.title}</td>
          <td>${book.author}</td>
          <td>${book.category}</td>
          <td>
            <form action="reserveRegist.jsp" method="post" style="display:inline;">
              <input type="hidden" name="bookId" value="${book.id}">
              <button type="submit">予約する</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</c:if>

<a href="Usermenuscreen.jsp">メニューに戻る</a>

</body>
</html>
