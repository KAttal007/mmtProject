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
<c:forEach items="${hotelList}" var="list">


<table style="width:30%">
    <tr>
    <th>Booking Id</th>
    <td>${list.bookedHotelId}</td>
    </tr>
   
  </table>
 

</c:forEach>
</body>
</html>