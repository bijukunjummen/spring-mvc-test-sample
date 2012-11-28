<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<c:if test="${not empty flashmessage}">
		<div class="error"><spring:message code="${flashmessage}" /></div>
	</c:if>
</div>

<div>
	<table>
		<thead>
			<tr>
				<th><spring:message code="member.first.name" /></th>
				<th><spring:message code="member.last.name" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${members}" var="member" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td><c:out value="${member.first}" /></td>
				<td><c:out value="${member.last}" /></td>
				<td><spring:url value="/members/${member.id}" var="update_form_url">
						<spring:param name="form" />
					</spring:url> 
					<spring:message code="member.edit" var="edit_message" htmlEscape="false" /> 
					<a href="${update_form_url}">${fn:escapeXml(edit_message)}</a>
				</td>
				<td><spring:url value="/members/${member.id}" var="delete_form_url" /> 
					<form:form action="${delete_form_url}" method="DELETE" id="${course.id}_DELETE_FORM">
						<input name="page" type="hidden" value="${param.page}" />
						<input name="size" type="hidden" value="${param.size}" />
						<spring:message code="member.delete" var="delete_message" htmlEscape="false" />
						<input type="submit" value="${fn:escapeXml(delete_message)}" class="deletelink" />
					</form:form>
				</td>
			</tr>
		</c:forEach>
		<tr>
		</tbody>
	</table>
	<util:pagination maxPages="${maxPages}" page="${param.page}" size="${param.size}"></util:pagination>
</div>

<spring:url var="createUrl" value="/members">
	<spring:param name="form"></spring:param>
</spring:url>
<spring:message code="member.new" var="add_message" htmlEscape="false" />
<div>
	<a href="${createUrl}">${fn:escapeXml(add_message)}</a>
</div>