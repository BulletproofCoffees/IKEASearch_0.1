<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p>${sessionScope.loginName}</p>
<script src="http://platform.fatsecret.com/js?key=12f21072d2d94cc882af1325c617262c"></script>

<span id="food_title"></span>
<div id="nutrition_panel"></div>




										
<c:forEach items="${ikea}" var="ikea">

<P>${ikea.imglest}</P>
<P>${ikea.href}</P>
<P>${ikea.alt}</P>
<P>${ikea.pricelist}</P>

</c:forEach>



<div class="imglest">
</div>


<script>
/* $(function(){
	var a =  $('#productLists'); 
    alert(a); 
}); */


</script>
<script>
fatsecret.addRef("foodtitle", "food_title");
fatsecret.addRef("nutritionpanel", "nutrition_panel");
</script>
<script>fatsecret.writeHolder("foodtitle");</script>
<script>fatsecret.writeHolder("nutritionpanel");</script>


