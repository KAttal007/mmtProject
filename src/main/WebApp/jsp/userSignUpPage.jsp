<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <form action="createUser">
        <label>First Name</label>
        <input type="text" name ="firstName" placeholder="" />
        <label>Middle Name</label>
        <input type="text" name="middleName" placeholder="" />
        <label>Last Name</label>
        <input type="text" name="lastName" placeholder="" />
        <label>Email</label>
        <input type="email" name="mailID"placeholder="" />
        <label>MobileNumber</label>
        <input type="text" name="mobileNumber"placeholder="" />
        <label>Password</label>
        <input type="password" name="password"placeholder="" />
       <!--  <label>Confirm Password</label>
        <input type="password" placeholder="" /> -->
        <input type="submit" value="Submit" />
      </form>
    </div>
    <p class="para-2">
      Already have an account? <a href="userLoginNav">Login here</a>
    </p>
  </body>
</html>