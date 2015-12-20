<html>
<h2>Manage Circle <%=request.getParameter("selectedCircle") %></h2>
<body>
<%
  int id = Integer.parseInt(""+request.getParameter("userId"));
  System.out.println("Login: "+id);
  String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
  String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces"; 
  String mysUserID = "root"; 
  String mysPassword = "626262";
  String circleName = request.getParameter("selectedCircle");
  java.sql.Connection conn=null;
  
%>
  
<p><input type="text" name="nameAdded" id="nameAdded" />
  <input type="button" name="button1" id="button1" value="Add" onclick="return add();"/></p>
  <script type="text/javascript">
function add(){
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
		java.sql.Statement stmt2=conn.createStatement();
		java.sql.ResultSet rs = stmt1.executeQuery("select u.User_Id from person p, user u where p.First_Name = '"+<%=request.getParameter("nameAdded")%>+"' and p.SSN = u.SSN");
		java.sql.ResultSet rs2 = stmt2.executeQuery("select Cirle_Id from circle where Circle_Name = '"+circleName+"'");
if (rs.next()){
	System.out.println("add person "+rs.getInt(1)+" to "+rs2.getInt());
	conn.setAutoCommit(false);
	
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO addedto VALUES (?, ? )");					      
   	stmt.setString(1,  rs.getInt(1));    	        	
   	stmt.setString(2,  rs2.getInt());
       stmt.addBatch();
	       // submit the batch for execution
    int[] updateCounts = stmt.executeBatch();
    conn.commit();
	System.out.println("finish one loop");
}

}catch(Exception e)
{
e.printStackTrace();
}
finally{
try{conn.close();}catch(Exception ee){};
}
}
</script>
  <h3>Delete from this Circle</h3>
  <%
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
		java.sql.ResultSet rs = stmt1.executeQuery("select p.First_Name from person p, user u where p.SSN=u.SSN and u.User_Id in (select a.User_Id from addedto a, circle c where c.Circle_NAME= '"+circleName+"' and c.Circle_Id=a.Circle_Id)");
		
while (rs.next()){
	System.out.println("add person: "+rs.getString(1)+"\t");
	%>
  	<a href="comfirm to delete from circle.jsp?userId=<%=id%>&&selectedPerson=<%= rs.getString(1)%>&&circleName=<%= circleName%>"><%=rs.getString(1)%></a>
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
</body>
</html>