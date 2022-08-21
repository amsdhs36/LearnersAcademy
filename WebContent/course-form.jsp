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
<div align="center">
  <c:if test="${c!= null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${s == null}">
      <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${c!= null}">
               Edit Course/
              </c:if>
              <c:if test="${c == null}">
               Add New Course
              </c:if>
             </h2>
            </caption>
          <c:if test="${c != null}">
           <input type="hidden" name="id" value="<c:out value='${c.id}' />" />
          </c:if>            
            <tr>
                <th>Student First Name: </th>
                <td>
                 <input type="text" name="fname" size="45"
                   value="<c:out value='${c.coursename}' />"
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