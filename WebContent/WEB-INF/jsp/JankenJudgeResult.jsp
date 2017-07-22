<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Janken"%>
<%
int[] counter = (int[]) session.getAttribute("counter");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん</title>
</head>
<body>
	<h1>勝敗</h1>
	自分の手
	<br>
	<c:choose>
		<c:when test="${janken.hand == 0}">
			<img src="stone.jpg" width="300" height="300">
		</c:when>
		<c:when test="${janken.hand == 1}">
			<img src="scissors.jpg" width="300" height="300">
		</c:when>
		<c:otherwise>
			<img src="paper.jpg" width="300" height="300">
		</c:otherwise>
	</c:choose>
	<br> 相手の手
	<br>
	<c:choose>
		<c:when test="${janken.cpuHand == 0}">
			<img src="stone.jpg" width="300" height="300">
		</c:when>
		<c:when test="${janken.cpuHand == 1}">
			<img src="scissors.jpg" width="300" height="300">
		</c:when>
		<c:otherwise>
			<img src="paper.jpg" width="300" height="300">
		</c:otherwise>
	</c:choose>
	<br> 勝敗 : ${janken.result}
	<br>${counter[0]}勝${counter[1]}負${counter[2]}引き分け 
	<p>
		<p><a href="/Kadai/JankenController">戻る</a></p>
		<p><a href="/Kadai/LogoutController">ログアウト</a></p>
	</p>
</body>
</html>