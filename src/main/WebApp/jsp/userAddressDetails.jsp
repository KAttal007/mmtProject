<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
      table {
        border-collapse: separate;
        border-spacing: 0 15px;
      }
      th {
        background-color: #4287f5;
        color: white;
      }
      th,
      td {
        width: 150px;
        text-align: center;
        border: 1px solid black;
        padding: 5px;
      }
      h2 {
        color: #4287f5;
      }
    </style>
</head>
<h2>profile</h2>
<body>
<form>

<table style="width:30%">
  <tr>
    
    <th>House No</th>
    <td>${address.houseNo}</td>
    </tr>
    <tr>
    <th>Street Name</th>
    <td>${address.streetName}</td>
    </tr>
    <tr>
    <th>Area</th>
    <td>${address.area}</td>
    </tr>
    <tr>
    <th>city</th>
    <td>${address.city}</td>
    </tr>
    <tr>
    <th>pin code</th>
    <td>${address.pincode}</td>
    </tr>
    <tr>
    <th>state</th>
    <td>${address.state}</td>
    </tr>
    <tr>
    <th>country</th>
    <td>${address.country}</td>
  </tr>
  </table>
</form>
<form action="addUserAddress">
<input type="submit" value="Update Profile">
</form>
</body>
</html>