<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="google-signin-client_id" content="805585155237-oegvo0tr7ilo5fjh75dil9576jv4fbkf.apps.googleusercontent.com">

</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

	<a href="#" onclick="signOut();" >Sign out</a>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	
<script>
function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
      location.href = '${pageContext.request.contextPath}/logout';      
    });
  }
</script>


</body>
</html>