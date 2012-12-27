<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util" %>


<spring:url value="/resources/j_spring_security_check" var="form_url" />
<div class="row-fluid">
	<div class="span9">
		<c:if test="${not empty param.login_error}">
			<div class="alert alert-error">
				Your login failed. Please try again..<br /> 
			</div>
		</c:if>
	</div>
</div>
<div class="row-fluid">
  	<div class="span9">  	
		<form:form action="${form_url}" method="POST" class="form-horizontal">
        <fieldset>		
			<label for="username"><spring:message code="login.username" /> </label> <input type="text" name="j_username"/>
			<label for="password"><spring:message code="login.password" /> </label> <input type="password" name="j_password"/>
			<input type="submit" class="btn btn-primary"/>
		</fieldset>
		</form:form>
	</div>
</div>
