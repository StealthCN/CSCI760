<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <script type="text/javascript">
 </script>
<title>Home</title>
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
 <a href="Main.jsp"><span itemprop="name">LifePieces</span></a>
 </div>
 </td>
 <td style="white-space:nowrap;text-align:right; vertical-align:bottom;">
 </tr>
 </table>
</div>
<div id="mt" class="gtb"> 
<a href="Main.jsp" class="tab">Home</a>
 
 <a href="message.html" class="tab ">Send Message</a>
 
 <a href="viewMessages.html" class="tab active">View Message</a>
 
 <a href="post.html" class="tab">Write Post</a>
 
  <a href="CreateCicle.html" class="tab">Create Circle</a>
  
   <a href="my circles.jsp" class="tab">My Circles</a>
 
 <a href="ViewCircle.jsp" class="tab">View Circles</a>
 
 <a href="Profile.jsp" class="tab">Profile</a>

 <div class=gtbc></div>
</div>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 </tr>
</table>
</head>

</head>
 
     
     
 <label for="textfield"></label>
 <form name="form1" method="post" action="">
   <p>
     <%
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
				java.sql.ResultSet rs = stmt1.executeQuery(" select * from message");
				int id = 0;
				String actionType = null;
				while (rs.next())
				{
					%>
					</p>
					</form>	   				
					<p><span style="font-size: 14pt"><%=rs.getString(2)%></span>
					<span style="font-size: 14pt"><%=rs.getString(3)%></span></p>
					<p><span style="font-size: 14pt"><%=rs.getString(4)%></span></p>
					<form name="<%=id%>" method="post" action="">
					<%
					id = rs.getInt(5);
					java.sql.ResultSet rs1 = stmt2.executeQuery(" select p.First_Name from user u, person p where u.SSN = p.SSN and u.User_Id = '"+id+"'");
						if (rs1.next())
						{
						%>
						<p><span style="font-size: 10pt"><%=rs1.getString(1)%></span></p>
						<%
						}
					%>
					</form>
					<hr>
					<p><br/>
					<%
				}
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				try{conn.close();}catch(Exception ee){};
			}
%>
   </div>
   <p>&nbsp;</p>
</html>


