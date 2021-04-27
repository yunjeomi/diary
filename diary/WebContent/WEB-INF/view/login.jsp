<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
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
				<header id="header">
					<h1>Simple Diary</h1>
				</header>
				
				<!-- 로그인 전; 로그인 안 되어있을 때 -->
				<c:if test="${sessionMember == null}">
				<section>
					<header class="main">
					<h2>Write down what happens each day!</h2>
					<h2>It's easy to manage your schedule!</h2>
					<h2>Let's join us!</h2>
					</header>
				</section>
				</c:if>
				
				<!-- 로그인 후; 로그인 되어있을 때 -->
				<c:if test="${sessionMember != null}">
				<section>
					<header class="main">
					<h2>Welcome!</h2>
					<h2>Click a diary and Add your todoList!</h2>
					<h2>Enjoy posting your everything!</h2>
					</header>
				</section>
				</c:if>

		</div>
	</div>
	
	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
		
			<!-- 로그인 전; 로그인 안 되어있을 때 -->
			<c:if test="${sessionMember == null}">
				<section id="search" class="alt">
					<form action="${pageContext.request.contextPath}/login" method="post">
						<div>ID <input type="text" name="memberId"></div>
						<div>PW <input type="password" name="memberPw"></div>
						<br>
						<button type="submit">Login</button>
						<a href="${pageContext.request.contextPath}/addMember" class="button primary">Join us</a>
					</form>
				</section>
			</c:if>
			
			<!-- 로그인 후; 로그인 되어있을 때 -->
			<!-- Menu -->
			<c:if test="${sessionMember != null}">
				<nav id="menu">
					<header class="major">
						<h2>Welcome ${sessionMember.memberId}!</h2>
					</header>
					<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
				</nav>
			</c:if>
			
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