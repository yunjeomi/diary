<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoOne</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
	
	<h1>todoOne</h1>
	
	<table border="1">
		<tr>
			<td>Date</td>
			<td>${todoOne.todoDate}</td>
		</tr>
		<tr>
			<td>Title</td>
			<td>${todoOne.todoTitle}</td>
		</tr>
		<tr>
			<td>Content</td>
			<td>${todoOne.todoContent}</td>
		</tr>
		<tr>
			<td>FontColor</td>
			<td>${todoOne.todoFontColor}</td>
		</tr>
		<tr>
			<td>addDate</td>
			<td>${todoOne.todoAddDate}</td>
		</tr>
	</table>
	<input type="hidden" name="memberNo" value="${todoOne.memberNo}">
	<input type="hidden" name="todoNo" value="${todoOne.todoNo}">
	<a href="${pageContext.request.contextPath}/auth/modifyTodoOne?memberNo=${todoOne.memberNo}&todoNo=${todoOne.todoNo}">수정</a>
	<a href="${pageContext.request.contextPath}/auth/removeTodoOne?memberNo=${todoOne.memberNo}&todoNo=${todoOne.todoNo}">삭제</a>
</body>
</html>