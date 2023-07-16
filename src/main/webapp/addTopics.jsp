<%@ page errorPage="/error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>




</head>
<body>
<div class>
		<c:forEach var="topic" items="${topics}">
			<a href="getComments?tid=${topic.topicid}">${topic.tname}</a>
			<br />
		</c:forEach>
</div>
		 
		 




			<div class="container-fluid form-group">
			<form action="http://localhost:8080/BloggingApp/addTopicsServlet"
				method="post">
				Enter Topic Name : <input type="text" name="tname"><br />
				Enter Topic Description :
				<textarea class="form-control" name="desc" rows="3"></textarea>
				<br /> <input type="submit" value="Enter">
			</form>
		</div>
	 


</body>
</html>