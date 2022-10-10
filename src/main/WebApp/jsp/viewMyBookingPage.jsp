<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list}" var="list">


<table style="width:30%">
    <tr>
    <th>Booking Id</th>
    <td>${list.bookedFlightId}</td>
    </tr>
    <tr>
    <th>source</th>
    <td>${list.flight.flightSource}</td>
    </tr>
    <tr>
    <th>Destination</th>
    <td>${list.flight.flightDestination}</td>
    </tr>
    <tr>
    <th>No of Seats</th>
    <td>${list.noOfSeats}</td>
    </tr>
    <tr>
    <th>Total Price</th>
    <td>${list.price}</td>
    </tr>
     <tr>
    <th>Flight No</th>
    <td>${list.flight.flightNumber}</td>
    </tr>
  </table>
 

</c:forEach>
</body>
</html>