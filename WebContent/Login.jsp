<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Welcome to Twitter</title>
<script type="text/javascript" src="js/LoginValidation.js" src="js/BackButtonDisable.js">//validation of username and password	
</script>
</head>
<body>
<a name="top"></a>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
      <a class="navbar-brand" href="FrontPg.jsp"> <img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
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
  		<h2 class="text-primary">Welcome To Twitter</h2><span></span>
			<form action="LoginServlet" onsubmit="return validate(this);" method="post">
				 <div class="form-group">
      <label for="text">UserName:</label>
      <input type="name" class="form-control" name="name" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password"  class="form-control" name="password" placeholder="Enter password">
    </div>
    
    <input type="submit" value="Login" class="btn btn-default">
				<br>
					<div>
						 <label for="text"><a href="Signup.jsp">New User?</a></label>
						
					</div>
						<div>
							 <label for="text"><a href="NeedHelp.jsp">Forgot Password or Username?</a></label>
						
					</div>
			</form>
		</div>
		</div>
		
		<%@ include file = "Footer.jsp" %>
</body>
</html>
