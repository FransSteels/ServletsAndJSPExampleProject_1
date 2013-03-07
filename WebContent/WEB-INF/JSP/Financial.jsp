<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/financien.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facts'n Business Solution</title>
</head>
<body>

	<div class="Input">

		<form action="FinancialSwitchFunctionServlet" method="get">
			<h2>
				<input type="submit" value="&#8592;">
			</h2>
		</form>

		<c:choose>
			<c:when test="${x == 0}">
				<h2>ADD</h2>
				<form action="FinancialServlet" method="post">
					NAME <input type="text" name="name" value="PERSON X"><br />
					<br /> VALUE <input type="text" name="value" value="500">
					<br /> <br /> DATE <input type="text" name="date"
						value="2013-01-01"> <br /> <br /> PROJECT <input
						type="text" name="project" value="OPDRACHT X"> <br /> <br />
					<input type="submit" value="ADD TO LIST" />
					<p>${succes}</p>
				</form>
			</c:when>
			<c:when test="${x == 1}">
				<h2>DELETE</h2>
				<form action="FinancialServletDelete" method="post">
					NUMBER <input type="text" name="id" value="PROJECT NUMBER"><br />
					<br /> <br /> <br /> <input type="submit"
						value="DELETE THIS PROJECT" />
					<p>${succes}</p>
				</form>
			</c:when>
			<c:when test="${x == 2}">
				<h2>ADD USER</h2>
				<form action="FinancialServletUser" method="post">
					NAME <input type="text" name="name" value="PERSON X"><br />
					<br /> TEL <input type="text" name="tel" value="500">
					<br /> <br /> DATE <input type="text" name="date"
						value="2013-01-01"> <br /> <br /> MAIL <input
						type="text" name="mail" value="OPDRACHT X"> <br /> <br />
					<input type="submit" value="ADD USER" />
					<p>${succes}</p>
				</form>
			</c:when>
			<c:when test="${x == 3}">
				<h2>DEL USER</h2>
				<form action="FinancialServletDelUser" method="post">
					NAME <input type="text" name="name" value="PERSON X"><br />
					<br /><input type="submit" value="DELETE USER" />
					<p>${succes}</p>
				</form>
			</c:when>
		
			<c:when test="${x == 4}">
				<h2>GET DATA</h2>
				<form action="FinancialGetDataServlet" method="post">
					NAME <input type="text" name="name" value="PERSON X"><br />
					<br /><input type="submit" name="getData" value="GET TOTAL AMOUNT" />
					<br /><br /><input type="submit" name="getData" value="GET THIS USER'S DATA" />
					<br /><br /><br /><input type="submit" name="getData" value="GET ALL USER DATA" />
					<p>${succes}</p>
				</form>
			</c:when>

		</c:choose>
	</div>

	<div class="main">

		<div class="logo">
			<a href="LennertServlet"> <img alt="logo" src="pics/fbs_logo.png">
			</a>
		</div>

		<form
			action="<c:if test="${x==0}">FinancialServlet</c:if><c:if test="${x==1}">FinancialServletDelete</c:if><c:if test="${x==2}">FinancialServletUser</c:if><c:if test="${x==3}">FinancialServletDelUser</c:if><c:if test="${x==4}">FinancialGetDataServlet</c:if>"
			method="get">
			<input type="submit" value="GIV' DATA" />
			<pre>Id	Name	Posted on		Payed on		$	Project
			</pre>
			${fin.result}
			${amountPP}
		</form>
	</div>

</body>
</html>