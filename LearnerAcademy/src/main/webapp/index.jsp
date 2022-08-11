<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to administrative portal for the Learner Academy</h1>
<p>What you want to do?</p>
<table>
<tr>
	<th>Add Items</th>
	<th>View Items</th>
</tr>
<tr>
	<td><a href="addClasses.html">Add Class</a><br/></td>
	<td><a href="viewClass.jsp">View Classes</a><br/></td>
</tr>
<tr>
	<td><a href="addSubject.html">Add Subject</a><br/></td>
	<td><a href="viewSubject.jsp">View Subjects</a><br/></td>
</tr>
<tr>
	<td><a href="addTeacher.html">Add Teacher</a><br/></td>
	<td><a href="viewTeachers.jsp">View Teachers</a><br/></td>
</tr>
<tr>
	<td><a href="addStudent.html">Add Student</a><br/></td>
	<td><a href="viewStudent.jsp">View Students</a><br/></td>
</tr>
</table>
<br>
<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
<a href="assignTeacherToSubject.jsp">Assign Teacher to Class</a><br>
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>
<a href="chooseClassReport.jsp">Choose Class for report</a>
</body>
</html>