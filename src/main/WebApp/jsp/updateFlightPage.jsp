<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Flight</title>
<link rel="stylesheet" href="/css/addFlightAndHotel.css" />
</head>
<body>
<h3 style="color:#CC6666;">${message}</h3>
 <div class="login-box">
 <form action="updateFlight">
 		<h1 style="color:#CC6666;">Add new Flights</h1>
 		
 		  <input type = "text" name = "flightId" class ="input" value="" placeholder="Enter Flight ID">
       
        <input type = "text" name = "airlineName" class ="input" value="" placeholder="Airline Name">
       
        <input type = "text" name = "flightNumber" class ="input" value="" placeholder="Flight Number">
       
        <input type = "text" name = "flightSource" class ="input" value="" placeholder="Source">
       
        <input type = "text" name = "flightDeparture" class ="input" value="" placeholder="Destination">
       
        <input type = "text" name = "flightDeparture" class ="input" value="" placeholder="Departure Time">
       
        <input type = "text" name = "flightArrival" class ="input" value="" placeholder="Arrival Time">
        
        <input type = "number" name = "pricePerSeat" class ="input" value="" placeholder="Price">
       
        <input type = "number" name = "noOfSeats" class ="input" value="" placeholder="Total Seats">
       
        <input type="submit" value="Submit" />
        <a href = "adminHomePage">Go back to admin Home</a>
      </form>
   </div>
</body>
</html>


