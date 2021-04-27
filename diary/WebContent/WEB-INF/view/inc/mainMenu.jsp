<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainMenu</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/auth/diary">다이어리</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/myAccount">회원정보</a></li>
		<li><a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a></li>
	</ul>
</body>
</html>