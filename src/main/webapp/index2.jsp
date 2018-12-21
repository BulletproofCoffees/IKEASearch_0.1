<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/Template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/resources/Template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/Template/css/agency.min.css" rel="stylesheet">
    
    
    
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">   
    <meta name="google-signin-client_id" content="805585155237-oegvo0tr7ilo5fjh75dil9576jv4fbkf.apps.googleusercontent.com">
    

</head>
<body >
<div id="back">
  <div class="backRight"></div>
  <div class="backLeft"></div>
</div>
<div id="slideBox">
  <div class="topLayer">
    <div class="left">
      <div class="content" >
        <h2>Sign Up</h2>
        <form method="post" onsubmit="return false;">
          <div class="form-group">
            <input type="text" placeholder="username" />
          </div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>
        </form>
        <button id="goLeft" class="off">Log in</button>
        <button>Sign up</button>
      </div>
    </div>
    <div class="right">
      <div class="content">
        <h2>Log in</h2>
        <form method="post" onsubmit="return false;">
          <div class="form-group">
            <label for="username" class="form-label">Username</label>
            <input type="text" />
            
            
       <div style=" padding-top: 15px;">
            <div id="my-signin2"></div>    
            ${google_url}
           <a href="${google_url}"><i class="fa fa-google" aria-hidden="true"></i>Google Login</a>          
            </div>
  
            
          
          </div>
          <button id="goRight" class="off">Sign Up</button>
          <button id="login" type="submit">Login</button>
        </form>
      </div>
    </div>
  </div>
</div>


<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script  src="${pageContext.request.contextPath}/resources/js/index.js"></script>



  <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
    <script src="${pageContext.request.contextPath}/resources/js/googielogin.js" async defer></script>
  

 <script>
    function onSuccess(googleUser) {
    	 var profile = googleUser.getBasicProfile();
   	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
   	  console.log('Name: ' + profile.getName());
   	  console.log('Image URL: ' + profile.getImageUrl());
   	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.   	
   	login( profile.getName(),profile.getId(),profile.getEmail());
   	  
    }
    function onFailure(error) {
      console.log(error);
    }
    function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure,
      });
    }
 
		function login(name, id, email) {
			var form = $(
					'<form action="${pageContext.request.contextPath}/login" method="post">'
					+ '<input type="hidden" name="name" value="'+name+'"></input>'
					+ '<input type="hidden" name="id" value="'+id+'"></input>'
					+ '<input type="hidden" name="email" value="'+email+'"></input>'
					+ '</form>');
			$('body').append(form);
			$(form).submit();
		};
	</script>
  









































</body>
</html>
