<html>
<%
String seletedPerson = request.getParameter("selectedPerson");
String circleName = request.getParameter("circleName");
System.out.println(seletedPerson + circleName);
int id = Integer.parseInt(""+request.getParameter("userId"));
System.out.println("Login: "+id);
String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces"; 
String mysUserID = "root"; 
String mysPassword = "626262";
java.sql.Connection conn=null;
%>
<script type="text/javascript">
function Foo()
{
    alert("Delete "+<%=seletedPerson%>+" from "+  <%=circleName%>);
    <%
    try {
      	Class.forName(mysJDBCDriver).newInstance();
  		java.util.Properties sysprops=System.getProperties();
  		sysprops.put("user",mysUserID);
  		sysprops.put("password",mysPassword);

  //connect to the database
  		conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
  		System.out.println("Connected successfully to database using JConnect");

  		
  		java.sql.Statement stmt1=conn.createStatement();
  		java.sql.ResultSet rs = stmt1.executeQuery("select Circle_Id from circle where Circle_NAME = '"+circleName+"'");
  		if(rs.next()){
  			int cid =rs.getInt(1);  		
  			java.sql.ResultSet rs1 = stmt1.executeQuery("select u.User_Id from user u, person p where p.First_Name = '"+seletedPerson+"' and p.SSN = u.SSN");
  			if(rs1.next()){
  			int pid =rs1.getInt(1);
  			int i = stmt1.executeUpdate("Delete from AddedTo Where Circle_Id= '" + cid+ "' and User_Id = '" + pid+ "'");
  			System.out.println("Delete from AddedTo Where Circle_Id= '" + cid+ "' and User_Id = '" + pid+ "'");
  			}
  		}
  }catch(Exception e)
  {
  e.printStackTrace();
  }
  finally{
  try{conn.close();}catch(Exception ee){};
  }
    %>
}
</script>

<p>
Are you sure to delete <%=seletedPerson%> from <%=circleName%>?</p>
<p><a onclick="javascript:Foo(); return false;"  href="my circles.jsp"><font color="Blue">Delete</font></a>
<a href="my circles.jsp"><font color="Blue">Back</font></a></p></html>