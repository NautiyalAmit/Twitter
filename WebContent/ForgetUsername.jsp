<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Security Check</TITLE>
<script type='text/javascript' src="js/ForgetUsernameValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</HEAD>
<BODY>

<!-- NAVIGATION BAR STARTS -->
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
<!-- NAVIGATION BAR ENDS -->

<div class="container"> 
  <div class="jumbotron">
					<h3><a href="NeedHelp.jsp">Back</a></h3>
				<div><label>	To recover your username, enter your details you used to sign in to
					 Twitter Clone</label></div>
			<form action="ForgetUsernameServlet" onsubmit='return formValidator()'>
					<label>	Security Check</label><br>
							<label>FullName<font color=red><sup>*</sup></font></label>
							<INPUT type="text"class="form-control" id="fullcheck" name="fullcheck"
								placeholder="Enter fullname">
							<label>Security Question:<font color=red><sup>*</sup></font></label>
						
							<label><b>Your Home-Town?</b></label><br>
						
							<label>Answer<font color=red><sup>*</sup></font></label>
						
							<INPUT type="text" class="form-control"id="anscheck" name="anscheck"
								placeholder="Enter answer">
						
							<b>E-Mail Address<font color=red><sup>*</sup></font></b>
						
							<input type="text" class="form-control" id="emailcheck" name="emailcheck"
								placeholder="Enter email"><br>
							<input type="submit" value="Submit" class="btn btn-danger">
			</form>
		</div>
  </div>	
  <!-- FOOTER -->
  <%@ include file = "Footer.jsp" %>
</BODY>
</HTML>