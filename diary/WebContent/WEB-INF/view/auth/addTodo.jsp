<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addTodo</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</head>
<body class="is-preload">
<!-- Wrapper -->
<div id="wrapper">

	<!-- Main -->
	<div id="main">
		<div class="inner">
		
		<!-- Content -->
		<section>
			<header class="major">
				<h2>Todo 추가</h2>
			</header>
			
			<form action="${pageContext.request.contextPath}/auth/addTodo" method="post">
				<div class="table-wrapper">
					<table class="alt">
						<tr>
							<td>Date</td>
							<td><input type="text" name="todoDate" value="${todoDate.toString()}" readonly></td>
						</tr>
						<tr>
							<td>Title</td>
							<td><input type="text" name="todoTitle"></td>
						</tr>
						<tr>
							<td>Content</td>
							<td><textarea name="todoContent" cols="80" rows="5"></textarea></td>
						</tr>
						<tr>
							<td>FontColor</td>
							<td><input type="color" name="todoFontColor"></td>
						</tr>
					</table>
					<button type="submit">추가</button>
					<a href="${pageContext.request.contextPath}/auth/diary" class="button primary">취소</a>
				</div>
			</form>
		</section>
		
		</div>
	</div>
	
	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
			
			<!-- Menu -->
			<nav id="menu">
				<header class="major">
					<h2>${sessionMember.memberId}님 반갑습니다.</h2>
				</header>
				<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
			</nav>
		
			<!-- Footer -->
			<footer id="footer">
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
					<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
				</ul>
				<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
			</footer>
			
		</div>
	</div>
	
</div>
</body>
</html>