<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="ISO-8859-1">
    <title>Sign Up</title>
    <link rel="stylesheet" href="/css/login.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="signup-box">
      <h1>Sign Up</h1>
      <h4>It's free and only takes a minute</h4>
      <form:form action="createUser" modelAttribute = "user">
        <label>First Name</label>
        <form:input type="text" path ="firstName" placeholder="First Name" class = "input"/>
        <form:errors path="firstName" cssClass="error" />
        <label>Middle Name</label>
        <form:input type="text" path ="middleName" placeholder="Middle Name" class = "input"/>
        <form:errors path="middleName" cssClass="error" />
        <label>Last Name</label>
        <form:input type="text" path ="lastName" placeholder="Last Name" class = "input"/>
        <form:errors path="lastName" cssClass="error" />
       <label>EmailID</label>
        <form:input type="email" path="emailId" placeholder="EmailId" class = "input"/>
        <form:errors path="emailId" cssClass="error" />
        <label>Mobile Number</label>
        <form:input type="text" path ="mobileNumber" placeholder="Mobile Number" class = "input"/>
        <form:errors path="mobileNumber" cssClass="error" />
        <label>Password</label>
        <form:input type="password" path="password" placeholder="Password" class = "input" />
        <form:errors path="password" cssClass="error" />
        <input type="submit" value="Submit" />
      </form:form>
    </div>
    <p class="para-2">
      Already have an account? <a href="userLoginNav">Login here</a>
    </p>
  </body>
</html>