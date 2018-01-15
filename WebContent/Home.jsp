<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.Tweet_Follow_FollowingNoDAO"%>
<%@ page import="java.util.*"%>
<%@ page errorPage="SessionExpired.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="Profile.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/BackButtonDisable.js" src="js/Home.js"></script>
  <script type="text/javascript" src="js/homepagescripts.js" src="js/Home.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%
		String username = (String) session.getAttribute("user");
	%>
<form action="TweetServlet" method="post"onsubmit=" return validate(form)">

<!-- NAVIGATION MENU STARTS -->

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
    
        <li><a href="#myPage">HOME</a></li>
        <li><a href="#tweets">TWEETS</a></li>
        <li><a href="#notifications">NOTIFICATIONS</a></li>
        
        <li><a href="Profile_Admin_Servlet">PROFILE</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Signout.jsp">SignOut</a></li>
          </ul>
        </li>	
        <li>
				
 <li><a href="#"><span class="glyphicon glyphicon-search btn" data-toggle="modal" data-target="#myModal" ></span></a></li>
				
   </ul>
    </div>
  </div>
</nav>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4><span class="glyphicon glyphicon-search"></span>Search</h4>
      </div>
      <div class="modal-body">
       
          <div class="form-group">
            <label for="user">Enter username of your friend. </label>
            <!-- <input type="text" class="form-control" id="user" onkeyup="lookup(this.value)" placeholder="Search";> -->
        <input type="text" class="form-control"  placeholder="Search friends"name="tb" id="textbox1" size="20"
					onkeyup="lookup(this.value);" />
			
			  <div class="suggestionsBox" id="suggestions" style="display: none;">
				<div class="suggestionList" id="autoSuggestionsList"></div>
       </div></div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
          <span class="glyphicon glyphicon-remove"></span> Cancel
        </button>
      </div>
    </div>
  </div>
</div>
<!-- modal ENDS -->

<!-- NAVIGATION MENU ENDS -->

<div class="container">
  <h2>Welcome to Twitter&nbsp;<%=username%></h2>
  <BR>
  <div class="form-group">
  <label for="comment">What's Happening?</label>
  <br>
  <textarea class="form-control" rows="4"  name="tweet"
						placeholder="Compose a new tweet" maxlength=140
						onkeyup="LimtCharacters(this,140,'lblcount');"></textarea>
<br>
   <label for="characters">Number of Characters :</label>&nbsp
   <label id="lblcount">140</label>&nbsp;&nbsp;&nbsp
  
   <input type="submit" value="Tweet" class="btn" id="textarea1"
				onkeyup="LimtCharacters(this,140,'lblcount')" onclick="reload();">
					</div>
</div>

<div id="tweets" class="container text-center">
  <h3>TWEETS</h3>
  <p><em>Your Tweets!</em></p>
  <br>
  <table class="table table-hover tablefixed" >
    <thead>
      <tr>
				<th style="text-align:center">Username</th>
				<th style="text-align:center">Tweets</th>
				<th style="text-align:center">Tweeted On</th>
	</tr>
    </thead>
<tbody>
					<%	Iterator itr;
					%>
					<%
						List data = (List) session.getAttribute("tweetList");
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
		</tbody>
    </table>
</div>
</form>
<!-- Container (notifications Section) -->

<div id="notifications" class="bg-1">
  <div class="container">
    <h3 class="text-center">NOTIFICATIONS</h3>
    <ul class="list-group">
      <li class="list-group-item">TWEETS >> <span class="label label-danger"> <u><%=session.getAttribute("tweetno")%></u></span></li>
      <li class="list-group-item">FOLLOWING >><a href="Following.jsp"> <span class="label label-danger"><u><%=session.getAttribute("followingno")%></u></span></a></li> 
      <li class="list-group-item">FOLLOWERS >><a href="Follower.jsp"> <span class="label label-danger"><u><%=session.getAttribute("followerno")%></u></span></a></li> 
    </ul>
  </div></div>  
  
  <!-- Footer -->
  <footer class="container-fluid text-center">			
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>All Rights Reserved <a data-toggle="tooltip" href="Home.jsp">www.twitterclone.com</a></p> 
</footer>
</body>

</html>