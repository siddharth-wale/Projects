
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Xoom Cars</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap Links -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Style Sheet Links -->
<link rel="stylesheet" href="resources/CSS/Home.css">
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

	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">XOOM CARS</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			
    
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<button type="button" style="margin-top:0.7%;" class="btn btn-default" id="start-record-btn" title="Start Recording">
      <span class="glyphicon glyphicon-ice-lolly"></span>
    </button>
				<ul class="nav navbar-nav">

				</ul>
				
				<form class="navbar-form navbar-left" action="OuterDashboard.html" method="post">
				<div class="form-group">
					<input name="inputText" class="form-control" id="note-textarea" placeholder="Search Xoom Inventory"
						></input>
						</div>
					<button id="" class="btn btn-default" title="Start Recording">Submit</button>
					
				</form>
				
		
						
						
						
                        
			<!-- <span><button class="btn btn-default" id="start-record-btn" title="Start Recording">Start
						Recognition</button></span> -->	
				<ul class="nav navbar-nav navbar-right">
					<li>
						<p class="navbar-text">Already have an account?</p>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">

										<div class="social-buttons">
											<fb:login-button class="btn btn-fb"
												scope="public_profile,email" onlogin="checkLoginState();">Facebook</fb:login-button>
											<div id="status"></div>

										</div>
										or
										<form class="form" role="form" method="post"
											action="userLogin.html" accept-charset="UTF-8" id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="exampleInputEmail2">Email
													address</label> <input type="email" class="form-control"
													name="email" id="exampleInputEmail2"
													placeholder="Email address" required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputPassword2">Password</label>
												<input type="password" name="password" class="form-control"
													id="exampleInputPassword2" placeholder="Password" required>
												<div class="help-block text-right">
													<a href="">Forget the password ?</a>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary btn-block">Sign
													in</button>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox"> keep me
													logged-in
												</label>
											</div>
										</form>
									</div>
									<div class="bottom text-center">
										New here ? <a href="signup.html"><b>Join Us</b></a>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="video-background">
		<div class="video-foreground">
			<iframe
				src="https://www.youtube.com/embed/ql94IYUrwXY?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=ql94IYUrwXY"
				frameborder="0" allowfullscreen></iframe>
		</div>
	</div>

	<div id="headingblock">
		<div id="title">
			<h4 style="color: red">${ERROR}</h4>
			<h4 style="color: green">${Success}</h4>
			<h4 style="color: green">${paymentmsg}</h4>
			<h1>LOT MORE THAN RENTAL</h1>
			<h3>RIDE WITH PRIDE</h3>
		</div>
		<div id="bar">
			<button type="button" class="btn btn-default">
				<a href="dashboard.html" style="text-decoration: none;">RENT
					CAR</a>
			</button>
			<button type="button" class="btn btn-default">
				<a href="#" style="text-decoration: none;" />BUY CAR
			</button>
			<button type="button" class="btn btn-default">
				<a href="#" style="text-decoration: none;" />PICKUP LOCATION
			</button>
			<button type="button" class="btn btn-default">
				<a href="reservation.html" style="text-decoration: none;" />ABOUT
				US
			</button>
		</div>
		<div>
