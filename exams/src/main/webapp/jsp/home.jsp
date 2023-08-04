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
<title>Home</title>
<link href="css/home.css" rel="stylesheet">
</head>
<body>
	<div class="container">	
			
		<div class="sidebar">
  			<a class="active" href="/home"><spring:message code='home.menu_home'/></a>
  			<security:authorize access="hasRole('ROLE_USER')">
  				<a href="/addApplicant"><spring:message code='home.menu_add_applicant'/></a>
  			</security:authorize>
  			<security:authorize access="hasRole('ROLE_ADMIN')">
  				<a href="/finalStatement"><spring:message code='home.menu_final_statement'/></a>
  			</security:authorize>
  			<a onclick="document.forms['logoutForm'].submit()" href=# id="buttonLogout"><spring:message code='home.menu_logout'/></a>
 		</div>
		
		<div class="content">	
		
			<c:if test="${pageContext.request.userPrincipal.name != null}">			
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>				
			</c:if>			
						
			<c:if test="${not empty applicants}">				
				<div>
					<div class="titleOfPage">
						<h4><spring:message code='home.title_of_current_list'/></h4>
						<h4 style="text-align: right">${pageContext.request.userPrincipal.name}</h4>
					</div>
					
					<div class="searchForm">
						<div class="labelForSearch">
							<label for="inputNameForSearch"><spring:message code='home.input_name_for_search'/></label>						
						</div>
						<input type="text" id="inputNameForSearch" onkeyup="searchApplicant()" placeholder=<spring:message code='home.placeholder_search'/> class="addForm">
					</div>						
					<br>							
					<table id="listOfApplicants">
						<tr>
							<th><spring:message code='home.column_faculty'/></th>
							<th><spring:message code='home.column_first_name'/></th>
						    <th><spring:message code='home.column_last_name'/></th>
						    <th><spring:message code='home.column_date_of_birth'/></th>
						    <th><spring:message code='home.column_email'/></th>
						    <th><spring:message code='home.column_phone'/></th>
						    <th><spring:message code='home.column_avgmark'/></th>
						    <th><spring:message code='home.column_verified'/></th>	
						    <th>					    
						</tr>
						<c:forEach items="${applicants}" var="curApplicant">
							<tr>
								<td><a href="update?id= ${curApplicant.id}">${curApplicant.facultyName}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.firstName}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.lastName}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.dateOfBirth}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.email}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.phone}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.average}</a></td>
						    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.verified}</a></td>
						    	<td class="tdButton">									
									<div class="smallButton">
										<a href="delete?id= ${curApplicant.id}"><spring:message code='home.button_delete'/></a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>				
				</div>				
			</c:if>			
			
			<c:if test="${empty applicants}">	
				<h4>No registered applicants</h4>
			</c:if>	
					
		</div>		
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="js/home.js"></script>
</body>
</html>