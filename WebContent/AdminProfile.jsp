<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page errorPage="SessionExpired.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="Profile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/homepagescripts.js"
	src="js/Home.js"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="50">

	<!-- NAVIGATION BAR STARTS -->
	<%
		String username = (String) session.getAttribute("user");
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="FrontPg.jsp"> <img
				src="Drawing.png" alt="Twitter" height="32" width="32"
				align="middle"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#top"><%=username%></a></li>
				<li><a href="#"><span class="glyphicon glyphicon-envelope "
						data-toggle="modal" data-target="#myModal"></span></a></li>
				<li><a href="#mytweets">TWEETS</a></li>
				<li class="active"><a href="Intermediateservlet"><span
						class="glyphicon glyphicon-home"></span></a></li>

				<li><a href="Signout.jsp">SignOut</a></li>

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
					<h4>
						<span class="glyphicon glyphicon-envelope"></span>NOTIFICATIONS
					</h4>
					<div class="modal-body">
						<div></div>
						<h4>
							Tweets<font color="red"><u><%=session.getAttribute("tweetno")%></u></font><BR>
						</h4>
						<h4>
							Following<a href="Following.jsp"><font color="red"><u><%=session.getAttribute("followingno")%></u></font></a><BR>
						</h4>
						<h4>
							Followers<a href="Following.jsp"><font color="red"><u><%=session.getAttribute("followerno")%></u></font></a>
						</h4>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal ENDS -->
	<!-- NAVIGATION MENU ENDS -->

	<div id="top" class="bg-1">
		<div class="container">
			<div>
				<h3 class="text-center">
					Welcome&nbsp;<font color="red"><%=username%></font>!&nbsp;&nbsp;<a
						href="Intermediateservlet">Home|</a>&nbsp;&nbsp;<a
						href="ModifyJSP.jsp">Update|</a>&nbsp;&nbsp;<a
						href="SureDelete.jsp">Delete|</a>&nbsp;&nbsp;<a href="Signout.jsp">SignOut</a>
				</h3>
				<table class="table table-hover tablefixed">
					<thead>
						<tr>
							<th style="text-align: center">Full Name</th>
							<th style="text-align: center">Email Id</th>
							<th style="text-align: center">Joined Twitter On</th>
						</tr>
					</thead>
					<%
						Iterator itr1;
					%>
					<%
						List data2 = (List) session.getAttribute("data");
						for (itr1 = data2.iterator(); itr1.hasNext();) {
					%>
					<tbody>
						<tr>
							<td><%=itr1.next()%></td>
							<td><%=itr1.next()%></td>
							<td><%=itr1.next()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="mytweets" class="container text-center">
		<h3>Your Tweets</h3>
		<div>
			<style>
.tablefixed {
	table-layout: fixed;
	word-wrap: break-word;
}
</style>
			<table class="table table-hover tablefixed">
				<thead>
					<tr>
						<th hidden="">Tweet ID</th>
						<th style="text-align: center">My Tweets</th>
						<th style="text-align: center">Tweeted On</th>
						<th style="text-align: center">Edit Tweet</th>
						<th style="text-align: center">Delete Tweet</th>
					</tr>
				</thead>
				<tbody>

					<%
						List data55 = (List) session.getAttribute("data22");
						for (int i = 0; i < data55.size(); i = i + 3) {
					%>
					<tr>
						<td hidden=""><%=data55.get(i)%></td>
						<td><%=data55.get(i + 1)%></td>
						<td><%=data55.get(i + 2)%></td>
						<td><a href="EditTweetJSP.jsp?id=<%=data55.get(i)%>">Edit</a></td>
						<td><a href="DeleteTweetServlet?id=<%=data55.get(i)%>">Delete</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
	<!-- Footer -->
	<%@ include file="Footer.jsp"%>

</body>
</html>