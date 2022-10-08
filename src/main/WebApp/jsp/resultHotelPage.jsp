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
    
    <th>Hotel Name</th>
    <td>${list.hotelName}</td>
    </tr>
    <tr>
    <th>Hotel Brand</th>
    <td>${list.hotelBrand}</td>
    </tr>
    <tr>
    <th>Hotel City</th>
    <td>${list.hotelCity}</td>
    </tr>
    <tr>
    <th>Ac room Price</th>
    <td>${list.priceAcRoom}</td>
    </tr>
    <tr>
    <th>Non Ac room Price</th>
    <td>${list.priceNonAcRoom}</td>
    </tr>
    <tr>
    <th>No of Ac Room</th>
    <td>${list.noOfAvilableAcRoom}</td>
    </tr>
    <tr>
    <th>No of Non Ac Room</th>
    <td>${list.noOfAvilableNonAcRoom}</td>
  </tr>
  </table>
</c:forEach>
</body>
</html>