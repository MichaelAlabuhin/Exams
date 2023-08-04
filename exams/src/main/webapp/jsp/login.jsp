<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form method="POST" action="${contextPath}/login" class="form-signin">
  			<div class="form-group ${error != null ? 'has-error' : ''}">
  				<div class="text-logout">
  					<span>${message}</span>
  				</div> 
    			<input name="email" type="text" class="form-control" placeholder=<spring:message code='login.email'/> required/>
    			
    			<input name="password" type="password" class="form-control" placeholder=<spring:message code='login.password'/> required/>
    			<div class="text-error">
    				<span >${error}</span>
    			</div>				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button type="submit"><spring:message code='login.logIn'/></button>
				<div class="createAccount">
					<span class="text-createAccount"> <a href="${contextPath}/registration"><spring:message code='login.create_account'/></a></span>
					<div>
						<label><spring:message code="login.choose_language"/></label> 
						<select id="locales">
							<option value="ua"><spring:message code='login.ukrainian'/></option>
							<option value="en"><spring:message code='login.english'/></option>
						</select>
					</div>
				</div>				
			</div>
		</form>	
	</div>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="js/language.js"></script>
</body>
</html>