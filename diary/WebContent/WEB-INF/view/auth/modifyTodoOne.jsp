<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyTodoOne</title>
</head>
<body>
	<h1></h1>
	
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>todoDate</td>
				<td>${todoOne.todoDate}</td>
			</tr>
			<tr>
				<td>Title</td>
				<td>
					<input type="text" name="todoTitle" value="${todoOne.todoTitle}">
				</td>
			</tr>
			<tr>
				<td>Content</td>
				<td>
					<textarea name="todoContent" rows="5" cols="80">${todoOne.todoContent}</textarea>
				</td>
			</tr>
			<tr>
				<td>FontColor</td>
				<td>
					<input type="color" name="todoFontColor" value="${todoOne.todoFontColor}">
				</td>
			</tr>
			<tr>
				<td>addDate</td>
				<td>${todoOne.todoAddDate}</td>
			</tr>
		</table>
		<input type="hidden" name="memberNo" value="${todoOne.memberNo}">
		<input type="hidden" name="todoNo" value="${todoOne.todoNo}">
		<button type="submit">수정</button>
	</form>
	<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${todoOne.todoNo}">취소</a>
</body>
</html>