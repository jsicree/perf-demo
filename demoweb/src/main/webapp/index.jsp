<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>    	
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DemoWeb - Home</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/site.css"/>	
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
</head>
<body>
<header>Demo - Home</header>
<hr/>
<p>The home page for the Dynatrace demo project.</p>
<p>This purpose of this application is to provide a set of REST web services that can be analyzed via Dynatrace for performance issues.</p>
<p>This application can be deployed via the AWS CodePipeline.</p>	

<hr/>
<footer>Page Generated: <%= new Date() %></footer>	
</body>
</html>