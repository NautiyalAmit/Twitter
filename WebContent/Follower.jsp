<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Profile.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a name="top"></a>
	<!--naviagtion bar  or header -->
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
<!-- navigation menu gets over -->
<div class="container"> 
  <div class="jumbotron">
	<jsp:useBean id="bean2" class="com.bean.UserBean" scope="application"></jsp:useBean>
	
	<sql:setDataSource var="snapshot1" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3309/test" 
user="root" password="root1"/>
<sql:query dataSource="${snapshot1}" var="result">
select user_id from following where following_id='<jsp:getProperty
							name="bean2" property="user_id"/>'
</sql:query>
<table border="1" width="100%">
		<tr>
			<th>People who are following you:</th>
			
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
			<td><a href="ProfileServlet?id=${row.user_id}"> <c:out value="${row.user_id}"/></a></td>
			</tr>
			</c:forEach>
	</table>
	</div>
</div><%@ include file = "Footer.jsp" %>
</body>
</html>
	