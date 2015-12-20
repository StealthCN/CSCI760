<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Life Pieces</title>
</head>
</head>
<body>
<body bgcolor="white">
	<br />
	<div align="center">
		<img src="<c:url value="/resources/img/main.png"/>" />
	</div>

	<div align="center">
		<form action="login" method="post">
			<table>
				<tr>
					<td>User ID :</td>
					<td><input type="text" name="userName" value="${userName}" /></td>
					<td>Password:</td>
					<td><input type="password" name="password" value="${password}" /></td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" value="Submit" />
			</div>
		</form>
	</div>

	<br />

	<div align="center">
		<form action="reg">
			<div align="center">
				<input type="submit" value="New User" />
			</div>
		</form>
	</div>
</body>
</html>