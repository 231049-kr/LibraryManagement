<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自身の情報照会</title>
</head>
<body>
<h1>利用者情報</h1>
ユーザーID:${sessionScope.loginUser.id }
<p>${sessionScope.loginUser}</p>

<a href="UserMenuServlet">メニューへ戻る</a>

</body>
</html>