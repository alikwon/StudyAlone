<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>customLogin Page</h1>
<h2><c:out value="${error }"/></h2>
<h2><c:out value="${logout }"/></h2>
<form action="/login" method="post">
	<div>
		<input type="text" name="username" value="admin">
	</div>
	<div>
		<input type="password" name="password" value="admin">
	</div>
	<div>
		<input type="checkbox" name="remember-me"> Remember Me
	</div>
	<div>
		<input type="submit">
	</div>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
</body>
</html>