<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant</title>
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
				<h4><spring:message code='applicant.title'/></h4>
				<h4 style="text-align: right">${pageContext.request.userPrincipal.name}</h4>
			</div>
			
			<c:choose>
				<c:when test="${mode == 'UPDATE_APPLICANT'}">								
					<form:form method="POST" action="${contextPath}/updateApplicant" modelAttribute="applicant">
						
						<label><spring:message code='home.column_faculty'/></label>
						<input type="text" class="addForm" value="${faculty.getName()}" readonly="readonly"></input>
						
						<form:input type="hidden" path="id" class="addForm" value="${applicant.getId()}"></form:input>
						<form:input type="hidden" path="average" value="${applicant.getAverage()}"></form:input>
						<form:input type="hidden" path="encodedImage" value="${applicant.getEncodedImage()}"></form:input>
													
						<div class="formOfNameAndPhoto">
							<div>
								<c:if test="${not empty applicant.getEncodedImage()}">
									<img src="data:image/jpg;base64, ${applicant.getEncodedImage()}" alt="Photo" id="profilePhoto">
								</c:if>
								<c:if test="${empty applicant.getEncodedImage()}">
									<img src="images/NoImage.jpeg" alt="Photo" id="profilePhoto">
								</c:if>
							</div>
							<div class="formOfName">
								<div class="formOfFirstName">					
									<form:label path="firstName"><spring:message code='home.column_first_name'/></form:label>			
									<form:input type="text" path="firstName" class="addForm" value="${applicant.getFirstName()}" required="required"></form:input>
								</div>
								<div class="formOfLastName">						
									<form:label path="lastName"><spring:message code='home.column_last_name'/></form:label>			
									<form:input type="text" path="lastName" class="addForm" value="${applicant.getLastName()}" required="required"></form:input>	
								</div>	
							</div>					
							
						</div>											
						<div class="formOfGroup">
							<div class="formOfEmail">
								<form:label path="email"><spring:message code='home.column_email'/></form:label>			
								<form:input type="text" path="email" class="addForm" value="${applicant.getEmail()}" required="required"></form:input>
							</div>
							<div class="formOfPhone">
								<form:label path="phone"><spring:message code='home.column_phone'/></form:label>			
								<form:input type="text" path="phone" class="addForm" value="${applicant.getPhone()}"></form:input>
							</div>
						</div>
						<div class="formOfBirthAndVerified">
							<div class="formOfBirth">
								<form:label path="dateOfBirth"><spring:message code='home.column_date_of_birth'/></form:label>
								<br>			
								<form:input type="text" path="dateOfBirth" class="addForm" autocomplete="off" value="${applicant.getDateOfBirth()}" placeholder="17.03.2002"></form:input>						
							</div>	
							<security:authorize access="hasRole('ROLE_ADMIN')">													
								<div class="formVerified">
			  						<label for="verified"><spring:message code='applicant.verified'/></label>	  						
			  						<form:select  path="verified" id="valueVerified">
										<form:options items="${listOfYesNo}"></form:options>
									</form:select>
								</div>
							</security:authorize>							
						</div>						
						<form:label path="address"><spring:message code='applicant.address'/></form:label>			
						<form:input type="text" path="address" class="addForm" value="${applicant.getAddress()}" required="required"></form:input>						
						<form:input type="hidden" path="faculty_id" class="addForm" value="${faculty.getId()}"></form:input>
						<button type="submit" value="Submit"><spring:message code='applicant.button_update'/></button>
						<button type="cancel" id="buttonCancel" onclick="window.location='/home';return false;"><spring:message code='applicant.button_cancel'/></button>
						
					</form:form>
				</c:when>
				
				<c:when test="${mode == 'UPDATE_SUBJECTS'}">
					<c:if test="${not empty subjects}">	
						<p><spring:message code='applicant.editings_mark'/> ${applicant.getFirstName()} ${applicant.getLastName()}</p>				
						<c:forEach items="${subjects}" var="currentSubject">						
							<tr>
								<td>								
									<form:form method="POST" action="${contextPath}/updateSubject" modelAttribute="subject">
										<div class="formOfSubject">
											<form:input type="hidden" path="id" class="addForm" value="${currentSubject.id}"></form:input>
											<input type="text" class="addForm" value="${currentSubject.name}" id="subjectName" readonly="readonly"></input>
											<form:input type="hidden" path="name" class="addForm" value="${currentSubject.name}"></form:input>
											<div class="formOfMark">
												<form:input type="number" path="mark" class="addForm" value="${currentSubject.mark}" required="required"></form:input>
											</div>											
											<form:input type="hidden" path="applicant_id" class="addForm" value="${currentSubject.applicant_id}"></form:input>												
											<form:input type="hidden" path="faculty_id" class="addForm" value="${currentSubject.faculty_id}"></form:input>
											<button type="submit" value="Submit" class="enterButton"><spring:message code='applicant.button_update'/></button>	
										</div>										
									</form:form>
								</td>
							</tr>
						</c:forEach>
						<div class="formAverageMark">
							<p><spring:message code='applicant.average_mark'/></p>
							<p class="averageMark">${applicant.getAverage().toString()}</p>						
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