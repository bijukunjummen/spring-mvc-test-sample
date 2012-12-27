<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<spring:url value="/resources/js/jquery-1.7.2.js"  var="jqueryjs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
<spring:url value="/resources/js/jquery-ui-1.8.23.custom.min.js" var="jqueryuijs" />

<spring:url value="/resources/css/standard.css"  var="standard_css" />
<spring:url value="/resources/css/bootstrap-responsive.min.css"  var="bootstrap_responsive_css" />
<spring:url value="/resources/css/bootstrap.min.css"  var="bootstrap_css" />
<spring:url value="/resources/css/smoothness/jquery-ui-1.8.23.custom.css" var="jqueryui_css" />

<link rel="stylesheet" type="text/css" media="screen" href="${bootstrap_responsive_css}"></link>
<link rel="stylesheet" type="text/css" media="screen" href="${bootstrap_css}"></link>
<link rel="stylesheet" type="text/css" media="screen" href="${jqueryui_css}"></link>
<link href="${standard_css}" rel="stylesheet"></link>

<script src="${jqueryjs}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
<script src="${jqueryuijs}" type="text/javascript"><!-- /required for FF3 and Opera --></script>
