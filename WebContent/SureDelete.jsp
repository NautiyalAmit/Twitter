<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function ConfirmChoice() {
		answer = confirm("Do you really want to delete? If you press cancel you will go to Profile page!");
		if (answer == 1)
		{
			location = "DeleteServlet";
		}
		else
		if (answer == 0)
		{
			location = "AdminProfile.jsp";
		}

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Want to Delete</title>

<script type="text/javascript" src="js/BackButtonDisable.js"></script>
</head><body>
<a name="top"></a>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
      <a class="navbar-brand" href="FrontPg.jsp"> <img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
      
        <li class="active" ><a href="Home.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
        </ul>
    </div>
  </div>
</nav>
<div class="container"> 
  <div class="jumbotron">


			<h2>Are you sure you want to delete?</h2>
			<h3>If so, click on the link below!</h3>
		
					<b>Delete</b>&nbsp;
			
					<b><a href="#" onclick="ConfirmChoice();">Click</a></b>
	  </div>
	  </div>
	  <%@ include file = "Footer.jsp" %>			
	
</body>
</html>
