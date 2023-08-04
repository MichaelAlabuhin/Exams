<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
<link href="css/403.css" rel="stylesheet">
</head>
<body>
	<div>
		<div class="info">
			<h1><spring:message code='access.denied'/></h1>
			<h3><spring:message code='access.no_permission'/></h3>
		</div>
		<div class="div-logout">
			<form action="/logout" method="post">
				<input type="submit" value="Sign in as different user"/> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</body>
</html>