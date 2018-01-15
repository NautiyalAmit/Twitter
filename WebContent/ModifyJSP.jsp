<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="w3.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/BackButtonDisable.js"></script>
<script type='text/javascript' src="js/Modify.js">
</script>
<title>Modify your account</title>
</head>
<body>
<!-- NAVIGATION MENU STARTS -->
	<a name="top"></a>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="FrontPg.jsp"> <img src="Drawing.png"
				alt="Twitter" height="32" width="32" align="middle"></a>
		</div>
		<div>
			<ul class="nav navbar-nav">

				<li class="active"><a href="Intermediateservlet"><span
						class="glyphicon glyphicon-home"></span></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- NAVIGATION MENU ENDS -->
	<div class="container">
		<div class="jumbotron">
			<h2>Modify My Account</h2>
			<h3>
				<a href="Intermediateservlet">Home|</a>&nbsp;&nbsp;<a
					href="Profile_Admin_Servlet">Profile</a>
			</h3>

			<label>Change your FullName here...</label>

			<form action="ModifyServlet" onsubmit='return isFullname()'
				method="post">

				<label>Full Name</label>
				<INPUT type="text"class="form-control" id="fullname1" name="fullname1"
					placeholder="Enter fullname">&nbsp;&nbsp;<INPUT
					type="submit" name="fullname_edit" value="Update">
					<br>
					<label>Change your Password Here...</label></form>

				<form action="ModifyServlet" onsubmit='return isValid()'
					method="post">

					<label>Old Password</label> <INPUT type="password" class="form-control"name="passwordold"
						placeholder="Enter password"> 
						<label>Password</label> <INPUT
						type="password" class="form-control"id="password1" name="password1"
						placeholder="Enter password">
						 <label>Confirm Password</label> 
						 <INPUT type="password"class="form-control" id="c_password1" placeholder="Confirm password"
						name="c_password1">&nbsp;&nbsp;
						<INPUT type="submit" name="password_edit" value="Update">
				</form>

				<label>Change your Email Address Here...</label>
				<form action="ModifyServlet" onsubmit='return isEmail()'
					method="post">

					<label>E-Mail</label> 
					<INPUT type="text" id="email1" placeholder="Enter email"class="form-control" name="email1">&nbsp;&nbsp;
					<INPUT type="submit" name="email_edit" value="Update">
				</form>
				<form action="Profile_Admin_Servlet">
					<INPUT type="submit" value="Go to My Profile">
				</form>
		</div>
	</div>  	<%@ include file = "Footer.jsp" %>
</BODY>
</HTML>
