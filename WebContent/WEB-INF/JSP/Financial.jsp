<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/financien.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="Input">
		<form action="FinancialServlet" method="post">
			<h2>New Input</h2>
			NAME <input type="text" name="name" value="PERSON X"><br /> <br />
			VALUE <input type="text" name="value" value="500"> <br /> <br />
			DATE <input type="text" name="date" value="2013-01-01"> <br />
			<br /> PROJECT <input type="text" name="PROJECT" value="OPDRACHT X">
			<br /> <br /> <input type="submit" value="ADD TO LIST" />
			<p>${succes}</p>
		</form>
	</div>

	<div class="main">

		<div class="logo">
			<a href="LennertServlet"> <img alt="logo" src="pics/fbs_logo.png">
			</a>
		</div>

		<form action="FinancialServlet" method="get">
			<input type="submit" value="GIV' DATA" />
			<p>${fin.result}</p>
		</form>
	</div>

</body>
</html>