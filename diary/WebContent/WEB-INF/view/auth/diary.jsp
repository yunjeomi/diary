<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diary</title>
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
				<h2>D-day List</h2>
			</header>
			
			<div class="table-wrapper">
				<table class="alt">
					<tr>
						<td width="15%">D-day</td>
						<td width="15%">Date</td>
						<td>Title</td>
					</tr>
					
					<c:forEach var="d" items="${diaryMap.ddayList}">
						<tr>
							<td>-${d.dday}</td>
							<td>${d.todoDate}</td>
							<td>
								<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${d.todoNo}">${d.todoTitle}</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<hr class="major" />
			
			<header class="major">
				<h2>Calendar</h2>
			</header>
			
			<p>Click a day to write down what happens and add your todoList</p>
			<h2>
				<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">&lt;&lt;</a>
				${diaryMap.targetYear}. ${diaryMap.targetMonth+1}
				<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">&gt;&gt;</a>
			</h2>
			<c:set var="totalCell" value="${diaryMap.startBlank+diaryMap.endDay+diaryMap.endBlank}"/>
			
			<div class="table-wrapper">
				<table class="alt">
					<tr style="text-align:center; vertical-align:center;">
						<td width="14.28%">SUN</td>
						<td width="14.28%">MON</td>
						<td width="14.28%">TUE</td>
						<td width="14.28%">WED</td>
						<td width="14.28%">THU</td>
						<td width="14.28%">FRI</td>
						<td width="14.28%">SAT</td>
					</tr>
					
					<tr>
						<c:forEach var="i" begin="1" end="${totalCell}" step="1">
							<c:set var="num" value="${i-diaryMap.startBlank}"/>
							<td>
								<c:if test="${num>0 && num<=diaryMap.endDay}">
									<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth+1}&day=${num}">
										<div>${num}</div>
										<div>
											<c:forEach var="todo" items="${diaryMap.todoList}">
												<c:if test="${todo.todoDate ==num}">
													<div style="background-color: ${todo.todoFontColor}">
														<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${todo.todoNo}">${todo.todoTitle}...</a>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</a>
								</c:if>
								<c:if test="${num<=0 || num>diaryMap.endDay}">
									&nbsp;
								</c:if>
							</td>
							
							<c:if test="${i%7==0}">
								</tr>
								<tr>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</section>
		
		</div>
	</div>
	
	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
			
			<!-- Menu -->
			<nav id="menu">
				<header class="major">
					<h2>Welcome ${sessionMember.memberId}!</h2>
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