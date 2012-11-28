<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div>
	<label for="first_name"> <spring:message code="member.first.name" /> :
	</label>
	<c:out value="${member.first}" />
	<br /> 
	<label for="last_name"> <spring:message code="member.last.name" /> :
	</label>
	<c:out value="${member.last}" />
	<br />
	<spring:url value="/members/${member.id}" var="update_form_url">
		<spring:param name="form" />
	</spring:url>
	<spring:message code="member.edit" var="edit_message" htmlEscape="false" />
	<div>
		<a href="${update_form_url}">${fn:escapeXml(edit_message)}</a>
	</div>

	<spring:url value="/members" var="list_form_url" />
	<spring:message code="member.list" var="list_label" htmlEscape="false" />
	<a href="${list_form_url}">${fn:escapeXml(list_label)}</a>
</div>
