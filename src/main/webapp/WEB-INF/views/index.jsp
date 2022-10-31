<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>Index page</h1>
	<h1><spring:message code="hi" var="h"></spring:message></h1>
	<h1><spring:message code="test" text="code가 없을때 출력하는 메시지"></spring:message></h1>
	<c:choose>
		<c:when test="${not empty member }">
			<h3><spring:message code="welcome" arguments="${member.name }"></spring:message></h3>
			<h3><spring:message code="welcome2" arguments="${member.id },${member.name }" argumentSeparator=","></spring:message></h3>
			<a href="/member/logOut">LogOut</a>
		</c:when>
		<c:otherwise>
			<a href="/member/login">LogIn</a>
			<a href="/member/join">Join</a>
		</c:otherwise>
	</c:choose>
	<img src="./images/winter.jpg" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
		<img alt="" src="/file/qna/242352d8-265b-4214-a952-aadd7709f21d_4d4e0f18-2d46-4c24-b9b8-387563ff5147_91b38d20-c33e-49f3-9d53-0dec805ca446_sa.jpg">
		<img alt="" src="/file/notice/245c8fdc-ecf9-4266-9e7a-7d302549ebaa_웰시코기.jpg">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>

	<button id="btn">Click</button>
	<button class="buttons">Btn1</button>
	<button class="buttons">Btn2</button>
	<button class="buttons">Btn3</button>
	
	<div id="test">

	</div>

</body>
</html>