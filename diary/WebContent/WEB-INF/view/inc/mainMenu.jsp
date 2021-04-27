<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainMenu</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/auth/diary">Diary</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/myAccount">My account</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/logout">Logout</a></li>
	</ul>
</body>
</html>