<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
<link rel="stylesheet" href="/css/addFlightAndHotel.css" />
</head>
<body>

<h3 style="color:#CC6666;">${message}</h3>
<div class="login-box">
 <form action="updateHotel">

       <h1 style="color:#CC6666;">Add new Hotels</h1>
        <input type = "text" name = "hotelId" class ="input" value="" placeholder="Hotel ID">
        
        <input type = "text" name = "hotelName" class ="input" value="" placeholder="Hotel Name">
       
        <input type = "text" name = "hotelBrand" class ="input" value="" placeholder="Hotel Brand">
       
        <input type = "number" name = "priceAcRoom" step="0.01" class ="input" value="" placeholder="AC Room Price">
        
        <input type = "number" name = "priceNonAcRoom" step="0.01" class ="input" value="" placeholder="Non AC Room Price">
       
        <input type = "text" name = "hotelCity" class ="input" value="" placeholder="City">
       
        <input type = "number" name = "noOfAcRooms" class ="input" value="" placeholder="No of AC Rooms">
       
        <input type = "number" name = "noOfNonAcRooms" class ="input" value="" placeholder="No of Non AC Rooms">
        
       
        <input type="submit" name ="updateHotel" value="updateHotel" />
        <a href = "adminHomePage">Go back to admin Home</a>
      </form>
   </div>


</body>
</html>



