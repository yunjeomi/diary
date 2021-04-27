<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<!-- 로그인 전; 로그인 안 되어있을 때 -->
	<c:if test="${sessionMember == null}">
		<h1>login</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div>
				<div>ID <input type="text" name="memberId"></div>
				<div>PW <input type="password" name="memberPw"></div>
				<div><button type="submit">로그인</button></div>
			</div>
		</form>
		<div><a href="${pageContext.request.contextPath}/addMember">회원가입</a></div>
	</c:if>
	
	<!-- 로그인 후; 로그인 되어있을 때 -->
	<c:if test="${sessionMember != null}">
		<div>${sessionMember.memberId}님 반갑습니다.</div>
		<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
	</c:if>
</body>
</html>