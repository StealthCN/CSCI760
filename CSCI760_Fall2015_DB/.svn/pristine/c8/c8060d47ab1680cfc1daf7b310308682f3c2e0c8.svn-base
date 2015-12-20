<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Circles</title>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
 <meta name="ROBOTS" content="NOARCHIVE">
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/6833756213928266202/css/core.css">
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/6833756213928266202/css/ph_detail.css" >
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
 
 <a href="message.html" class="tab">Send Message</a>
 
 <a href="viewMessages.jsp" class="tab">View Message</a>
 
 <a href="post.html" class="tab">Write Post</a>
  
   <a href="my circles.jsp" class="tab active">My Circles</a>
 
 <a href="ViewCircle.jsp" class="tab">View Circles</a>
 
 <a href="Profile.jsp" class="tab">Profile</a>

 <div class=gtbc></div>
</div>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 </tr>
</table>
</head>

<h2> Manage Circles </h2>
<p>
  <label>Circle Name: </label>
  &nbsp;
  <label for="circle type"></label>

  <%
  //session.putValue("login", 100100101);
  String uid = request.getParameter("param1");
  System.out.println("Login: "+session.getValue("login"));
  int id = Integer.parseInt(uid);
  session.putValue("login", uid);
  String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
  String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces"; 
  String mysUserID = "root"; 
  String mysPassword = "626262";
  java.sql.Connection conn=null;
  try {
          	Class.forName(mysJDBCDriver).newInstance();
  			java.util.Properties sysprops=System.getProperties();
  			sysprops.put("user",mysUserID);
  			sysprops.put("password",mysPassword);

  	//connect to the database
  			conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
  			System.out.println("Connected successfully to database using JConnect");

  			conn.setAutoCommit(false);
  			java.sql.Statement stmt1=conn.createStatement();
  			java.sql.ResultSet rs = stmt1.executeQuery(" select c.Circle_Name from addedto a, circle c where a.User_Id = '"+id+"' and c.Circle_Id = a.Circle_Id");
  			
  	while (rs.next()){
  		System.out.println("add circle: "+rs.getString(1)+"\t");
  		%>
  		<a href="circle manager.jsp?selectedCircle=<%= rs.getString(1)%>&&userId=<%= id%>"><%=rs.getString(1)%></a>
  		<%
  		System.out.println("finish one loop");
  	}
  }catch(Exception e)
  {
  	e.printStackTrace();
  }
  finally{
  	try{conn.close();}catch(Exception ee){};
  }
  
  %>


<script type="text/javascript">
 function _go(url) { document.location = url; }
</script><script type="text/javascript">
 function cancel() {
	 response.sendRedirect("my circles.html");
 }
 function create(){
	 conn.setAutoCommit(false);
		alert(circleName+"\t"+id+"\t"+ circleType);
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO circle VALUES (?, ?,?,?)");					      
    	stmt.setString(1,  null);    	        	
    	stmt.setString(2,  circleName);
    	stmt.setString(3,  id);
    	stmt.setString(4,  circleType);
        stmt.addBatch();
		       // submit the batch for execution
	    int[] updateCounts = stmt.executeBatch();
	    conn.commit();
	 response.sendRedirect("my circles.html");
 }
</script>

<h2><hr>Create Circle</h2>
<p><label>Circle Name: </label>&nbsp;
  <label for="circle name"></label>
  <input type="text" name="circle name" id="circle name"> </p>
<p>
    <label>Circle Type: </label>&nbsp;
     <label for="circle type"></label>
     
    <label for="typeList2"></label>
    <select name="typeList2" size="1" id="typeList2">
      <option value="Family">Family</option>
      <option value="Friends">Friends</option>
      <option value="Company">Company</option>
      <option value="Group">Group</option>
    </select>
  </p>
  <%String circleName = request.getParameter("circle name");
    String circleType = request.getParameter("typeList2");%>
  <table width="314" border="0">
    <tr>
      <td width="100"><form name="form1" method="post" action="">
        <div align="center">
          <input type="submit" name="button3" id="button3" value="Create" onclick="return create();">
        </div>
      </form></td>
      <td width="100">&nbsp;</td>
      <td width="100">
        <div align="center">
          <input type="button" name="button4" id="button4" value="Cancel" onclick="return cancel();">
        </div>
      </td>
    </tr>
  </table>
  <p>&nbsp;</p>


</body>
</html>


</body>
</html>