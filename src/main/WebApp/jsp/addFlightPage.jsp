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
<form action = "addFlight"><br>
Enter Airline name: <input type = "text" name = "airlineName"><br>
Enter Airline flightNumber: <input type = "text" name = "flightNumber"><br>
Enter Flight Source: <input type = "text" name = "flightSource"><br>
Enter Flight Destination: <input type = "text" name = "flightDestination"><br>
Enter Flight Departure: <input type = "text" name = "flightDeparture"><br>
Enter Flight Arrival: <input type = "text" name = "flightArrival"><br>
Enter Flight Price per seat: <input type = "number" name = "pricePerSeat"><br>
Enter Flight No of Seats: <input type = "number" name = "noOfSeats"><br>
Enter Flight No of Available seats: <input type = "number" name = "noOfAvilableSeats"><br>
<input type="submit" name="AddFlight" value = "AddFlight"><br><br>

</form>
<a href = "adminHomePage">Go back to admin Home</a>

</body>
</html>