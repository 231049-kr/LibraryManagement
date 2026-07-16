<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>

<h1>ユーザー登録</h1>

<form action="UserRegister" method="post">
<p>
    氏名：
    <input type="text" name="name">
</p>

<p>
    メールアドレス：
    <input type="text" name="email">
</p>

<p>
    パスワード：
    <input type="password" name="password">
</p>

<p>
    電話番号：
    <input type="text" name="phone">
</p>

<p>
    住所：
    <input type="text" name="address">
</p>

<input type="submit" value="登録">
</form>

<br>

<a href="UserMenuServlet">メニューに戻る</a>

</body>
</html>
