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
<h1>Student Management System</h1>
<% User user=(User)session.getAttribute("user"); %>
<h3>Hi,<%=user.getUsername() %> </h3>
        <h2>
         <a href="new">Add New Student</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Students</a>
         &nbsp;&nbsp;&nbsp;
         <a href="logout">Logout</a>
         </h2>
<div align="center">
  <c:if test="${s!= null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${s == null}">
      <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${s!= null}">
               Edit Student/
              </c:if>
              <c:if test="${s == null}">
               Add New student
              </c:if>
             </h2>
            </caption>
          <c:if test="${s != null}">
           <input type="hidden" name="id" value="<c:out value='${s.id}' />" />
          </c:if>            
            <tr>
                <th>Student First Name: </th>
                <td>
                 <input type="text" name="fname" size="45"
                   value="<c:out value='${s.fname}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Student SurName: </th>
                <td>
                 <input type="text" name="sname" size="45"
                   value="<c:out value='${s.sname}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Student Address: </th>
                <td>
                 <input type="text" name="address" size="45"
                   value="<c:out value='${s.address}' />"
                 />
                </td>
            </tr>
             <tr>
                <th>Student Age: </th>
                <td>
                 <input type="text" name="age" size="45"
                   value="<c:out value='${s.age}' />"
                 />
                </td>
            </tr>
              <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 

</body>
</html>