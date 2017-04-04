<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer DashBoard</title>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<link href="resources/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
if(session.getAttribute("token")==null){
   response.sendRedirect("logout.htm");}%>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">Car Rental</a></h1>
			<span>By <a href="http://templated.co">TEMPLATED</a></span> </div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="customerhome.htm" accesskey="1" title="">Homepage</a></li>
				<li><a href="reservationPage.htm" accesskey="2" title="">Reservation</a></li>
				<li><a href="logout.htm" accesskey="4" title="">LogOut</a></li>
				
			</ul>
		</div>
	</div>
</div>
     <div class="container">
      
    
    <div class="jumbotron">
   
    
  <h3> Welcome  ${username.username}</h3>

   <c:choose>
            <c:when test="${!empty sessionScope.res}">
                <h3>Your Order contents</h3>
                
        <form action="selectCarOrderPage.htm" method="post">
		<table>
		<tr>
		<td>Pick-Up Location</td>
		<td><input type="text" name="pickUpLocation" value="${res.pickUpLocation }" disabled></td>
		</tr>
		<tr>
		<td>Pick-Up Date</td>
		<td><input type="text" name="pickUpDate" value="${res.pickUpDate}" disabled></td>
		</tr>
		<tr>
		<td>Pick-Up Time</td>
		<td><input type="text" name="pickUpTime" value="${res.pickUpTime}" disabled></td>
		</tr>
		<tr>
		<td>Return Date</td>
		<td><input type="text" name="returnDate" value="${res.returnDate}" disabled></td>
		</tr>
		<tr>
		<td>Return Time</td>
		<td><input type="text" name="returnTime" value="${res.returnTime}" disabled></td>
		</tr>
		<tr>
		<td>CarId</td>
		<td><input type="text" name="id" value="${res.car.id }" disabled></td>
		</tr>
		<tr>
		<td>Car Name</td>
		<td><input type="text" name="carName" value="${res.car.carName }" disabled /></td>
		<td><br/></td>
		</tr>
		<tr>
		<td>Car Type</td>
		<td><input type="text" name="carType" value="${res.car.carType }" disabled/></td>
		<td><br/></td>
		</tr>
		<tr>
		<td>Rate</td>
		<td><input type="text" name="rate" value="${res.car.rate }"disabled /></td>
		<td><br/></td>
		</tr>
		<tr>
		<td>Transmission type</td>
		<td><input type="text" name="transmission" value="${res.car.transmission }" disabled/></td>
		<td><br/></td>
		</tr>
		<tr>
		<td><input type="submit" value="Checkout"></td>
		</tr>
		</table>
		</form>
        
        </c:when>
            <c:otherwise>
                <h3>Oops.. your Order is empty</h3>
                
            </c:otherwise>
        </c:choose>

</div>

</div>

</body>
</html>