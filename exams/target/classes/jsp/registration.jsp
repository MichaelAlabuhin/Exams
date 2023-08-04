<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link href="css/registration.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<label><b><spring:message code='registration.title'/></b></label>
			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code="registration.first_name" var="first_name"/>
					<form:input type="text" path="firstName" class="form-control" placeholder= "${first_name}"  autofocus="true" required="required"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code="registration.last_name" var="last_name"/>
					<form:input type="text" path="lastName" class="form-control" placeholder="${last_name}" autofocus="true" required="required"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code="login.email" var="email"/>
					<form:input type="text" path="email" class="form-control" placeholder="${email}" autofocus="true" required="required"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code="login.password" var="password"/>
					<form:input type="password" path="password" class="form-control" placeholder="${password}" required="required"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<spring:message code="registration.confirm_password" var="confirm_password"/>
					<form:input type="password" path="passwordConfirm" class="form-control" placeholder="${confirm_password}" required="required"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<button type="submit"><spring:message code='registration.submit'/></button>
			
		</form:form>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>