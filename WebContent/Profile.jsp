<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="Profile.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
  <style>
.tablefixed{
   table-layout: fixed;
   word-wrap: break-word;
  }
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<!-- NAVIGATION MENU STARTS -->
<%
			String searchname = (String) session.getAttribute("following");
			String button_action = (String) session.getAttribute("result");
		%>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="FrontPg.jsp"> <img src="Drawing.png" alt="Twitter" height="32" width="32" align="middle"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
    
        <li><a href="#top"><%=searchname%></a></li>
       
        <li><a href="#notifications">NOTIFICATIONS</a></li>
        <li><a href="#mytweets">TWEETS</a></li>
        <li><a href="Intermediateservlet">HOME</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Signout.jsp">SignOut</a></li>
          </ul></li></ul>
        </div>
  </div>
</nav>

<!-- NAVIGATION MENU ENDS -->
		
	<div id="top" class="container text-center">	
		<table class="table table-condensed tablefixed"><thead>
			<tr>
				<th style="text-align:center">Full Name</th>
				<th style="text-align:center">Email Id</th>
				<th style="text-align:center">Joined Twitter On</th></tr>
			<%
				Iterator itr;
			%>
			<%
				List data = (List) session.getAttribute("data");
				for (itr = data.iterator(); itr.hasNext();) {
			%>
			<tr>
				<td><%=itr.next()%></td>
				<td><%=itr.next()%></td>
				<td><%=itr.next()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
			<div id="notifications" class="bg-1">
  <div class="container">
    <h3 class="text-center">NOTIFICATIONS</h3>
    <ul class="list-group">
      <li class="list-group-item">TWEETS >> <span class="label label-danger"> <u><%=session.getAttribute("tweetno1")%></u></span></li>
      <li class="list-group-item">FOLLOWING >> <span class="label label-danger"><u><%=session.getAttribute("followingno1")%></u></span></li> 
      <li class="list-group-item">FOLLOWERS >> <span class="label label-danger"><u><%=session.getAttribute("followerno1")%></u></span></li> 
    </ul>
    <%
				if (button_action.equals("follow")) {
			%>
			<form action="Follow" method="post">
				<div >
					<input type="submit" value="Follow" class="btn btn-primary" id="hide">
				</div>
			</form>
			<%
				} else {
			%>
			<form action="Unfollow" method="post">
				<div >
					<input type="submit" value="UnFollow" class="btn btn-primary" id="show">
				
				</div></form>	<%
				}
			%>
  </div> </div>
		<div id="mytweets" class="container text-center">
  <div >
				<h3>Tweets</h3>
			</div>
			<div>
				<table class="table table-hover tablefixed">
				<thead>	<tr>
						<th style="text-align:center">Username</th>
						<th style="text-align:center">My Tweets</th>
						<th style="text-align:center">Tweeted On</th>
					</tr></thead><tbody>
					<%
						Iterator itr1;
					%>
					<%
						List data1 = (List) session.getAttribute("data11");
						for (itr1 = data1.iterator(); itr1.hasNext();) {
					%>
					<tr>
						<td><%=itr1.next()%>&nbsp;&nbsp;&nbsp;</td>
						<td><%=itr1.next()%>&nbsp;&nbsp;&nbsp;</td>
						<td><%=itr1.next()%></td>
					</tr>
					<%
						}
					%></tbody>
				</table>
			</div></div>
	<!-- Footer -->
  <footer class="container-fluid text-center">			
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>All Rights Reserved <a data-toggle="tooltip" href="Home.jsp">www.twitterclone.com</a></p> 
</footer>		
 <script>
  $(function() {
	 $('a[href*=#]:not([href=#])').click(function() {
	   if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
	     var target = $(this.hash);
	     target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
	     if (target.length) {
	       $('html,body').animate({
	         scrollTop: target.offset().top
	       }, 900);
	       return false;
	     }
	   }
	 });
	});
  </script>		
</body>
</html>