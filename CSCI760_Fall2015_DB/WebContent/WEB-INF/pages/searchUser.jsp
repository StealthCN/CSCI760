<%@ page "java.sql.*"%>
<%
session.putValue("login", 100100101);


String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
String mysURL = "jdbc:mysql://127.0.0.1:3306/lifepieces";
String mysUserID = "root"; 
String mysPassword = "626262";

String name = request.getParameter("name");
java.sql.Connection conn=null;
try {
	Class.forName(mysJDBCDriver).newInstance();
	java.util.Properties sysprops=System.getProperties();
	sysprops.put("user",mysUserID);
	sysprops.put("password",mysPassword);

	//connect to the database
	conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
	//System.out.println("Connected successfully to database using JConnect");
	java.sql.Statement stmt1=conn.createStatement();
	java.sql.ResultSet rs = stmt1.executeQuery(" select * from person where First_Name='"+name+"'");				
		if (rs.next()){
			%>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

			</head>
			<body style="text-align: left">
			                    </span>Search Result 
			<hr>
			<form name="form1" method="post" action="">
			  <label>Name:
			  <%String FN = rs.getString(2);
			  String LN = rs.getString(3);
			  String t = FN+" "+LN;%>
              <input name="textarea2" type="text" id="textarea2" value="<%=t%>" size="20" readonly>
			  </label>
			</form>
			<form name="form2" method="post" action="">
			  <label>Gender:
			    <input name="textfield2" type="text" id="textfield2" value=<%=rs.getString(11)%> readonly>
			  </label>
			</form>
			<form name="form6" method="post" action="">
			  <label>City:
			    <input name="textarea2" type="text" id="textarea2" value="<%=rs.getString(5)%>" size="20" readonly>
			  </label>
			  <label>
			    State:
			    <input name="textfield7" type="text" id="textfield7" value=<%=rs.getString(6) %> readonly>
			  </label>
			  <label>
			    Zip Code:
			    <input name="textfield8" type="text" id="textfield8" value=<%=rs.getString(7) %> readonly>
			  </label>
			</form>
			<p>&nbsp;</p>
			<p align="right">&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<%
			
		}
		else {
			response.sendRedirect("noSuchAPerson.jsp");
		}

	} catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		try{conn.close();}catch(Exception ee){};
	}
%>
