<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <script type="text/javascript">
 </script>
<title>View Circles</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
 <meta name="ROBOTS" content="NOARCHIVE">
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/6833756213928266202/css/core.css">
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/6833756213928266202/css/ph_detail.css" >
 </style>
</head>
<body class="t3">
<script type="text/javascript">
 (function() {
 var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
 ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
 (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
 })();
</script>
<div class="headbg">
 <div id="gaia">
 <span>
 </span>
 </div>
 <div style="height: 1px"></div>
 <table style="padding:0px; margin: 0px 0px 10px 0px; width:100%" cellpadding="0" cellspacing="0"
 itemscope itemtype="http://schema.org/CreativeWork">
 <tr style="height: 58px;">
 <td style="padding-left: 0.5em">
 <div id="pname">
 <a href="Main.jsp"><span itemprop="name">Lifepieces</span></a>
 </div>
 </td>
 <td style="white-space:nowrap;text-align:right; vertical-align:bottom;">
 </tr>
 </table>
</div>
<div id="mt" class="gtb"> 
<a href="Main.jsp" class="tab">Home</a>
 
 <a href="message.html" class="tab ">Send Message</a>
 
 <a href="viewMessages.jsp" class="tab">View Message</a>
 
 <a href="post.html" class="tab">Write Post</a>
  
   <a href="my circles.jsp" class="tab">My Circles</a>
 
 <a href="ViewCircle.jsp" class="tab active">View Circles</a>
 
 <a href="Profile.jsp" class="tab">Profile</a>

 <div class=gtbc></div>
</div>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 </tr>
</table>
</script>
</head>

</script>
</head>
<body>
<%
	String user = (String)session.getAttribute("login");
	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
	String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces"; 
	String mysUserID = "root"; 
	String mysPassword = "626262";

	// code start here
	java.sql.Connection conn=null;
	try 
	{
		Class.forName(mysJDBCDriver).newInstance();
		java.util.Properties sysprops=System.getProperties();
		sysprops.put("user",mysUserID);
		sysprops.put("password",mysPassword); 

		//connect to the database
		conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
		System.out.println("Connected successfully to database using JConnect");
		conn.setAutoCommit(false);
		java.sql.Statement stmt1=conn.createStatement();
		java.sql.Statement stmt2=conn.createStatement();
		java.sql.Statement stmt3=conn.createStatement();
		java.sql.Statement stmt4=conn.createStatement();
		java.sql.ResultSet rs = stmt1.executeQuery(" select * from circle");
		int Circle_Id = 0;
		while (rs.next())
		{
			%>
			<p><br>	   				
			<span style="font-size: 10pt"><strong>Name:</strong><%=rs.getString(2)%>  
			</span><strong>Type:</strong><span style="font-size: 10pt"><%=rs.getString(4)%></span>
  			<%
  			Circle_Id = rs.getInt(1);
			java.sql.ResultSet rs1 = stmt2.executeQuery(" select * from addedto where Circle_Id = '"+Circle_Id+"'");
			int User_Id = 0;
			while (rs1.next())
			{
				User_Id = rs1.getInt(1);
				java.sql.ResultSet rs2 = stmt3.executeQuery(" select * from user where User_Id = '"+User_Id+"'");
				int SSN = 0;
				while (rs2.next())
				{
					SSN = rs1.getInt(1);
					java.sql.ResultSet rs3 = stmt4.executeQuery(" select * from person where SSN = '"+SSN+"'");
					while (rs3.next())
					{
					%>
					<p>
					<span style="font-size: 10pt"><%=rs3.getString(3)%></span>
					<span style="font-size: 10pt"><%=rs3.getString(2)%></span>
					<p/>
					<%
					}
				}
			}
		}
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		try{conn.close();}catch(Exception ee){};
	}
%>
</body>
</html>