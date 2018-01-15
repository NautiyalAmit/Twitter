<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.servlet.InsertServlet"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Sign up</title>
<script type='text/javascript' src="js/SignupValidation.js"></script>
</HEAD>
<BODY>
<a name="top"></a>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
      <a class="navbar-brand" href="FrontPg.jsp"> <img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active" ><a href="Signup.jsp">Sign Up</a></li>
        </ul>
    </div>
  </div>
</nav>
<div class="container">
  <div class="jumbotron">
  <h2 class="text-primary">New to Twitter? Sign Up.</h2>
		<div>
			<div>
				<h3>
					<a href="Login.jsp">Or Sign In</a>
				</h3>
			</div>
		<form action="UserIDCheckServlet" method="post">
				<div class="form-group">
					<label for="fullname">Check If UserName Exists!</label>
						<div>
							<b>UserName<font color=red><sup>*</sup></font> <br> 
							</b>
						</div>
				</div>
						<div class="form-group">
							<INPUT type="text" name="username" id="user">
								<input type="submit" value="Search" class="btn btn-danger">
						</div>
		</form>	</div>
		
			<form action="InsertServlet" onsubmit='return formValidator();'>
				<fieldset>
					<legend>
						<b>Enter Your Details</b>
					</legend>
					
						<div class="form-group">
							<b>UserName<font color=red><sup>*</sup></font> <br> 
							</b>
						</div>
						<div class="form-group">
							<INPUT type="text" id="username" name="username"
								placeholder="Enter username">
						</div>
						<div class="form-group">
							<b>Full Name<font color=red><sup>*</sup></font></b>
						</div>
						<div class="form-group">
							<INPUT type="text" id="fullname" name="fullname"
								placeholder="Enter fullname">
						</div>
						<div class="form-group">
							<b>Password<font color=red><sup>*</sup></font></b>
						</div>
						<div class="form-group">
							<INPUT type="password" id="password" name="password"
								placeholder="Enter password">
						</div>
						<div class="form-group">
							<b>Confirm password<font color=red><sup>*</sup></font></b>
						</div>
						<div class="form-group" >
							<INPUT type="password" id="confirm_password"
								placeholder="Confirm your password">
						</div>
						<div class="form-group">
							<b>Security Question<font color=red><sup>*</sup></font></b>
						</div>
						<div class="form-group">
							<label><b>Your Home-Town?</b></label><br>
							<label>Answer<font color=red><sup>*</sup></font></label>
						<div class="form-group">
							<INPUT type="text" id="anscheck" name="anscheck"
								placeholder="Enter your answer">
						</div>
						</div>
						<div class="form-group">
							<label>E-Mail<font color=red><sup>*</sup></font></label>
							<div>
							<INPUT type="text" id="email" name="email"
								placeholder="Enter email">
							</div>
						</div>
					<br> 
					<div class="r4">
						<INPUT type="checkbox" id="i_agree" name="i_agree"><b>I
							agree to the terms and conditions</b>
					</div>
					<div>
						<div>&nbsp;&nbsp;</div>
						<div>
							<input type="submit" value="Signup" class="btn btn-primary">
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		</div>
	<%@ include file = "Footer.jsp" %>
</BODY>
</HTML>