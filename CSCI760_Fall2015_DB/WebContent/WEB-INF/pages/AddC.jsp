<%@ page import = "java.sql.*" %>
<% 
	String id = request.getParameter("id");
	String ur = request.getParameter("ur");
	//System.out.println(session.getAttribute("Post"));

	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
	String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces";
	String mysUserID = "root"; 
	String mysPassword = "626262";
	
	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
	java.util.Date now = new java.util.Date();
	String date = format.format(now);
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
				conn.setAutoCommit(false);
				
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO comment (Date, Content,Post, Author)VALUES (?,?,?,? )");       	
	           	stmt.setString(1,  date);
	           	stmt.setString(2,  request.getParameter("textarea"));
	           	System.out.println(id);
	           	stmt.setInt(3,  Integer.parseInt(id));
	           	System.out.println(ur);
	           	stmt.setInt(4,  Integer.parseInt(ur));
	   	        stmt.addBatch();
				       // submit the batch for execution
			    int[] updateCounts = stmt.executeBatch();
			    conn.commit();
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		
		try{conn.close();}catch(Exception ee){};
	}
	response.sendRedirect("Main.jsp?param1="+ur);
%>