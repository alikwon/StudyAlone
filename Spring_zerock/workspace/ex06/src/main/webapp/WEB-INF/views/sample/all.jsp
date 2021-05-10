<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- all or member or admin -->
	<h1>/sample/all page</h1>
	<sec:authorize access="isAnonymous()">
		<h3>로그인 할래염?</h3>
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<h3>로그아웃 할래염?</h3>
		<a href="/customLogout">로그아웃</a>
	</sec:authorize>
</body>
</html>