<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Xoom Cars Dashboard</title>

			<!-- Bootstrap Links -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

			<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
			<!-- Style Sheet Links -->
            <link rel="stylesheet" href="resources/CSS/Dashboard.css">
	        <script src="resources/JS/Dashboard.js"></script>
	        
	        <style>
	        .center1 {
    margin: auto;
    width: 9%;
    border: 3px solid black;
    padding: 10px;
    border-radius: 12px;
}






 .video-background {
     background: #000;
     position: fixed;
     top: 0;
     right: 0;
     bottom: 0;
     left: 0;
     z-index: -99;
     -webkit-filter: blur(15px);
     filter: blur(15px);
 }
 
 .video-foreground,
 .video-background iframe {
     position: absolute;
     top: 0;
     left: 0;
     width: 100%;
     height: 100%;
     pointer-events: none;
 }
 
 #vidtop-content {
     top: 0;
     color: #fff;
 }
 
 .vid-info {
     position: absolute;
     top: 0;
     right: 0;
     width: 33%;
     background: rgba(0, 0, 0, 0.3);
     color: #fff;
     padding: 1rem;
     font-family: Avenir, Helvetica, sans-serif;
 }
 
 .vid-info h1 {
     font-size: 2rem;
     font-weight: 700;
     margin-top: 0;
     line-height: 1.2;
 }
 
 .vid-info a {
     display: block;
     color: #fff;
     text-decoration: none;
     background: rgba(0, 0, 0, 0.5);
     transition: .6s background;
     border-bottom: none;
     margin: 1rem auto;
     text-align: center;
 }
 
 @media (min-aspect-ratio: 16/9) {
     .video-foreground {
         height: 300%;
         top: -100%;
     }
 }
 
 @media (max-aspect-ratio: 16/9) {
     .video-foreground {
         width: 300%;
         left: -100%;
     }
 }
 
 @media all and (max-width: 600px) {
     .vid-info {
         width: 50%;
         padding: .5rem;
     }
     .vid-info h1 {
         margin-bottom: .2rem;
     }
 }
 
 @media all and (max-width: 500px) {
     .vid-info .acronym {
         display: none;
     }
 }





</style>
</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
%>

<div class="video-background">
                <div class="video-foreground">
                    <iframe id="ytplayer" src="https://www.youtube.com/embed/ql94IYUrwXY?controls=0&showinfo=0&rel=0&enablejsapi=1&mute=1&autoplay=1&loop=1&playlist=ql94IYUrwXY" frameborder="0" allowfullscreen></iframe>
                </div>
            </div>

<nav class="navbar navbar-default navbar-inverse" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="adminDashboard.htm">XOOM CARS</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search Xoom Inventory">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <p class="navbar-text">Welcome, ${userFirstName}</p>
                    </li>
                    <li class="dropdown">
                        <a href="logout.html" class="dropdown-toggle" data-toggle="#"><b>Logout</b> <span class="cart"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">
                                        Login via
                                        <div class="social-buttons">
                                            <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                            <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                        </div>
                                        or
                                        <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                                <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> keep me logged-in
                                                </label>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="bottom text-center">
                                        New here ? <a href="#"><b>Join Us</b></a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
       
    <c:choose>
    <c:when test="${Customer == 'Customer'}">
     <c:forEach var="item" items="${carList}">  
     <form action="carPayment.htm" method="post">                    
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="my-list">
            <img style="color:white" src="${item.carPhotos}" alt="Car Image" />
        <!--       <h3 style="color:white">PickUp-${item.reservation.pickUpDate}  DropOff-${item.reservation.returnDate}</h3>-->
            <input type = "hidden" name = "carNamePay" value = "${item.carName}"><span style="color:white">${item.carName}</span>
            <input type = "hidden" name = "carRentPricePay" value = "${item.rent_Price}"><span class="pull-right" style="color:white"><fmt:formatNumber type = "number" maxFractionDigits = "2"  value = "${item.rent_Price}" />$</span>
            <div class="offer" style="color:white">Car Capacity - ${item.car_Capacity} and Mileage - ${item.car_Milage}</div>
            <input type = "hidden" name = "carCapacityPay" value = "${item.car_Capacity}">
            <input type = "hidden" name = "carMilagePay" value = "${item.car_Milage}">
            <div class="detail">
                <input type = "hidden" name = "carTypePay" value = "${item.car_Type}"><p>VEHICLE TYPE - ${item.car_Type}</p>
                <img src="${item.carPhotos}" />
                <button class="btn btn-info">Checkout</button>
                <a href="#" class="btn btn-info">Details</a>
            </div>
        </div>
    </div> 
    </form>        
    </c:forEach>       
    
    
    </div>
    </c:when>
    </c:choose>



</body>
</html>