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
				
				<li><a href="logout.htm" accesskey="4" title="">Logout</a></li>
				<li><a href="viewOrder.htm" accesskey="5" title="">My Order</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
function searchFormDisplay() {
   var xmlHttp;
   xmlHttp = GetXmlHttpObject();
   
   function getResults() {
       if (xmlHttp == null)
       {
           alert("Your browser does not support AJAX!");
           return;
       }
       var key = document.getElementById("name").value;
       var flag = document.querySelector('input[name = "search"]:checked').value;
       var query = "action=searchuser&key=" + key.trim() + "&flag=" + flag.trim();
       xmlHttp.onreadystatechange = function stateChanged()
       {
           if (xmlHttp.readyState == 4)
           {
               document.getElementById("results").innerHTML = "";
               var json = JSON.parse(xmlHttp.responseText);
               if (json.users.length > 0) {
                   var x = document.createElement("TABLE");
                   x.setAttribute("id", "myTable");
                   document.getElementById("results").appendChild(x);
                   var y = document.createElement("TR");
                   y.setAttribute("id", "myTr");
                   document.getElementById("myTable").appendChild(y);

                   var z = document.createElement("TH");
                   var t = document.createTextNode("Car Id");

                   z.appendChild(t);
                   document.getElementById("myTr").appendChild(z);

                   var z = document.createElement("TH");
                   var t = document.createTextNode("Car Name");
                   z.appendChild(t);
                   document.getElementById("myTr").appendChild(z);

                   var z = document.createElement("TH");
                   var t = document.createTextNode("Car type");
                   z.appendChild(t);
                   document.getElementById("myTr").appendChild(z);

                   var z = document.createElement("TH");
                   var t = document.createTextNode("Rate");
                   z.appendChild(t);
                   document.getElementById("myTr").appendChild(z);
                   
                  
                   var z = document.createElement("TH");
                   var t = document.createTextNode("Transmission");
                   z.appendChild(t);
                   document.getElementById("myTr").appendChild(z);

                   for (var count = 0; count < json.cars.length; count++) {
                       var y = document.createElement("TR");
                       y.setAttribute("id", "myTr" + count);
                       document.getElementById("myTable").appendChild(y);

                       var z = document.createElement("TD");
                       var t = document.createTextNode(json.cars[count].id);
                       z.appendChild(t);
                       document.getElementById("myTr" + count).appendChild(z);

                       var z = document.createElement("TD");
                       var t = document.createTextNode(json.cars[count].carName);
                       z.appendChild(t);
                       document.getElementById("myTr" + count).appendChild(z);

                       var z = document.createElement("TD");
                       var t = document.createTextNode(json.cars[count].carType);
                       z.appendChild(t);
                       document.getElementById("myTr" + count).appendChild(z);

                       var z = document.createElement("TD");
                       var t = document.createTextNode(json.cars[count].rate);
                       z.appendChild(t);
                       document.getElementById("myTr" + count).appendChild(z);
                       


                       var z = document.createElement("TD");
                       var t = document.createTextNode(json.cars[count].rate);
                       z.appendChild(t);
					   document.getElementById("myTr" + count).appendChild(z);
                   }
               } else {
                   document.getElementById("results").innerHTML="Nothing Found";
               }
           }
       };
       xmlHttp.open("POST", "searchcar.htm", true);
       xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xmlHttp.send(query);
       return false;
   }
}
   </script>
     <div class="container">
      
    
    <div class="jumbotron">
   
    
  <h3> Welcome  ${username.username}</h3>
  

              <form id="search" onsubmit="return getResults();">

                Search User <input type="text" id="name" name="car" required /> <br><br>

                <label>Search By:</label>
                <input type="radio" name="search" value="carName" checked="checked"> Car Name
                <input type="radio" name="search"  value="carType">Car Type

                <input type="submit" name="search" onclick="searchFormDisplay()"/><br><br>
            </form>
            <div id="results">

            </div>
  

</div>

</div>

</body>
</html>