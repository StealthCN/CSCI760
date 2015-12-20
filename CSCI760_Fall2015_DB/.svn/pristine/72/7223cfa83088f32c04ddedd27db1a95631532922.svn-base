<%@ page import = "java.sql.*" %>
<%
String ids = request.getParameter("param1");
int id = Integer.parseInt(ids);
System.out.println(id);
//int id = 900007;

	
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
		
		PreparedStatement pst = conn.prepareStatement("delete from comment where Comment_Id ='"+id+"'");
		pst.executeUpdate();
		conn.commit();
			stmt1.close();
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		try
		{
			conn.close();
		}catch(Exception ee){};
	}
	response.sendRedirect("Main.jsp");
%>