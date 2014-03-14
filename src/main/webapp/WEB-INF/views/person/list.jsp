<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

function deleteMember(deleteUrl){
	var form = $('<form/>',{
		action: deleteUrl,
		method: "POST"
	});
	
	form.append($('<input/>',{
		type: 'hidden',
		name: '_method',
		value: 'DELETE'
	}));
	form.append($('<input/>', {
        type: 'hidden',
        name: "page",
        value: "${param['page']}"
    }));

	form.append($('<input/>', {
        type: 'hidden',
        name: "size",
        value: "${param['size']}"
    }));
	
	form.appendTo('body').submit();	
}
</script>
<spring:message code="member.delete" var="delete_message" htmlEscape="false" />
<spring:message code="member.edit" var="edit_message" htmlEscape="false" />
<div class="row-fluid">
	<div class="span1">
	</div>
	<div class="span8">
		<div class="row-fluid">
		<table class="table table-condensed table-bordered">
			<thead>
				<tr>
					<th><spring:message code="member.first.name" /></th>
					<th><spring:message code="member.last.name" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${members.content}" var="member" varStatus="loopStatus">
				<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
					<td><c:out value="${member.first}" /></td>
					<td><c:out value="${member.last}" /></td>
	
					<td><spring:url value="/members/" var="update_form_url">
							<spring:param name="form" />
							<spring:param name="id" value="${member.id}"></spring:param>
						</spring:url> 
						<spring:url value="/members/${member.id}" var="delete_form_url" /> 
						 
						<a href="${update_form_url}">${fn:escapeXml(edit_message)}</a> | <a href="#" onclick="javascript:deleteMember('${delete_form_url}')">${delete_message}</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			</tbody>
		</table>
		</div>
		<div class="row-fluid">
			<util:pagination thispage="${members}"></util:pagination>
		</div>
		<div class="row-fluid">
			<spring:url var="createUrl" value="/members">
				<spring:param name="form"></spring:param>
			</spring:url>
			<spring:message code="member.new" var="add_message" htmlEscape="false" />
			<div>
				<a href="${createUrl}">${fn:escapeXml(add_message)}</a>
			</div>
		</div>
	</div>
</div>

