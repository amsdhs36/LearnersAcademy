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
<a href="new">Add Student</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">StudentsList</a>
         &nbsp;&nbsp;&nbsp;
         <a href="home.jsp">Home Page</a>
         <a href="logout">Logout</a>
<h2>List of Students</h2>
    
        <table border="1">
            
            <tr>
                <th>ID</th>
                <th>FName</th>
                <th>Sname</th>
                <th>Address</th>
                <th>Age</th>
                <th>Actions</th>
                              
            </tr>
            <c:forEach var="s" items="${listStudent}" >
                <tr>
                    <td><c:out value="${s.id}" /></td>
                    <td><c:out value="${s.fname}" /></td>
                    <td><c:out value="${s.sname}" /></td>
                    <td><c:out value="${s.address}" /></td>
                    <td><c:out value="${s.age}" /></td>
                    
                    <td>
                     <a href="edit?id=<c:out value='${s.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${s.id}' />">Delete</a>                     
                    </td>
        </tr>
            </c:forEach>
        </table>
</body>
</html>