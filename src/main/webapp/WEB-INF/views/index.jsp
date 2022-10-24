<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">

</head>
<body>
	<h1>Index page</h1>
	<img src="./images/winter.jpg" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
		<img alt="" src="/file/qna/242352d8-265b-4214-a952-aadd7709f21d_4d4e0f18-2d46-4c24-b9b8-387563ff5147_91b38d20-c33e-49f3-9d53-0dec805ca446_sa.jpg">
		<img alt="" src="/file/notice/245c8fdc-ecf9-4266-9e7a-7d302549ebaa_웰시코기.jpg">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>


</body>
</html>