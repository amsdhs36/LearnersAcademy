<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>${message}

<h1>Welcome to the Learner's academy</h1>
<h3>Please enter your login credential</h3>
<form action="loginpage" method="post" >  
Username:<input type="text" name="username"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
<input type="submit" value="Admin Login"/> 
<br> 
</form> 
</body>
</html>