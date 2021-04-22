<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMemberPw</title>
</head>
<body>
	<h1>updateMemberPw</h1>
	
	<form action="${pageContext.request.contextPath}/auth/updateMember" method="post">
		<table border="1">
			<tr>
				<td>memberId</td>
				<td>
					<input type="text" name="memberId" value="${memberId}" readonly>
				</td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td>
					<input type="password" name="memberPw">
				</td>
			</tr>
		</table>
		<button type="submit">비밀번호변경</button>
	</form>
</body>
</html>