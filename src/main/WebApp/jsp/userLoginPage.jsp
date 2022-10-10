<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
<body>

   <div class="login-box">
   ${message}
      <h1>Login</h1>
      <form:form action="userLogin" modelAttribute="user">
        <label>EmailID</label>
        <form:input type="text" path="emailId" placeholder="EmailId" class = "input"/>
        <form:errors path="emailId" cssClass="error" />
        <label>Password</label>
        <form:input type="password" path="password" placeholder="Password" class = "input" />
        <form:errors path="password" cssClass="error" />
        <input type="submit" value="Submit" />
      </form:form>
    </div>
    <p class="para-2" >
      Not have an account? <a href="userSignUp">Sign Up Here</a>
    </p>
</body>
</html>