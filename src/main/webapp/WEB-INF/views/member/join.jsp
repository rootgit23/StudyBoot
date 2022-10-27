<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/add.js"></script>
<script defer src="/js/util.js"></script>
</head>
<body>
<h1>Join Page</h1>
	<form action="/member/join" method="post" id="join">
		<input type="text" name="id" id="jid">
		<input type="text" name="pw" id="jpw">
		<input type="text" id="jppw">
		<input type="text" name="name" id="jname">
		<input type="text" name="email" id="jemail">
		<button type="button" id="joinButton">가입</button>
	</form>

	<div>
		<div>
			ALL<input type="checkbox" id="all">
		</div>
		<div>
			동의1<input type="checkbox" class="check" name="" id="">
			<div>
				약관1
			</div>
		</div>
		<div>
			동의2<input type="checkbox" class="check" name="" id="">
			<div>
				약관2
			</div>
		</div>
		<div>
			동의3<input type="checkbox" class="check" name="" id="">
			<div>
				약관3
			</div>
		</div>
	</div>
</body>
</html>