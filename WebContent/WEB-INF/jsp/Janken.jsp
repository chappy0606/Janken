<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん</title>
</head>
<body>
<% if(loginUser != null) { %>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<%}else{ request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);%>
<%} %>
<form action="/Kadai/JankenController" method="post">
じゃんけん<br>
<BR>
グー<input type="radio" name="hand" value="0"><BR>
チョキ<input type="radio" name="hand" value="1"><BR>
パー<input type="radio" name="hand" value="2"><BR>
<BR>
<input type="submit" value="結果">
</form>
<font color="red">${ error }</font>
</body>
</html>