$(document).ready(function(){
	  $('#goRight').on('click', function(){
	    $('#slideBox').animate({
	      'marginLeft' : '0'
	    });
	    $('.topLayer').animate({
	      'marginLeft' : '100%'
	    });
	  });
	  $('#goLeft').on('click', function(){
	    $('#slideBox').animate({
	      'marginLeft' : '50%'
	    });
	    $('.topLayer').animate({
	      'marginLeft': '0'
	    });
	  });
	});


//join유효성 검사
function checkz() {     
    var hobbyCheck = false;
    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
    var getName= RegExp(/^[가-힣]+$/);
   
    //이름의 유효성 검사
    if(!getCheck.test($("#id").val())){
      alert("형식에 맞게 입력해주세요");
      $("#id").val("");
      $("#id").focus();
      return false;
    }

    //비밀번호
    if(!getCheck.test($("#pw").val())) {
    alert("형식에 맞춰서 PW를 입력해주세요");
    $("#pw").val("");
    $("#pw").focus();
    return false;
    }

    //아이디랑 비밀번호랑 같은지
    if ($("#id").val()==($("#pw").val())) {
    alert("비밀번호가 ID와 같습니다");
    $("#pw").val("");
    $("#pw").focus();
  }

    //비밀번호 똑같은지
    if($("#pw").val() != ($("#cpass").val())){ 
    alert("비밀번호가 같지 안습니다.");
    $("#pw").val("");
    $("#cpass").val("");
    $("#pw").focus();
    return false;
   }

   //이메일 공백 확인
    if($("#email").val() == ""){
      alert("이메일을 입력해주세요");
      $("#email").focus();
      return false;
    }
         
    //이메일 유효성 검사
    if(!getMail.test($("#email").val())){
      alert("이메일형식에 맞게 입력해주세요")
      $("#email").val("");
      $("#email").focus();
      return false;
    }
    if(check_jumin() ==false){
      return false;
    }
  return true;
} 