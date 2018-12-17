<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>WEB1 - Welcome</title>
  <meta charset="utf-8">
  
  
</head>
<body>
  <input type="button" id="loginBtn" value="checking..." class="g-signin2"  onclick="
    if(this.value === 'Login'){
      gauth.signIn().then(function(){
        console.log('gauth.signIn()');
        checkLoginStatus();
      });
    } else {
      gauth.signOut().then(function(){
        console.log('gauth.signOut()');
        checkLoginStatus();
      });
    }
  ">
  
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
  <script>
  var Links = {
		  setColor:function(color){
		    // var alist = document.querySelectorAll('a');
		    // var i = 0;
		    // while(i < alist.length){
		    //   alist[i].style.color = color;
		    //   i = i + 1;
		    // }
		    $('a').css('color', color);
		  }
		}
		var Body = {
		  setColor:function (color){
		    //document.querySelector('body').style.color = color;
		    $('body').css('color', color);
		  },
		  setBackgroundColor:function (color){
		    // document.querySelector('body').style.backgroundColor = color;
		    $('body').css('backgroundColor', color);
		  }
		}
		function nightDayHandler(self){
		  var target = document.querySelector('body');
		  if(self.value === 'night'){
		    Body.setBackgroundColor('black');
		    Body.setColor('white');
		    self.value = 'day';

		    Links.setColor('white');
		  } else {
		    Body.setBackgroundColor('white');
		    Body.setColor('black');
		    self.value = 'night';

		    Links.setColor('blue');
		  }
		}
  </script>
  <script>
    function checkLoginStatus(){
      var loginBtn = document.querySelector('#loginBtn');
      if(gauth.isSignedIn.get()){
        console.log('logined');
        loginBtn.value = 'Logout';
      } else {
        console.log('logouted');
        loginBtn.value = 'Login';
      }
    }
    function init(){
      console.log('init');
      gapi.load('auth2', function() {
        console.log('auth2');
        window.gauth = gapi.auth2.init({
          client_id:'805585155237-oegvo0tr7ilo5fjh75dil9576jv4fbkf.apps.googleusercontent.com'
        })
        gauth.then(function(){
          console.log('googleAuth success');
          checkLoginStatus();
        }, function(){
          console.log('googleAuth fail');
        });
      });
    }
  </script>
</body>
</html>