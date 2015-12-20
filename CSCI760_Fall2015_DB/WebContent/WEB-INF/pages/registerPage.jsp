<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Your Account</title>
</head>
<body>
<h1>Join Us</h1>
	<form action="regDB" method="post">
		<table>
			<tr>
				<td>First Name: </td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td>
					<select name="gender">
						<option value="F">F</option>
						<option value="M">M</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Birthday: </td>
				<td>
					<select name="month">
						<option value="1">January
						<option value="2">February
						<option value="3">March
						<option value="4">April
						<option value="5">May
						<option value="6">June
						<option value="7">July
						<option value="8">August
						<option value="9">September
						<option value="10">October
						<option value="11">November
						<option value="12">December
					</select>
				</td>
				<td>
					<select name="day">
						<option value="1">1
						<option value="2">2
						<option value="3">3
						<option value="4">4
						<option value="5">5
						<option value="6">6
						<option value="7">7
						<option value="8">8
						<option value="9">9
						<option value="10">10
						<option value="11">11
						<option value="12">12
						<option value="13">13
						<option value="14">14
						<option value="15">15
						<option value="16">16
						<option value="17">17
						<option value="18">18
						<option value="19">19
						<option value="20">20
						<option value="21">21
						<option value="22">22
						<option value="23">23
						<option value="24">24
						<option value="25">25
						<option value="26">26
						<option value="27">27
						<option value="28">28
						<option value="29">29
						<option value="30">30
						<option value="31">31
					</select>
				</td>
				<td>
					<select name="year">
						<option value="1980">1980
						<option value="1981">1981
						<option value="1982">1982
						<option value="1983">1983
						<option value="1984">1984
						<option value="1985">1985
						<option value="1986">1986
						<option value="1987">1987
						<option value="1988">1988
						<option value="1989">1989
						<option value="1990">1990
						<option value="1991">1991
						<option value="1992">1992
						<option value="1993">1993
						<option value="1994">1994
						<option value="1995">1995
						<option value="1996">1996
						<option value="1997">1997
						<option value="1998">1998
						<option value="1999">1999
						<option value="2000">2000
						<option value="2001">2001
						<option value="2002">2002
						<option value="2003">2003
						<option value="2004">2004
						<option value="2005">2005
						<option value="2006">2006
						<option value="2007">2007
						<option value="2008">2008
						<option value="2009">2009
						<option value="2010">2010
						<option value="2011">2011
						<option value="2012">2012
						<option value="2013">2013
						<option value="2014">2014
						<option value="2015">2015
					</select>
				</td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Re-enter Email: </td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>