<%@ taglib uri="/WEB-INF/mytags.tld" prefix="h" %>
<%@ page errorPage="/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <script>
 </script>
</head>
<body>
	 <c:if test=" ${(username) } "></c:if>
			<h:header user=""/>
	
	
	<c:forEach var="comment" items="${commnets}">
		<div style="width:400px"><h3>${comment.text}</h3>
			<span style="float: right;"> - ${comment.u_id}</span>
		</div>
	</c:forEach>
	<form action="http://localhost:8080/BloggingApp/addCommentsServlet" method="post">
		Comment : <input type="text" name="cmnt">
		<input type="submit" value="Add Comment"/>
	</form>
	
</body>
</html>