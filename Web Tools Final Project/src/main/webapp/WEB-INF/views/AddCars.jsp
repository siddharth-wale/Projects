<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Cars</title>

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
				<li class="current_page_item"><a href="adminHome.htm" accesskey="1" title="">Homepage</a></li>
				<li><a href="viewCars.htm" accesskey="3" title="">View Cars</a></li>
				<li><a href="logout.htm" accesskey="4" title="">LogOut</a></li>
				
			</ul>
		</div>
	</div>
</div>
     <div class="container">
      
    
    <div class="jumbotron">
   
    
  <h3> Welcome  ${username.username}</h3>
  <br/>
  <h4>${carAdded}</h4>
  
<spring:form commandName="car" action="addCar.htm" method="POST" enctype="multipart/form-data">
<table>
<tr>
<td>Car Name:</td>
<td><spring:input path="carName" id="carName" type="text"/></td>
<td> <spring:errors cssStyle="color:red" path="carName"/></td>
</tr>
<tr> 
<td>Car Type:</td>
<td><spring:input path="carType" id="carType" type="text"/></td>
<td> <spring:errors cssStyle="color:red" path="carType"/></td>
</tr>
<tr> 
<td>Rate:</td>
<td><spring:input path="rate" id="rate" type="text"/></td>
<td> <spring:errors cssStyle="color:red" path="rate"/></td>
</tr>
<tr> 
<td>Transmission type:</td>
<td><spring:input path="transmission" id="transmission" type="text"/></td>
<td> <spring:errors cssStyle="color:red" path="transmission"/></td>
</tr>
<tr> 
<td>Select Photo (Max Size: 5MB):</td>
<td><spring:input path="photo" type="file"/></td>
<td> <spring:errors cssStyle="color:red" path="photo"/></td>
</tr>
<input type="submit" name="Add Car">
</table>
</spring:form>

</div>

</div>

</body>
</html>