<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
  <title>Twitter.com</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="FrontPg.css">
</head>
<body>  
<nav class="navbar navbar-inverse">
  <main class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="FrontPg.jsp"><img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active" ><a href="Signup.jsp">Sign Up</a></li>
        </ul>
    </div>
  </div>
</nav><div class="container">
<div class="container-fluid"> 
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="Pictures/warsaw-1017468_1280.jpg" alt="Warsaw">
        <div class="carousel-caption">
        <p><a class="btn btn-primary btn-lg" href="Signup.jsp" role="button">Sign up </a> <a class="btn btn-lg btn-primary" href="Login.jsp" role="button">Sign in </a></p>
          
          <h1>Welcome To Twitter</h1>
         <h3><p>Connect with your friends - and other fascinating people</p></h3>
        </div>      
      </div>
      
      <div class="item">
      
        <img src="Pictures/earth-1001826_1280.jpg" alt="Earth">
        <div class="carousel-caption">
        <p><a class="btn btn-primary btn-lg" href="Signup.jsp" role="button">Sign up </a> <a class="btn btn-lg btn-primary" href="Login.jsp" role="button">Sign in </a></p>
          <h1>Make new friends on Twitter</h1>
          <h3><p>Get in-the-moment updates on things that interest you</p></h3>
        </div>      
        
      </div>
    
      <div class="item">
      
        <img src= "Pictures/dreamcatcher-1030769_1280.jpg" alt="Dreamcatcher">
        <div class="carousel-caption">
        <p><a class="btn btn-primary btn-lg" href="Signup.jsp" role="button">Sign up </a> <a class="btn btn-lg btn-primary" href="Login.jsp" role="button"> Sign in </a></p>
          <h1>Get started and create a buzz</h1>
         <h3><p>Connect with your friends - and other fascinating people</p></h3>
        </div>      
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</div>
</div>
<footer class="container-fluid text-center">			<!-- Footer -->
  <a href="#top" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>All Rights Reserved <a href="FrontPg.jsp">www.twitterclone.com</a></p> 
</footer>

</body>
</html>