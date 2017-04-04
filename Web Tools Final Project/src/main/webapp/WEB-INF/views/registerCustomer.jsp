<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Customer</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

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
				<li><a href="reservationPage.htm" accesskey="2" title="">Reservation</a></li>
				<li><a href="loginPage.htm" accesskey="3" title="">Login</a></li>
				<li><a href="#" accesskey="4" title="">Careers</a></li>
				<li><a href="#" accesskey="5" title="">Contact Us</a></li>
			</ul>
		</div>
	</div>
</div>

    <script>

        var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function checkUser() {
           if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var username = document.getElementById("username").value;
            var query = "action=ajaxCheck&username="+username;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    
                    document.getElementById("error").innerHTML = xmlHttp.responseText;
                }
            };
            xmlHttp.open("POST", "signup.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
           return false;
        }
        
         function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
        
        </script>
     <div class="container">
      
    
    
    <div class="jumbotron">
	<h1>Register Customer</h1>
	
	<h4>${userCreated}</h4>
		<spring:form action="register.htm" commandName="customer"  method="POST" >
		<table>
		
		<tr>
		
        <td>First :</td>
        <td> <spring:input path="firstName" id="first" type="text"/></td>
        <td> <spring:errors cssStyle="color:red" path="firstName"/></td>
        </tr> 
        
        <tr>  
        <td>Last :</td>
        <td> <spring:input path="lastName" id="last" type="text"/></td>
        <td><spring:errors cssStyle="color:red" path="lastName"/></td>
        </tr>
       
        <tr>   
        <td> Gender:</td>
        <td> <spring:radiobutton path="gender" id="gender" value="M"/>Male
         <spring:radiobutton path="gender" id="gender" value="F"/>Female</td>
        <td><spring:errors cssClass="color:red" path="gender"/></td>
        </tr>
       
        <tr>   
        <td> Age :</td> 
        <td><spring:input path="age" id="age" type="text"/></td>
        <td><spring:errors cssStyle="color:red" path="age"/></td>
        </tr>
        
        <tr>   
        <td>  Address :</td>
        <td> <spring:input path="address" id="address" type="text"/></td>
        <td> <spring:errors cssStyle="color:red" path="address"/></td>
        </tr>
        
        <tr> 
        <td> Mobile Number :</td>
        <td> <spring:input path="mobileNumber"  type="text"/></td>
        <td> <spring:errors cssStyle="color:red" path="mobileNumber"/></td>
        </tr> 
        
        <tr> 
        <td> Email : </td>
        <td><spring:input path="emailID" type="text"/></td>
        <td><spring:errors cssStyle="color:red" path="emailID"/></td>
        </tr>
       
        <tr>
        <td> UserName : </td>
        <td><spring:input path="userAccount.username" name="username" type="text" id="username" onblur="return checkUser()"/>
        <div id="error" style="color:red"></div></td>
        <td><spring:errors cssStyle="color:red" path="userAccount.username"/></td>
        
        
        </tr>
        <tr>
        <td> Password : </td>
        <td><spring:input path="userAccount.password" type="password"/></td>
         <td><spring:errors cssStyle="color:red" path="userAccount.password"/></td>
        </tr>
		</table>
		<input type="submit" name="Register Customer">
            
        </spring:form>
        
        </div>
	</div>
        
</body>
</html>