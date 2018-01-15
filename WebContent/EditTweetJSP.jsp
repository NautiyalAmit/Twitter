<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Tweet JSP</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/BackButtonDisable.js"></script>
   <script type="text/javascript" src="js/homepagescripts.js" src="js/Home.js"></script>
   <script type="text/javascript" src="js/LoginValidation.js" ></script>
</head>
<body>
	<a name="top"></a>
	
	<!-- header part of the page  -->
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
  
	<!-- header part of the page  -->
		<form action="EditTweetServlet" method="post"onsubmit="return tweet(form);" >
			
		
	<!-- on submit of the page the action goes to this servlet  -->		
					 <textarea class="form-control" rows="4" id="modifytweet"  name="modifytweet"
						placeholder="Compose a new tweet" maxlength=140 minlength=0
						onkeyup="LimtCharacters(this,140,'lblcount');"></textarea>
<br>
   <label for="characters">Number of Characters left:</label>&nbsp
   <label id="lblcount">140</label>&nbsp;&nbsp;&nbsp
  
  
	
	<!-- fetches id and then sets tweet for that id  -->				
					<%
						String TweetID = request.getParameter("id");
						session.setAttribute("tweetID", TweetID);
					%>
					
					
			 <input type="submit" value="Tweet" class="btn" id="textarea1"
				onkeyup="LimtCharacters(this,140,'lblcount')"	onclick="reload();">		
				
	
		</form>
</div></div><%@ include file = "Footer.jsp" %>
</body>

</html>




