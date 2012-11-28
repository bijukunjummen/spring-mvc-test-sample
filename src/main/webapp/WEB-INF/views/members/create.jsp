<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<spring:url value="/members" var="submitUrl" />
<div>
	<form:form action="${submitUrl}" method="POST" modelAttribute="member">
		<form:errors cssClass="error" delimiter="&lt;p/&gt;" />
		<form:hidden id="_id" path="id" />
		<form:hidden id="_version" path="version" />
		<label for="first_name"> <spring:message code="member.first.name" /> :
		</label>
		<form:input path="first" />
		<form:errors cssClass="error" id="firstname_error_id" path="first" />
		<br />
		<label for="last_name"> <spring:message code="member.last.name" /> :
		</label>
		<form:input path="last" />
		<form:errors cssClass="error" id="lastname_error_id" path="last" />
		<br />

		<div class="submit" id="submit">
			<spring:message code="button_save" var="save_button" htmlEscape="false" />
			<input id="proceed" type="submit" value="${fn:escapeXml(save_button)}" />
		</div>
	</form:form>
</div>
