<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/Fbs_home.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${fbs_afkorting}</title>
</head>
<body>

		<div class="logo">
	<a href="LennertServlet">
	<img alt="/WEB-INF/JSP/fbs.jsp"src="pics/fbs_logo.png">
	</a>
	</div>
		
	<div class="FBS">
	
		<div class="h1">${fbs_afkorting}</div>
			
		<a href="AboutServlet" class="about"></a>
		<a href="contact.html" class="contact"></a> 
		<a href="woerk.html" class="work"></a>
		<a href="PassWordServlet" class="smiley"></a>
	
	</div>
	
</body>
</html>