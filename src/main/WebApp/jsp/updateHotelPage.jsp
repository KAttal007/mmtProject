<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make My Trip - Admin Add Hotels</title>
</head>
<body>

${message}

<form action = "updateHotel">
Enter HotelID: <input type = "text" name = "hotelId"><br>
Enter Hotel Name: <input type = "text" name = "hotelName"><br>
Enter Hotel Brand: <input type = "text" name = "hotelBrand"><br>
Enter Price of AC Rooms: <input type = "number" name = "priceAcRoom"><br>
Enter Price of Non AC Rooms: <input type = "number" name = "priceNonAcRoom"><br>
Enter Hotel City: <input type = "text" name = "hotelCity"><br>
Enter Hotel No. of AC Rooms : <input type = "number" name = "noOfAcRooms"><br>
Enter Hotel No. of Non AC Rooms: <input type = "number" name = "noOfNonAcRooms"><br>
Enter Hotel No. Of Avlb AC Rooms: <input type = "number" name = "noOfAvilableAcRoom"><br>
Enter Hotel No. Of Avlb Non AC Rooms: <input type = "number" name = "noOfAvilableNonAcRoom"><br>
Enter Hotel AC availability: <br>
<input type = "radio" name="isAc" value="true"/> Yes <br>
<input type = "radio" name="isAc" value="false"/> No <br>
<input type="submit" name="AddHotel" value = "AddHotel"><br>
</form>
<a href = "adminHomePage">Go back to admin Home</a>

</body>
</html>