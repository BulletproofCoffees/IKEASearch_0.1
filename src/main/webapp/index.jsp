<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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


<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
					<form class="form-horizontal" method="post" >
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" >pw</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="Password" >
							</div>
						</div>
					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="goRight" class="off">Sign Up</button>
								<button id="login" type="submit" >Login</button>
							</div>
						</div>
						<div class="col-sm-12">
							<a href="${google_url}"> <img width="230px"
								alt="Google &quot;G&quot; Logo"
								src="${pageContext.request.contextPath}/resources/img/btn_google_signin_dark_pressed_web@2x.png" />
							</a>
						</div>
					</form>





				</div>
			</div>
		</div>
	</div>


	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>
