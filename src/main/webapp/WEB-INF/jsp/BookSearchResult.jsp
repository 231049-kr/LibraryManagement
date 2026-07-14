<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<h1>図書検索結果</h1>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table border="1">
<tr>
    <th>ID</th>
    <th>タイトル</th>
    <th>著者</th>
    <th>出版社</th>
    <th>在庫</th>
    <th>操作</th>
</tr>

<%
for(Book book : books){
%>

<tr>
    <td><%= book.getBookId() %></td>
    <td><%= book.getTitle() %></td>
    <td><%= book.getAuthor() %></td>
    <td><%= book.getPublisher() %></td>
    <td><%= book.getQuantity() %></td>

    <td>
    <%
    if(book.getQuantity() > 0){
    %>
        <form action="" method="post">
            <input type="hidden" 
                   name="book_id" 
                   value="<%= book.getBookId() %>">

            <button type="submit">
                予約する
            </button>
        </form>

    <%
    }else{
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

</table>
<a href="UserMenuServlet">メニューに戻る</a>
</body>
</html>
