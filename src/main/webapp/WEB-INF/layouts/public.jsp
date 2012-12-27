<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util" %>

<spring:url var="resources" value="/resources" />
<spring:message code="app.name" var="appname"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>${appname}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="${resources}/css/standard.css" rel="stylesheet">
    <link href="${resources}/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 50px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <link href="${resources}/css/bootstrap-responsive.css" rel="stylesheet">

    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
  </head>

  <body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#"><spring:message code="app.name"/></a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span9">
          <div class="page-header">
            <h2>My tasks!</h2>
          </div>
        </div>
      </div>
     
      <tiles:insertAttribute name="body"/> 	
     
      <hr>
      <footer>
        <p>&copy; <spring:message code="app.copyright"/></p>
      </footer>

    </div>
  </body>
</html>
