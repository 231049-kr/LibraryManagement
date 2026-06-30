<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用停止確認</title>
</head>
<body>

<h1>利用停止確認</h1>

<p>この利用者を利用停止にしますか？</p>

<p>利用者ID：${user.userId}</p>

<p>氏名：${user.userName}</p>

<form action="UserStopServlet" method="post">

<input type="hidden" name="userId" value="${user.userId}">

<input type="submit" value="利用停止">

</form>

<br>

<a href="UserList.jsp">戻る</a>

</body>
</html>