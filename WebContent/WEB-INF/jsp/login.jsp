<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん</title>
</head>
<body>
<h1>ログイン画面</h1>
<form action="/Kadai/LoginController" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
<a href="/Kadai/SignUpController?action=input">アカウントをお持ちでない方はこちら</a>
</form>
<font color="red">${ error }</font>
</body>
</html>