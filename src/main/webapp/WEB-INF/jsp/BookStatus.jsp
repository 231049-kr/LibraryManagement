<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書状態変更</title>
</head>
<body>

<h1>図書状態変更</h1>


<form action=""method="post">

図書ID：
<input type="text" name="bookId"><br><br>

状態：
<select name="status">
    <option value="貸出可能">貸出可能</option>
    <option value="貸出中">貸出中</option>
    <option value="予約中">予約中</option>
    <option value="利用停止">利用停止</option>
</select>

<br><br>

<input type="submit" value="変更">

</form>

<br>

<a href="">戻る</a>

</body>
</html>