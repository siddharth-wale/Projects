<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>




<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">

  <div class="modal-dialog">
  <div class="modal-content">

  
      <div class="modal-header">

          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="login.htm" method="post" >
            <div class="form-group">
              <input type="text" required="" class="form-control input-lg" placeholder="User Name" name="username" required>
            </div>
            <div class="form-group">
              <input type="password" required="" class="form-control input-lg" placeholder="Password" name="password" required>
            </div>
            <p>${error }</p>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
              
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
           <span class="pull-right"><a href="register.htm"><h3>Register </h3></a></span>
         
    </div> 
      </div>
  </div>
  </div>
</div>



</body>
</html>