<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="/Kadai/SignUpController" method="post">
ニックネーム：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="登録">
<p><a href="/Kadai/LoginController">戻る</a></p>
</form>
<font color="red">${ error }</font>
</body>
</html>