<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者登録</title>
</head>
<body>

<h1>利用者登録</h1>

<form action="" method="post">

利用者ID:<input type="text" name="userId"><br><br>
氏名:<input type="text" name="userName"><br><br>
パスワード:<input type="password" name="password"><br><br>

利用者区分:
<select name="role">
	<option value="利用者">利用者</option>
	<option value="司書">司書</option>
    <option value="管理者">管理者</option>
</select>

<br><br>

<input type="submit" value="登録">

</form>

<br>

<a href="UserList.jsp">戻る</a>

</body>
</html>