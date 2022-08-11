<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
	<form method="get" action="index.jsp">
		Enter Uname:<input type="text" name="user" required><br />
		Enter age:<input type="text" name="pass" required><br />
		<input type="submit" value="check">
	</form>
	
	<%
	String uname = request.getParameter("user");
	String password = request.getParameter("pass");
	if (uname != null && password != null) {
		 StringBuilder input1 = new StringBuilder();
		  
	        // append a string into StringBuilder input1
	        input1.append(uname);
	  
	        // reverse StringBuilder input1
	        input1.reverse();
	        StringBuilder s = input1.append(password); 
	        out.println("password is  " + s.toString()); 
            
			
		
	}
	%>
</body>
</html>