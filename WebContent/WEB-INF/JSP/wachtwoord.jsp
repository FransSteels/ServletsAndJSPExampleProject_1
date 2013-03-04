<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/About.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${fbs_afkorting}</title>
</head>
<body>

	<div class="logo">
		<a href="LennertServlet"> <img alt="/WEB-INF/JSP/fbs.jsp"
			src="pics/fbs_logo.png">
		</a>
	</div>

	<div class="FBS">

		<form action="PassWordServlet" method="post">
			PASSWORD <input type="password" name="pwd">
			<input type="submit" value="TRY" />
		</form>
		<p>${wrong}
		</p>

	</div>

</body>
</html>