<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<script type="text/javascript">
	var size = ${fn:length(member.addresses)};
	
	function addAddressField(){
		var fieldset = $("<fieldset/>")
		fieldset.append($("<legend/>",{
			html: "Address " + (size + 1) + ":"
		}));
		fieldset.append($('<label/>', {'for':'addressline1',html:'${addressline1}'}));
		fieldset.append($('<input/>',{
			type:'text',
			name:'addresses[' + size + '].line1'
		}));
		fieldset.append($('<label/>', {'for':'addressline2',html:'${addressline2}'}));
		fieldset.append($('<input/>',{
			type:'text',
			name:'addresses[' + size + '].line2'
		}));		

		fieldset.appendTo($('#addresses'));
		size = size + 1;
	}
</script>

<spring:url value="/members" var="submitUrl" />
<spring:message code="member.address.line1" var="addressline1"/>
<spring:message code="member.address.line2" var="addressline2"/>
<spring:message code="member.address.state" var="addressstate"/>

<div class="row-fluid">
  	<div class="span1">
	</div>
  	<div class="span8">
	<form:form action="${submitUrl}" method="PUT" modelAttribute="member" cssClass="form-horizontal">
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
		<a href="#" onclick="javascript:addAddressField()">Add Address</a>
	
		<div id="addresses">
		<c:forEach items="${member.addresses}" var="address" varStatus="status">
			<fieldset>
				<legend>Address ${status.count}</legend>
				<label for="addressline1">${addressline1}</label><form:input path="addresses[${status.count-1}].line1"/>
				<label for="addressline2">${addressline2}</label><form:input path="addresses[${status.count-1}].line2"/>
				<label for="state">${addressstate}</label><form:input path="addresses[${status.count-1}].state"/>
				<form:hidden path="addresses[${status.count-1}].version"/>
				<form:hidden path="addresses[${status.count-1}].id"/>
			</fieldset>		
		</c:forEach>
		</div>
		<div class="submit" id="submit">
			<spring:message code="button_save" var="save_button" htmlEscape="false" />
			<input id="proceed" type="submit" value="${fn:escapeXml(save_button)}" />
		</div>
	</form:form>
</div>
</div>
