<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
   <div class="login-box">
      <h1>Login</h1>
      <form action="userLogin">
        <label>EmailID</label>
        <input type="text" name="mailID"placeholder="" />
        <label>Password</label>
        <input type="password" name="password"placeholder="" />
        <input type="submit" value="Submit" />
      </form>
    </div>
    <p class="para-2" >
      Not have an account? <a href="userSignUp">Sign Up Here</a>
    </p>
</body>
</html>