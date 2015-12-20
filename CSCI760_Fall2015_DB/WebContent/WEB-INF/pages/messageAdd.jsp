<%@ page import = "java.sql.*" %>
<%


session.putValue("login", 100100101);

String name = request.getParameter("name");
String subject = request.getParameter("subject");
String message = request.getParameter("message");
String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces";
String mysUserID = "root"; 
String mysPassword = "626262";
String ssn;


int senderId = Integer.parseInt(""+session.getValue("login"));

java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
java.util.Date now = new java.util.Date();
String date = format.format(now);

	if (name == null || subject == null || message == null)
		response.sendRedirect("message.html");
    	
	if ((name!=null) &&(subject!=null) && (message!=null))
	{
		if (name.trim().equals("") || subject.trim().equals("") || message.trim().equals(""))
		{
			System.out.println("name || subject || message --> empty");
			response.sendRedirect("message.htm");
		}
		else
		{
			// code start here
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

				

				java.sql.ResultSet rs = stmt1.executeQuery(" select u.User_Id from user u, person p where u.SSN=p.SSN and p.First_Name='"+name+"'");
				
				if (rs.next())
				{
					int receiverId;
					receiverId = rs.getInt("User_Id");
					//System.out.println(recieverId);

					//System.out.println("ReceiverID(Column 1):"+rs.getString(1));
					

					// person exists

					conn.setAutoCommit(false);
					
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO message VALUES (?, ?,?,?,?,? )");					      
		           	stmt.setString(1,  null);    	        	
		           	stmt.setString(2,  date);
		           	stmt.setString(3,  subject);
		           	stmt.setString(4,  message);
		           	stmt.setInt(5,  senderId);
		           	stmt.setInt(6,  receiverId);
		   	        stmt.addBatch();
					       // submit the batch for execution
				    int[] updateCounts = stmt.executeBatch();
				    conn.commit();
					//stmt1.executeUpdate("insert into message values(null,'"+date+"','"+subject+"','"+message+"','"+senderId+"','"+recieverId+"')");
					//System.out.print("insert into message values('"+name+"','"+subject+"','"+message+"','"+recieverId+"','"+senderId+"')");

					response.sendRedirect("message.html");
				}
				else
				{
					response.sendRedirect("messageMistake.jsp");
				}
				rs.close();
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				
				try{conn.close();}catch(Exception ee){};
			}
		}
		System.out.print("ok");
	}
%>