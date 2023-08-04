<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New applicant</title>
<link href="css/applicant.css" rel="stylesheet">
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
				<h4><spring:message code='add_applicant.title'/></h4>
				<h4 style="text-align: right">${pageContext.request.userPrincipal.name}</h4>
			</div>
			<c:choose>
				<c:when test="${mode == 'FILL_APPLICANT'}">				
					<form:form method="POST" action="${contextPath}/addApplicant"					
					enctype="multipart/form-data"					
					modelAttribute="applicant">
						<label><spring:message code='home.column_faculty'/></label>
						<input type="text" class="addForm" value="${faculty.getName()}" readonly="readonly"></input>	
						<div class="formOfGroup">
							<div class="formOfFirstName">					
								<label><spring:message code='home.column_first_name'/></label>			
								<input type="text" name="firstName" class="addForm" required="required"></input>
							</div>
							<div class="formOfLastName">						
								<label><spring:message code='home.column_last_name'/></label>			
								<input type="text" name="lastName" class="addForm" required="required"></input>	
							</div>
						</div>											
						<div class="formOfGroup">
							<div class="formOfEmail">
								<label><spring:message code='home.column_email'/></label>			
								<input type="text" name="email" class="addForm" value="${pageContext.request.userPrincipal.name}" required="required"></input>
							</div>
							<div class="formOfPhone">
								<label><spring:message code='home.column_phone'/></label>			
								<input type="text" name="phone" class="addForm"></input>
							</div>
						</div>						
						<div class="formOfBirth">
							<label><spring:message code='home.column_date_of_birth'/></label>
							<br>			
							<input type="text" name="dateOfBirth" class="addForm" autocomplete="off" placeholder="17.03.2002"></input>
						</div>						
						<label><spring:message code='applicant.address'/></label>			
						<input type="text" name="address" class="addForm"></input>	
						<label><spring:message code='add_applicant.select_image'/></label>	
						<input type="file" name="image" class="addForm"/>				
						<input type="hidden" name="faculty_id" value="${faculty.getId()}"></input>						
						
						<button type="submit" value="Submit"><spring:message code='add_applicant.next'/></button>
					</form:form>					
				</c:when>		
						
				<c:when test="${mode == 'CHOOSE_FACULTY'}">				
					<c:if test="${not empty faculties}">
						<br>					
						<p><spring:message code='add_applicant.choose_faculty'/></p>								
						<table>
							<c:forEach items="${faculties}" var="currentFaculty">
								<tr>
									<td>
										<a href="fillApplicant?id= ${currentFaculty.id}">${currentFaculty.name}</a>									
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</c:when>				
				
				<c:when test="${mode == 'ADD_SUBJECTS'}">
					<c:if test="${not empty subjects}">					
						<br>
						<p><spring:message code='add_applicant.enter_marks'/></p>
						<c:forEach items="${subjects}" var="currentSubject">						
							<tr>
								<td>								
									<form:form method="POST" action="${contextPath}/addSubject" modelAttribute="subject">
										<div class="formOfSubject">
											<input type="text" class="addForm" value="${currentSubject.name}" id="subjectName" readonly="readonly"></input>
											<form:input type="hidden" path="name" class="addForm" value="${currentSubject.name}"></form:input>
											<div class="formOfMark">
												<form:input type="number" path="mark" class="addForm" value="${currentSubject.mark}" required="required"></form:input>
											</div>											
											<form:input type="hidden" path="applicant_id" class="addForm" value="${applicant.getId()}"></form:input>												
											<form:input type="hidden" path="faculty_id" class="addForm" value="${currentSubject.faculty_id}"></form:input>
											<button type="submit" value="Submit" class="enterButton"><spring:message code='add_applicant.button_enter'/></button>	
										</div>										
									</form:form>
								</td>
							</tr>
						</c:forEach>
						<div class="formAverageMark">
							<p><spring:message code='applicant.average_mark'/></p>
							<p class="averageMark">${averageMark}</p>						
						</div>						
					</c:if>
					<form:form method="POST" action="${contextPath}/goToHome">
						<button type="submit" value="Submit"><spring:message code='applicant.button_finish'/></button>
					</form:form>
				</c:when>
			
			</c:choose>
			
		</div>		
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	
</body>
</html>