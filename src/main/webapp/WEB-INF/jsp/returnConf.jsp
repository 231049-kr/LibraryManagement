<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却確認画面</title>
</head>
<body>

<h1>返却確認</h1>

図書ID:
${bookId}
<br>

利用者ID:
${userId}
<br><br>

<form action="" method="post">

<input type="hidden"
		name="userId"
		value="${userId}">
		
<input type="hidden"
		name="bookId"
		value="${bookId}">
		
<input type="submit" value="返却する">
</form>

</body>
</html>