<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.bean.UserBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <script type='text/javascript' src="js/PasswordValidation.js"></script>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Password recovery</title>


</head>
<body>
<a name="top"></a>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
      <a class="navbar-brand" href="Login.jsp"> <img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
      
        <li class="active" ><a href="Login.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
        <li><a href="Signup.jsp">Sign Up</a></li>
        </ul>
    </div>
  </div>
</nav>

<div class="container"> 
  <div class="jumbotron">

	<%
		UserBean bean = (UserBean) session.getAttribute("bean");
	%>


		<form action="PasswordResetServlet" method="post">
			
					<h2>Now,you can reset your Password</h2>
				
			
					
					 
				<div class="form-group">
					
							 <label for="text"><b>UserName</b></label>&nbsp;
						
							<b><%=bean.getUser_id()%></b>
					</div>	
			<div class="form-group">			 <label for="pwd">	<b> Recovery Password</b></label><font color=red><sup>*</sup></font>
						
							<INPUT type="password" class="form-control"id="password" name="password"
								placeholder="Enter password">
				</div>		
		<div class="form-group">				 <label for="pwd">	<b>Confirm password</b></label><font color=red><sup>*</sup></font>
						
						
							<INPUT type="password" class="form-control"id="confirm_password"
								placeholder="Confirm your password">
					
						&nbsp;&nbsp;</div>
							<input type="submit" value="Reset" class="button">
							</form>
						</div>
					</div>
					
		
		<%@ include file = "Footer.jsp" %>		
			
</body>
</html>