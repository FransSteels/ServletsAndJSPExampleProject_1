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
			<form action="FinancialServlet" method="get">
			<h2> <input type="submit" value="&#8592;">DELETE</h2>
			</form>
			<form action="FinancialServletDelete" method="post">
			NUMBER <input type="text" name="id" value="PROJECT NUMBER"><br /> <br />
			<br /> <br /> <input type="submit" value="DELETE THIS PROJECT" />
			<p>${succes}</p>
		</form>
	</div>

	<div class="main">

		<div class="logo">
			<a href="LennertServlet"> <img alt="logo" src="pics/fbs_logo.png">
			</a>
		</div>

		<form action="FinancialServletDelete" method="get">
			<input type="submit" value="GIV' DATA" />
			<pre>Id	Name	Posted on		Payed on		$	Project
			</pre>
			${fin.result}
		</form>
	</div>

</body>
</html>