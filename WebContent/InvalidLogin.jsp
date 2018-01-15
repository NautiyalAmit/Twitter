<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid Page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/LoginValidation.js"></script>
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

<form name="loginpage" action="LoginServlet" onsubmit="return validate(this);">

<h2>Sorry,either wrong password or username entered!</h2>
<b>Login</b>
<b>UserName</b>&nbsp;
<INPUT type="text" name="name" class="form-control" placeholder="Enter username">


<b>Password</b>&nbsp;
<INPUT type="password" name="password"class="form-control" placeholder="Enter password" onfocus="validate(this);">



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="Login" class="button">


<b>New User?</b>
<b><a href="Signup.jsp">SignUp</a></b>



</form></div></div>
 	<%@ include file = "Footer.jsp" %>

</body>
</html>
