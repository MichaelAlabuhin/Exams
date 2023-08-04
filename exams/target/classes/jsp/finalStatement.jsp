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
			
			<div class="titleOfPage">
				<h4><spring:message code='home.menu_final_statement'/></h4>
				<h4 style="text-align: right">${pageContext.request.userPrincipal.name}</h4>
			</div>
			
			<c:choose>		
				<c:when test="${mode == 'CHOOSE_FACULTY'}">				
					<c:if test="${not empty faculties}">
						<br>					
						<p><spring:message code='statement.choose_faculty'/></p>								
						<table class="report">
							<c:forEach items="${faculties}" var="currentFaculty">
								<tr>
									<td>
										<a href="generateStatement?id= ${currentFaculty.id}">${currentFaculty.name}</a>									
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</c:when>
				
				<c:when test="${mode == 'GENERATE_STATEMENT'}">				
					<c:if test="${not empty applicants}">
						<br>						
						<div class="report">						
							<div class="titleReport">
								<div>
									<h4><spring:message code='statement.title_faculty'/> ${faculty.getName()}</h4>
								</div>
								<div>
									<h4><spring:message code='statement.title_capacity'/> ${faculty.getSeatCapacity()}</h4>
								</div>						
							</div>													
							<table>
								<tr>
									<th><spring:message code='home.column_first_name'/></th>
								    <th><spring:message code='home.column_last_name'/></th>
								    <th><spring:message code='home.column_avgmark'/></th>
								    <th><spring:message code='statement.column_status'/></th>			    
								</tr>
								<c:forEach items="${applicants}" var="curApplicant">
									<c:if test="${curApplicant.status.charAt(0) eq 'E'.charAt(0) }">
										<tr>										
									    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.firstName}</a></td>
									    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.lastName}</a></td>
									    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.average}</a></td>
									    	<td><a href="update?id= ${curApplicant.id}">${curApplicant.status}</a></td>
									   	</tr>
									</c:if>
									<c:if test="${curApplicant.status.charAt(0) eq 'R'.charAt(0) }">
										<tr>										
									    	<td><a class="rejected" href="update?id= ${curApplicant.id}">${curApplicant.firstName}</a></td>
									    	<td><a class="rejected" href="update?id= ${curApplicant.id}">${curApplicant.lastName}</a></td>
									    	<td><a class="rejected" href="update?id= ${curApplicant.id}">${curApplicant.average}</a></td>
									    	<td ><a class="rejected" href="update?id= ${curApplicant.id}">${curApplicant.status}</a></td>
									   	</tr>
									</c:if>
								</c:forEach>
							</table>											
						</div>
					</c:if>	
					<c:if test="${empty applicants}">	
						<br>
						<h4><spring:message code='statement.no_applicants'/></h4>
					</c:if>						
				</c:when>			
			</c:choose>		
		</div>		
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="js/home.js"></script>
</body>
</html>