<%@ page errorPage="/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

 


</head>
<body>
<c:if test=' ${username } '>
			<h:header /></c:if>
<c:forEach var="topic" items="${topics}">
	<a href="getComments?tid=${topic.topicid}">${topic.tname}</a>
	<br/>
</c:forEach>

	<div id="cmntbox" style="display: none"><input type="text" id="cmnt" name="cmnt"><input type="button" value="Enter"></div>
	
	<form action="checkLogin" method="post">
		<input type="submit" id="bt" value="Add Topics"/>
	</form>

	
	
</body>
</html>