<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/top.css" rel="stylesheet">
<title>Top</title>
</head>
<body>
	<header>
		<h1>Top</h1>
		<%= LocalDate.now() %>
		<nav>
			<ul class="global-nav">
				<li><a href="/WEB-INF/jsp/nippoSubmitView.jsp">日報提出</a></li>
				<li><a href="/WEB-INF/jsp/nippoView.jsp">日報編集</a></li>
				<li><a href="/Dairy_Report/Formmat">フォーマット登録</a></li>
				<li><a href="/WEB-INF/jsp/memberInfoView.jsp">ユーザ情報</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>