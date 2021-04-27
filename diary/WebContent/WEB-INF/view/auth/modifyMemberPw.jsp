<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMemberPw</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
	
	<h1>Pw변경</h1>
	
	<form action="${pageContext.request.contextPath}/auth/modifyMemberPw" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td>
					<input type="hidden" name="memberNo" value="${member.memberNo}">
					<input type="text" name="memberId" value="${member.memberId}" readonly>
				</td>
			</tr>
			<tr>
				<td>PW</td>
				<td>
					<input type="password" name="memberPw">
				</td>
			</tr>
		</table>
		<button type="submit">비밀번호변경</button>
	</form>
	<a href="${pageContext.request.contextPath}/auth/myAccount">취소</a>
</body>
</html>