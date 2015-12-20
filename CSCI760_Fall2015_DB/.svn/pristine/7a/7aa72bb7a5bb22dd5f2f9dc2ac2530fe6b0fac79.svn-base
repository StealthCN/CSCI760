<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Comment</title>
</head>
<body>
<p>
  Add Comment
  </p>
	<form name="form1" method="post" action="AddC.jsp">
  <p>
    <label>
      <textarea name="textarea" id="textarea" cols="110" rows="5"></textarea>
    </label>
  </p>
  <p align="right">
    <input type="submit" name="button" id="button" value="Submit">
    <input type="hidden" name="id" value=<%=request.getParameter("actionType")%>>
    <input type="hidden" name="ur" value=<%=request.getParameter("user")%>>
    <%System.out.println(request.getParameter("user")); 
    System.out.println(request.getParameter("actionType")); %>
  </p>
</form>
</body>
</html>