</body>
<script>try {
        	  var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
        	  var recognition = new SpeechRecognition();
        	}
        	catch(e) {
        	  console.error(e);
        	  $('.no-browser-support').show();
        	  $('.app').hide();
        	}


        	var noteTextarea = $('#note-textarea');
        	var instructions = $('#recording-instructions');
        	var notesList = $('ul#notes');

        	var noteContent = '';

        	// Get all notes from previous sessions and display them.
        	var notes = getAllNotes();
        	renderNotes(notes);



        	/*-----------------------------
        	      Voice Recognition 
        	------------------------------*/

        	// If false, the recording will stop after a few seconds of silence.
        	// When true, the silence period is longer (about 15 seconds),
        	// allowing us to keep recording even when the user pauses. 
        	recognition.continuous = true;

        	// This block is called every time the Speech APi captures a line. 
        	recognition.onresult = function(event) {

        	  // event is a SpeechRecognitionEvent object.
        	  // It holds all the lines we have captured so far. 
        	  // We only need the current one.
        	  var current = event.resultIndex;

        	  // Get a transcript of what was said.
        	  var transcript = event.results[current][0].transcript;

        	  // Add the current transcript to the contents of our Note.
        	  // There is a weird bug on mobile, where everything is repeated twice.
        	  // There is no official solution so far so we have to handle an edge case.
        	  var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);

        	  if(!mobileRepeatBug) {
        	    noteContent += transcript;
        	    noteTextarea.val(noteContent);
        	  }
        	};

        	recognition.onstart = function() { 
        	  instructions.text('Voice recognition activated. Try speaking into the microphone.');
        	}

        	recognition.onspeechend = function() {
        	  instructions.text('You were quiet for a while so voice recognition turned itself off.');
        	}

        	recognition.onerror = function(event) {
        	  if(event.error == 'no-speech') {
        	    instructions.text('No speech was detected. Try again.');  
        	  };
        	}



        	/*-----------------------------
        	      App buttons and input 
        	------------------------------*/

        	$('#start-record-btn').on('click', function(e) {
        	  if (noteContent.length) {
        	    noteContent += ' ';
        	  }
        	  recognition.start();
        	});


        	$('#pause-record-btn').on('click', function(e) {
        	  recognition.stop();
        	  instructions.text('Voice recognition paused.');
        	});

        	// Sync the text inside the text area with the noteContent variable.
        	noteTextarea.on('input', function() {
        	  noteContent = $(this).val();
        	})

        	$('#save-note-btn').on('click', function(e) {
        	  recognition.stop();

        	  if(!noteContent.length) {
        	    instructions.text('Could not save empty note. Please add a message to your note.');
        	  }
        	  else {
        	    // Save note to localStorage.
        	    // The key is the dateTime with seconds, the value is the content of the note.
        	    saveNote(new Date().toLocaleString(), noteContent);

        	    // Reset variables and update UI.
        	    noteContent = '';
        	    renderNotes(getAllNotes());
        	    noteTextarea.val('');
        	    instructions.text('Note saved successfully.');
        	  }
        	      
        	})


        	notesList.on('click', function(e) {
        	  e.preventDefault();
        	  var target = $(e.target);

        	  // Listen to the selected note.
        	  if(target.hasClass('listen-note')) {
        	    var content = target.closest('.note').find('.content').text();
        	    readOutLoud(content);
        	  }

        	  // Delete note.
        	  if(target.hasClass('delete-note')) {
        	    var dateTime = target.siblings('.date').text();  
        	    deleteNote(dateTime);
        	    target.closest('.note').remove();
        	  }
        	});



        	/*-----------------------------
        	      Speech Synthesis 
        	------------------------------*/

        	function readOutLoud(message) {
        		var speech = new SpeechSynthesisUtterance();

        	  // Set the text and voice attributes.
        		speech.text = message;
        		speech.volume = 1;
        		speech.rate = 1;
        		speech.pitch = 1;
        	  
        		window.speechSynthesis.speak(speech);
        	}



        	/*-----------------------------
        	      Helper Functions 
        	------------------------------*/

        	function renderNotes(notes) {
        	  var html = '';
        	  if(notes.length) {
        	    notes.forEach(function(note) {
        	      html+= `<li class="note">
        	        <p class="header">
        	          <span class="date">${note.date}</span>
        	          <a href="#" class="listen-note" title="Listen to Note">Listen to Note</a>
        	          <a href="#" class="delete-note" title="Delete">Delete</a>
        	        </p>
        	        <p class="content">${note.content}</p>
        	      </li>`;    
        	    });
        	  }
        	  else {
        	    html = '<li><p class="content">You don\'t have any notes yet.</p></li>';
        	  }
        	  notesList.html(html);
        	}


        	function saveNote(dateTime, content) {
        	  localStorage.setItem('note-' + dateTime, content);
        	}


        	function getAllNotes() {
        	  var notes = [];
        	  var key;
        	  for (var i = 0; i < localStorage.length; i++) {
        	    key = localStorage.key(i);

        	    if(key.substring(0,5) == 'note-') {
        	      notes.push({
        	        date: key.replace('note-',''),
        	        content: localStorage.getItem(localStorage.key(i))
        	      });
        	    } 
        	  }
        	  return notes;
        	}


        	function deleteNote(dateTime) {
        	  localStorage.removeItem('note-' + dateTime); 
        	}

</script>
</html>
