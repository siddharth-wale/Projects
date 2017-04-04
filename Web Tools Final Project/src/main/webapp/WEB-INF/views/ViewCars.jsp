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
				<li class="current_page_item"><a href="adminHome.htm" accesskey="1" title="">Homepage</a></li>
				<li><a href="addCarsPage.htm" accesskey="2" title="">Add Cars</a></li>
				
				<li><a href="logout.htm" accesskey="4" title="">LogOut</a></li>
				
			</ul>
		</div>
	</div>
</div>
     <div class="container">
      
    
    <div class="jumbotron">
   
    
  <h3> Welcome  ${sessionScope.username.username}</h3>
  <h2>View Cars</h2>
  <table border="1">
            <tr>
                <th>Car Id</th>
                <th>Car Name</th>
                <th>Car type</th>
                <th>Car Photo</th>
                <th>Rate</th>
                <th>Transmission</th>
                <th></th>
            </tr>    
                <c:forEach var="car" items="${requestScope.carList}">
                <tr>
                <td>${car.id}</td>
                <td>${car.carName }</td>
                <td>${car.carType }</td>              
                <td><img src="<c:url  value='C:\\Users\\Siddharth\\Desktop\\images\\${car.photoName}'/>"/></td>
                <td>${car.rate }</td>
                <td>${car.transmission }</td>
                 <td><a href="update.htm?id=${car.id}&action=update">Update</a></td>
                 
                </tr>
                </c:forEach>
  </table>
  

</div>

</div>

</body>
</html>