<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
${flight.flightNumber}
${flight.airlineName}
${flight.flightDuration}
${flight.flightDeparture}
${flight.noOfAvilableSeats}
<form action="checkAvailabilty">
<input type ="number" name ="noOfSeats">
<input type="hidden" value="${flight.flightId}" name ="flightId">
<input type ="submit" >
</form>
</body>
</html>