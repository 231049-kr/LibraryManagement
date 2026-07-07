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
<form action="BookSearchResult" method="get">

<form action="" method="post">
書名 : <input type="text" name="title"><br>
著者 : <input type="text" name="name"><br>
著者 : <input type="text" name="author"><br>
分類 : <input type="text" name="category"><br>
<input type="submit" value="検索">
</form>
</body>
</html>