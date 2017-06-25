<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Janken"%>
<%
	Janken janken = (Janken) request.getAttribute("janken");
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
	<%
		if (janken.getHand() == 0) {
	%>
	<p>
		<img src="stone.jpg" width="300" height="300">
	</p>
	<%
		} else if (janken.getHand() == 1) {
	%>
	<p>
		<img src="scissors.jpg" width="300" height="300">
	</p>
	<%
		} else if (janken.getHand() == 2) {
	%>
	<p>
		<img src="paper.jpg" width="300" height="300">
	</p>
	<%
		}
	%>
	相手の手
	<%
		if (janken.getCpuHand() == 0) {
	%>
	<p>
		<img src="stone.jpg" width="300" height="300">
	</p>
	<%
		} else if (janken.getCpuHand() == 1) {
	%>
	<p>
		<img src="scissors.jpg" width="300" height="300">
	</p>
	<%
		} else if (janken.getCpuHand() == 2) {
	%>
	<p>
		<img src="paper.jpg" width="300" height="300">
	</p>
	<%
		}
	%>
	<br> 勝敗:<%=janken.getResult()%>
	<p>
		<a href="#" onClick="history.back(); return false;">戻る</a>
	</p>
</body>
</html>