<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<!--calling scripts and bootstrap files  -->
<script type="text/javascript" src="js/BackButtonDisable.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="w3.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<!--body begins  -->
<body>
	<!-- header part of the page  -->
	<a name="top"></a>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Login.jsp"> <img src="Drawing.png"
				alt="Twitter" height="32" width="32" align="middle"></a>
		</div>
		<div>
			<ul class="nav navbar-nav">

				<li class="active"><a href="Login.jsp"><span
						class="glyphicon glyphicon-home"></span></a></li>
				<li><a href="Signup.jsp">Sign Up</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- header or navigation part gets over  -->
	<div class="container">
		<div class="jumbotron">
			<!--  // div calsses are called for body section -->




			<h2>Sorry,Deletion is not made!</h2>

			<b>Go Back</b>&nbsp; <b><a href="Login.jsp">Return</a></b>



		</div>
	</div>
	<%@ include file="Footer.jsp"%>

</body>
</html>
