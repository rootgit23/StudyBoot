<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LogIn Page</h1>
	<form action="/member/login" method="post" >
		<input type="text" name="id">
		<input type="text" name="pw">
		<input type="submit" value="로그인">
	</form>
</body>
</html>