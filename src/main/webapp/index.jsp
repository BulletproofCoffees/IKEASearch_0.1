<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/Template/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="${pageContext.request.contextPath}/resources/Template/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/Template/css/agency.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/css/index.css"
	rel="stylesheet" type="text/css">



</head>
<body>

	<div id="back">
		<div class="backRight"></div>
		<div class="backLeft"></div>
	</div>

	<div id="slideBox">
		<div class="topLayer">
			<div class="left">
				<div class="content">
					<h2>Sign Up</h2>
					<form onsubmit="return checkz()" method="post" action="${pageContext.request.contextPath}/join" >
						<div class="form-group">
							<input type="text" placeholder="Name"  id="name" name="name"class="col-xs-10" required/>
							<input type="text" placeholder="email" id="email" name="email" class="col-xs-10" required/>
						    <input type="text" placeholder="password" id="pw" name="pw" class="col-xs-10" required/>
						    <input type="text" placeholder="checkpassword" id="cpass" class="col-xs-10" required/>
						</div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<div class="form-group"></div>
						<button id="goLeft" class="off" type="button">Login</button>
						<button>SignUp</button>
					</form>
				</div>
			</div>
			<div class="right">
				<div class="content">
					<h2>Login</h2>
					<form method="post" action="${pageContext.request.contextPath}/login">
						<div class="form-group">
							<input type="text" placeholder="email"  class="col-xs-10" name="email" />
							 <input type="text" placeholder="password" class="col-xs-10" name="pw" />
						</div>
						<button id="goRight" class="off" type="button">Sign Up</button>
						<button type="submit">Login</button>
						<a href="${sessionScope.googleurl}">
						 <img width="230px"alt="Google &quot;G&quot; Logo" src="${pageContext.request.contextPath}/resources/img/btn_google_signin_dark_pressed_web@2x.png" />
						</a>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--Inspiration from: http://ertekinn.com/loginsignup/-->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	
<input type="hidden" value="${idxmessage}" id="idxmessage">	
<script>
//회원 정보 없음 경고창
window.onload = function(){
	var message = document.getElementById("idxmessage").value;
	if(message == ""){
	} else {
		alert(message);
	}
	
}
</script>
</body>
</html>
