<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/financien.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facts'n Business Solution</title>
</head>
<body>

	<div class="Input">
			<form action="FinancialServletDelete" method="get">
			<h2> <input type="submit" value="&#8592;">ADD</h2>
			</form>
			<form action="FinancialServlet" method="post">
			NAME <input type="text" name="name" value="PERSON X"><br /> <br />
			VALUE <input type="text" name="value" value="500"> <br /> <br />
			DATE <input type="text" name="date" value="2013-01-01"> <br />
			<br /> PROJECT <input type="text" name="project" value="OPDRACHT X">
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
			<pre>Id	Name	Posted on		Payed on		$	Project
			</pre>
			${fin.result}
		</form>
	</div>

</body>
</html>