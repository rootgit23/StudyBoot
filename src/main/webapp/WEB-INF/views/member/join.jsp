<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form action="/member/join" modelAttribute="memberVO" method="post">
	<form action="/member/join" method="post" id="join">
		<form:input path="id" id="jid"/>
		<form:errors path="id" id="inputIdResult"></form:errors>
		<input type="text" name="id" id="jid">
		<form:password path="pw" id="jpw"/>
		<form:errors path="pw"></form:errors>
		<input type="text" name="pw" id="jpw">
		<form:password path="pwCheck" id="jppw"/>
		<form:errors path="pwCheck"></form:errors>
		<input type="text" id="jppw">
		<form:input path="name" id="jname"/>
		
		<div>
			<form:errors path="name">
				
			</form:errors>
		</div>
		<input type="text" name="name" id="jname">
		<form:input path="email" id="jemail"/>
		<form:errors path="email"></form:errors>
		<input type="text" name="email" id="jemail">
		<button type="button" id="joinButton">가입</button>
	</form>
	</form:form>

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