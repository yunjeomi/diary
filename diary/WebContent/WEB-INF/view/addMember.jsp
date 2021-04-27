<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
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
				<h2>Create your account</h2>
			</header>
			
			<form action="${pageContext.request.contextPath}/addMember" method="post">
				<div class="table-wrapper">
					<table class="alt">
						<tr>
							<td>memberId</td>
							<td>
								<input type="text" name="memberId" placeholder="example@example.com">
							</td>
						</tr>
						<tr>
							<td>memberPw</td>
							<td>
								<input type="password" name="memberPw">
							</td>
						</tr>
					</table>
				</div>
				<button type="submit">Join</button>
				<a href="${pageContext.request.contextPath}/login" class="button primary">Go back</a>
			</form>
		</section>
		
		</div>
	</div>
	
	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
		
			<section id="search" class="alt">
				<form action="${pageContext.request.contextPath}/login" method="post">
					<div>ID <input type="text" name="memberId"></div>
					<div>PW <input type="password" name="memberPw"></div>
					<br>
					<button type="submit">Login</button>
					<a href="${pageContext.request.contextPath}/addMember" class="button primary">Join us</a>
				</form>
			</section>
			
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