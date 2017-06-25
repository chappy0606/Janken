<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん</title>
</head>
<body>

<form action="/Kadai/JankenController" method="post">
じゃんけん<br>
<BR>
グー<input type="radio" name="hand" value="0"><BR>
チョキ<input type="radio" name="hand" value="1"><BR>
パー<input type="radio" name="hand" value="2"><BR>
<BR>
<input type="submit" value="結果">
</form>
</body>
</html>