<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isErrorPage="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body style="font-family: consolas;font-size: 20px;">

 <h2>Please Login</h2>
  
 <form action="${pageContext.request.contextPath}/j_user_check" method="post">
 
 
   UserName <input  type="text" name="j_user"><br>
   Password <input type="password"  name="j_password"><br>
   
   <input  type="submit"  value="Login">
 
 </form>

</body>
</html>