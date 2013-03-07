<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/About.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fact By Sabrina</title>
</head>
<body>
	<div class="logo">
		<a href="LennertServlet"> <img alt="/WEB-INF/JSP/fbs.jsp"
			src="pics/fbs_logo.png">
		</a>
	</div>

	<div class="FBS">

		<div class="h1">Facts By Sabrina</div>
			<form action="AboutServlet" method="post">
			<input type="submit" name="TSH" value="THE STUDIO" /><input type="submit" name="TSH" value="THE SHOP" />
			</form>
			<p>${text}</p>
	</div>

</body>
</html>