<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.assessment.simplilearn.entity.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Learner Academy Project</h1>
<% User user=(User)session.getAttribute("user"); %>
<h1>Hi,<%=user.getUsername() %> </h1>

<body>

 <h2>Please select your choice:</h2>
     <h3>
         
         <a href="student-list.jsp">Students</a>
         <a href="course-list.jsp">Courses</a>
         <a href="teachers-list.jsp">Teachers</a>
         <a href="subject-list.jsp">Subjects</a>
         <a href="logout">Logout</a>
         
         </h3>   
         
 
</body>
</html>