<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索</title>
</head>
<body>
<h1>図書検索</h1>
<form action="Login" method="post">
書名 : <input type="text" name="bookName"><br>
著者 : <input type="text" name="author"><br>
分類 : <input type="text" name="category"><br>
<input type="submit" value="検索">
</form>
</body>
</html>