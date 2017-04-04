 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation Form</title>
  <meta charset="utf-8">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  var dateToday = new Date(); 
  $(function() {
    $( "#datepicker" ).datepicker({
        numberOfMonths: 1,
        showButtonPanel: true,
        minDate: dateToday
    });
    $( "#datepicker1" ).datepicker({
        numberOfMonths: 1,
        showButtonPanel: true,
        minDate: dateToday
    });
  });
  </script>
  
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  

<link href="resources/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">Car Rental</a></h1>
			<span>By <a href="http://templated.co">TEMPLATED</a></span> </div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="home.htm" accesskey="1" title="">Homepage</a></li>
				 <c:choose>
           		 <c:when test="${!empty sessionScope.username}">
				<li><a href="logout.htm" accesskey="4" title="">Logout</a></li>
				<li><a href="viewOrder.htm" accesskey="5" title="">My Order</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="loginPage.htm" accesskey="3" title="">Login</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
     <div class="container">
      
    
    <div class="jumbotron">
<h2>Reservation Form</h2>
 <c:choose>
            <c:when test="${!empty sessionScope.res}">
<h3>Reservation is in progress....Check in My Orders</h3>

</c:when>
 <c:otherwise>
 <form action="addreservation.htm" method="get"/>
<table>
<tr>
    <td>Pick-Up Location:</td>
    <td><select name="location">
    <option value="Boston Airport">Boston Airport</option>
    <option value="downtown">Downtown</option>
    <option value="Roxbury Crossing">Roxbury Crossing</option>
    <option value="Fenway Park">Fenway Park</option>
  	</select>
  	</td>
 </tr>
 <tr> 	
  	<td>Pick-Up Date:</td>
  	<td><input type="text" id="datepicker" name="pickDate" required></td>
  	
</tr>
<tr>
	<td>Pick-up Time:</td>
	<td><input type="time" name="pickTime" required></td>
</tr>

 <tr> 	
  	<td>Return Date:</td>
  	<td><input type="text" id="datepicker1" name="returnDate" required></td>
  	
</tr>
<tr>
	<td>Return Time:</td>
	<td><input type="time" name="returnTime" required></td>
</tr>
<tr>
<input type="submit" value="Select Car">
</tr>
</table>

</form>
 </c:otherwise>
 </c:choose>
</div>

</div>

</body>
</html>