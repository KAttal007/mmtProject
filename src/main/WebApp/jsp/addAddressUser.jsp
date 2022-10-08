<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="/css/login.css" />
</head>
<body>
<div class="signup-box">
<form action="addUserAddress">
<h3>Update Address</h3>
<label>houseNo</label>
<input type="text" name="houseNo" placeholder=""/>
<label>Street Name</label>
<input type="text" name="streetName" placeholder=""/>
<label>Area</label>
<input type="text" name="area" placeholder=""/>
<label>City</label>
<input type="text" name="city" placeholder=""/>
<label>State</label>
<input type="text" name="state" placeholder=""/>
<label>pin Code</label>
<input type="text" name="pinCode" placeholder=""/>
<label>Country</label>
<input type="text" name="country" placeholder=""/>
<div>                     </div>
<input type="submit" value="Update Address">
</form>
</div>
</body>
</html>