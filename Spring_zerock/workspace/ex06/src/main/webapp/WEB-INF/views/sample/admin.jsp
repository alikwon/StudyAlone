<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/admin page</h1>
	
	<h3>principal</h3>
	<p><sec:authentication property="principal"/></p>
	
	<h3>Member VO</h3>
	<p><sec:authentication property="principal.member"/></p>
	
	<h3>사용자이름</h3>
	<p><sec:authentication property="principal.member.userName"/></p>
	
	<h3>사용자 ID</h3>
	<p><sec:authentication property="principal.username"/></p>
	
	<h3>사용자 권한 리스트</h3>
	<p><sec:authentication property="principal.member.authList"/></p>
	
	<a href="/customLogout">Logout</a>
</body>
</html>