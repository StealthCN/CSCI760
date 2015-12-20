<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Friends</title>
</head>
<body>
	<ul>
		<c:forEach var="listValue" items="${userNames}">
			<li>
				<form action="addfriend">
					<input style="border:none" value="${listValue}" name="friend" size="55" readonly/>
					<input type="submit" value="Follow">
				</form> 
			</li>
		</c:forEach>
	</ul>
</body>
</html>