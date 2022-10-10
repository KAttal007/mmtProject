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

<form action="checkHotelAvailabilty">
Enter No of Rooms
<input type ="number" name ="noOfRooms">
IS AC :
<input type="checkbox" checked="checked" name="isAc" />
<input type="hidden" value="${hotel.hotelId}" name ="hotelId">
<input type ="submit" >
</form>

</body>
</html>