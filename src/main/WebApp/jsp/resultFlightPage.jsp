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
<c:forEach items="${flightList}" var="list">
<table style="width:30%">
  <tr>
    
    <th>Flight Number</th>
    <td>${list.flightNumber}</td>
    </tr>
    <tr>
    <th>Airline Name</th>
    <td>${list.airlineName}</td>
    </tr>
    <tr>
    <th>Duration</th>
    <td>${list.flightDuration}</td>
    </tr>
    <tr>
    <th>Arrival</th>
    <td>${list.flightArrival}</td>
    </tr>
    <tr>
    <th>Avilable Seat</th>
    <td>${list.noOfAvilableSeats}</td>
    </tr>
    <tr>
    <th>Price Per Seat</th>
    <td>${list.pricePerSeat}</td>
    </tr>
    <th>Click to book flight</th>
      <td><input type="hidden" name="AddFlight" value = "${list.flightId}"></td>
      <td> <a href="" ><input type ="submit" value="BookFlight"></td> </a>
      <br>
  </table>

</c:forEach>
</body>
</html>