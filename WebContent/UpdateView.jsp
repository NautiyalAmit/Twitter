<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="com.bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="w3.css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/BackButtonDisable.js"></script>


<title>View details</title>
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
      
        <li class="active" ><a href="Home.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
        </ul>
    </div>
  </div>
</nav>
<div class="container"> 
  <div class="jumbotron">
  	
				<h2>Your Updated Details!</h2>
			
			<%
				UserBean bean = (UserBean) session.getAttribute("bean");
				String username = bean.getUser_id();
			%>
			<table border=2 bordercolor=#99c2ff cellpadding=5 cellspacing=5
				align=center class="tableView">
				<tr>
					<th><font color=red>UserID</font></th>
					<th><font color=red>Name</font></th>
					<th><font color=red>Email</font></th>
					<th><font color=red>Joined</font></th>
				</tr>

				<%
					Iterator itr;
					List data2 = bean.getModifiedUserDetail();
					System.out.println("third time----" + data2);
					for (itr = data2.iterator(); itr.hasNext();) {
				%>

				<tr>
					<td><%=itr.next()%></td>
					<td><%=itr.next()%></td>
					<td><%=itr.next()%></td>
					<td><%=itr.next()%></td>

					<%
						}
					%>
				</tr>
			</table>
			
					<b>Go Back?</b>&nbsp; <b><a href="ModifyJSP.jsp">Return</a></b>
				

			
  </div></div>	<%@ include file = "Footer.jsp" %>

</body>
</html>
