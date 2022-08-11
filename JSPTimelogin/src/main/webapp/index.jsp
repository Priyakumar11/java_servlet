<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String name=request.getParameter("username");
java.util.Date d=new java.util.Date();
int hr=d.getHours();
int minutes = d.getMinutes();
int seconds = d.getSeconds();
out.println("welcome  " + name +" login time: "+ hr+"." + minutes+"." + seconds);
%>
</body>
</html>