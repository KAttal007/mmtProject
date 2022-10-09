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
<form action="checkFlight">

<table style="width:30%">
    <tr>
    <th>Flight Number</th>
    <td>${list.flightNumber}</td>
    </tr>
    <tr>
    <th>Airline Name</th>
    <td>${list.airlineName}</td>
    </tr>
  </table>
  <input type="hidden" value="${list.flightId}" name ="flightId">
  
  <input type ="submit" value="check">
</form>
</c:forEach>
</body>
</html>