<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Home</title>
<body>
	<form action="profile" style="float: left">
		<input type="submit" value="Profile">
	</form>
	<form action="findfriends">
		<input type="submit" value="Find Friends">
	</form>

	<h2>Welcome back, ${firstName}!</h2>

	<div>
		<form action="post" method="post">
			<textarea name="text" id="textarea" rows="1" cols="60"
				style="overflow: auto">What's on your mind </textarea>
			<input type="submit" value="Post" />
		</form>
	</div>

	<ul>
		<c:forEach var="listValue" items="${postList}">
			<br>
			<li>${listValue}</li>
		</c:forEach>
	</ul>




	<br>
</body>
</html>