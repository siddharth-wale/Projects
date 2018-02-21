<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Sign Up</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<link rel="stylesheet" href="resources/CSS/Home.css">
            <link rel="stylesheet" href="resources/CSS/SignUp.css">

            <style>
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
            
            <script>
            function checkPass()
            {
                //Store the password field objects into variables ...
                var pass1 = document.getElementById('password');
                var pass2 = document.getElementById('cpassword');
                //Store the Confimation Message Object ...
                //Set the colors we will be using ...
                var goodColor = "#66cc66";
                var badColor = "#ff6666";
                //Compare the values in the password field 
                //and the confirmation field
                if(pass1.value == pass2.value){
                    //The passwords match. 
                    //Set the color to the good color and inform
                    //the user that they have entered the correct password 
                    pass2.style.backgroundColor = goodColor;
                }else{
                    //The passwords do not match.
                    //Set the color to the bad color and
                    //notify the user.
                    pass2.style.backgroundColor = badColor;
                }
            }  
            
            </script>
        </head>

        <body>
        
        <script>
			// This is called with the results from from FB.getLoginStatus().
			function statusChangeCallback(response) {
				console.log('statusChangeCallback');
				console.log(response);
				// The response object is returned with a status field that lets the
				// app know the current login status of the person.
				// Full docs on the response object can be found in the documentation
				// for FB.getLoginStatus().
				if (response.status === 'connected') {
					// Logged into your app and Facebook.
					testAPI();
				} else if (response.status === 'not_authorized') {
					// The person is logged into Facebook, but not your app.
					document.getElementById('status').innerHTML = 'Login with Facebook ';
				} else {
					// The person is not logged into Facebook, so we're not sure if
					// they are logged into this app or not.
					document.getElementById('status').innerHTML = 'Login with Facebook ';
				}
			}
			// This function is called when someone finishes with the Login
			// Button. See the onlogin handler attached to it in the sample
			// code below.
			function checkLoginState() {
				FB.getLoginStatus(function(response) {
					statusChangeCallback(response);
				});
			}
			window.fbAsyncInit = function() {
				FB.init({
					appId : '152268505385531',
					cookie : true, // enable cookies to allow the server to access 
					// the session
					xfbml : true, // parse social plugins on this page
					version : 'v2.10' // use version 2.2
				});
				// Now that we've initialized the JavaScript SDK, we call 
				// FB.getLoginStatus(). This function gets the state of the
				// person visiting this page and can return one of three states to
				// the callback you provide. They can be:
				//
				// 1. Logged into your app ('connected')
				// 2. Logged into Facebook, but not your app ('not_authorized')
				// 3. Not logged into Facebook and can't tell if they are logged into
				// your app or not.
				//
				// These three cases are handled in the callback function.

				FB.getLoginStatus(function(response) {
					statusChangeCallback(response);
				});
			};
			// Load the SDK asynchronously
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id))
					return;
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));

			// Here we run a very simple test of the Graph API after login is
			// successful. See statusChangeCallback() for when this call is made.
			function testAPI() {
				console.log('Welcome! Fetching your information.... ');
				FB.api('/me?fields=name,email', function(response) {
					console.log('Successful login for: ' + response.name);

					document.getElementById("status").innerHTML = '<p>Welcome '
							+ response.name
							+ '! <a href=fblogincontroller.htm?user_name='
							+ response.name.replace(" ","_") + '&user_email='
							+ response.email
							+ '>Continue with facebook login</a></p>'
				});
			}
		</script>
        
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
                        <a class="navbar-brand" href="#">XOOM CARS</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">

                        </ul>
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group" >
                                <input type="text" class="form-control" placeholder="Search Xoom Inventory">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <p class="navbar-text">Already have an account?</p>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-12">

                                                <div class="social-buttons">
                                                    <fb:login-button class="btn btn-fb"  scope="public_profile,email"
			onlogin="checkLoginState();">Facebook</fb:login-button>
					<div id="status"></div>
		
                                                </div>
                                                or
                                                <form class="form" role="form" method="post" action="userLogin.html" accept-charset="UTF-8" id="login-nav">
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                        <input type="email" class="form-control" name= "email" id="exampleInputEmail2" placeholder="Email address" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                        <input type="password" name = "password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
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
                                                New here ? <a href="signup.html"><b>Join Us</b></a>
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
            
            
            <div class="container" style="margin-top:4%;">
                <div class="row">
                    <div class="col-md-8">
                        <section>
                            <h1 class="entry-title" style="color:white;"><span style="text-align:centre;">Sign Up</span> </h1>
                            <hr>
                            <form class="form-horizontal" method="POST" name="signup" action="SignUp">
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Email ID <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                            <input type="email" class="form-control" name="emailid" id="emailid" placeholder="Enter your Email ID">
                                        </div>
                                        <small style="color:white;"> Your Email Id is being used for ensuring the security of your account, authorization and access recovery. </small> </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Set Password <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                            <input type="password" class="form-control" name="password" id="password" placeholder="Choose password (5-15 chars)" value="">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Confirm Password <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                            <input type="password" class="form-control" name="cpassword" id="cpassword" onkeyup="checkPass(); return false;" placeholder="Confirm your password">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">First Name <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <input type="text" class="form-control" name="fs_name" id="fs_name" placeholder="Enter your First Name here" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Last Name <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <input type="text" class="form-control" name="ls_name" id="ls_name" placeholder="Enter your Last Name here" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Address <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <input type="text" class="form-control" name="address" id="address" placeholder="Enter your Address here" value="">
                                    </div>
                                </div>
               
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Contact No. <span class="text-default">*</span></label>
                                    <div class="col-md-8 col-sm-9">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                                            <input type="tel" class="form-control" name="contactnum" id="contactnum" placeholder="Enter your Primary contact no." value="">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-3" style="color:white;">Profile Photo
                                        <br>
                                        <small>(optional)</small></label>
                                    <div class="col-md-8 col-sm-9">
                                        <div class="input-group"> <span class="input-group-addon" id="file_upload"><i class="glyphicon glyphicon-upload"></i></span>
                                            <input type="file" name="file_nm" id="file_nm" class="form-control upload" placeholder="" aria-describedby="file_upload">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-offset-3 col-md-8 col-sm-9" ><span class="text-muted"><span class="label label-danger">Note:-</span > By clicking Sign Up, you agree to our <a href="#">Terms</a> and that you have read our <a href="#">Policy</a>, including our <a href="#">Cookie Use</a>.</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-offset-3 col-xs-10">
                                        <input name="Submit" type="submit" value="Sign Up" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </body>

        </html>