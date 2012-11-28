<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url value="/resources/blueprint/screen.css" var="screen"/>
<spring:url value="/resources/blueprint/ie.css" var="ie"/>
<spring:url value="/resources/blueprint/print.css" var="print"/>
<spring:url value="/resources/blueprint/plugins/fancy-type/screen.css" var="fancyscreen"/>
<spring:url value="/resources/blueprint/plugins/liquid.css" var="liquid"/>
<spring:url value="/resources/jquery/jquery-ui-1.8.16.custom.css" var="jqueryuicss"/>


<spring:url value="/resources/jquery/jquery-1.7.1.min.js" var="jqueryjs"/>
<spring:url value="/resources/jquery/jquery-ui-1.8.16.custom.min.js" var="jqueryui"/>
<spring:url value="/resources/jquery/jquery.json-2.3.js" var="jqueryjson"/>
<spring:url value="/resources/jquery/jquery.form.js" var="jqueryform"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<link rel="stylesheet" href="${screen}" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="${print}" type="text/css" media="print" />
<link rel="stylesheet" href="${fancyscreen}" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="${ie}" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="${jqueryuicss}" type="text/css" />

<script type="text/javascript" src="${jqueryjs}"></script>
<script type="text/javascript" src="${jqueryui}"></script>
<script type="text/javascript" src="${jqueryjson}"></script>
<script type="text/javascript" src="${jqueryform}"></script>

<style type="text/css">
		body, input, select {font-family:Verdana, Arial, Helvetica, sans-serif; }
</style>


