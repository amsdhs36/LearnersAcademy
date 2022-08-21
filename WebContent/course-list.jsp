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
 <a href="clist">CoursesList</a>
         &nbsp;&nbsp;&nbsp;
         <a href="/newcourse">Add Course</a>
          &nbsp;&nbsp;&nbsp;
           
         <a href="logout">Logout</a>
<h2>List of Courses</h2>
    
        <table border="1">
            
            <tr>
                <th>Course ID</th>
                <th>CourseName</th>
                           
                
            </tr>
            <c:forEach var="c" items="${listCourse}">
                <tr>
                    <td><c:out value="${c.courseid}" /></td>
                    <td><c:out value="${c.coursename}" /></td>                 
                    <td>
                     <a href="editcourse?courseid=<c:out value='${c.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="deletecourse?courseid=<c:out value='${c.id}' />">Delete</a>                     
                    </td>
        </tr>
            </c:forEach>
        </table>
</body>
</html>