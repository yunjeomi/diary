<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOne</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
	
	<h1>내 정보</h1>
	
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${member.memberId}</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><a href="${pageContext.request.contextPath}/auth/modifyMemberPw">변경</a></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${member.memberDate}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/auth/removeMember"><button type="button">회원탈퇴</button></a>
</body>
</html>