<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addTodo</title>
</head>
<body>
	<h1>To do 입력</h1>
	
	<form action="${pageContext.request.contextPath}/auth/addTodo" method="post">
		<table border="1">
			<tr>
				<td>todoDate</td>
				<td><input type="text" name="todoDate" value="${todoDate.toString()}" readonly></td>
			</tr>
			<tr>
				<td>todoTitle</td>
				<td><input type="text" name="todoTitle"></td>
			</tr>
			<tr>
				<td>todoContent</td>
				<td><textarea name="todoContent" cols="80" rows="5"></textarea></td>
			</tr>
			<tr>
				<td>todoFontColor</td>
				<td><input type="color" name="todoFontColor"></td>
			</tr>
		</table>
		<button type="submit">addTodo</button>	
	</form>
	
	
</body>
</html>