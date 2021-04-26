<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diary</title>
</head>
<body>
	
	<c:set var="totalCell" value="${diaryMap.startBlank+diaryMap.endDay+diaryMap.endBlank}"/>
	<div>totalCell: ${totalCell}</div>
	
	<h1>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전 달</a>
		 ${diaryMap.targetYear}년 ${diaryMap.targetMonth+1}월
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음 달</a>
	
	</h1>
	
	<table border="1" width="90%">
		<tr>
			<td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td>
		</tr>
		
		<tr>
			<c:forEach var="i" begin="1" end="${totalCell}" step="1">
				<c:set var="num" value="${i-diaryMap.startBlank}"/>
				<td>
					<c:if test="${num>0 && num<=diaryMap.endDay}">
						<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth+1}&day=${num}">
							${num}
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
</body>
</html>