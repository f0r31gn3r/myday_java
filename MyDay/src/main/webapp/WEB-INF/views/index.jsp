<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"> </script>

  <script>
  jQuery(function($) {

		$("a.topopup").click(function() {
				loading(); // loading
				setTimeout(function(){ // then show popup, deley in .5 second
					loadPopup(); // function show popup
				}, 500); // .5 second
		return false;
		});

		/* event for close the popup */
		$("div.close").hover(
						function() {
							$('span.ecs_tooltip').show();
						},
						function () {
	    					$('span.ecs_tooltip').hide();
	  					}
					);

		$("div.close").click(function() {
			disablePopup();  // function close pop up
		});

		$(this).keyup(function(event) {
			if (event.which == 27) { // 27 is 'Ecs' in the keyboard
				disablePopup();  // function close pop up
			}
		});

	        $("div#backgroundPopup").click(function() {
			disablePopup();  // function close pop up
		});

		$('a.livebox').click(function() {
			alert('Hello World!');
		return false;
		});

		 /************** start: functions. **************/
		function loading() {
			$("div.loader").show();
		}
		function closeloading() {
			$("div.loader").fadeOut('normal');
		}

		var popupStatus = 0; // set value

		function loadPopup() {
			if(popupStatus == 0) { // if value is 0, show popup
				closeloading(); // fadeout loading
				$("#toPopup").fadeIn(0500); // fadein popup div
				$("#backgroundPopup").css("opacity", "0.7"); // css opacity, supports IE7, IE8
				$("#backgroundPopup").fadeIn(0001);
				popupStatus = 1; // and set value to 1
			}
		}

		function disablePopup() {
			if(popupStatus == 1) { // if value is 1, close popup
				$("#toPopup").fadeOut("normal");
				$("#backgroundPopup").fadeOut("normal");
				popupStatus = 0;  // and set value to 0
			}
		}
		/************** end: functions. **************/
	}); // jQuery End
  </script>
	
	<style type="text/css">
	#site{
		width:70%;
		margin-left:auto;
		margin-right:auto;
	}
	#header{
	height:auto;
	overflow:hidden;
	}
	#title{
	float:left;
	}
	#login{
		border:1px solid #cecece;
		border-radius:10px;
		box-shadow: 3px 3px 3px #888888;
		padding: 10px 10 10px 10;
		width:30%;
		margin-left:5%;
		margin-right:auto;
		float:left;
	}
	#menu{
	}
	#search{
	}
	#news{
	border:1px solid #cecece;
		border-radius:10px;
		box-shadow: 3px 3px 3px #888888;
		padding: 10px 10 10px 10;
		margin: 20px auto 20px auto;
	}
p{
	text-align:center;
	}
#news_text{
	margin:10px 10px 10px 10px;
	font-size:14px;
	}
	#news_bottom{
	width:350px;
	margin-left:auto;
	font-size: 12px;
	}
	#page_counter{
	font-size:12px;
	}
	#footer{
		margin: 10px auto 10px auto;
		font-size:12px;
	}
	hr.style-six {
    border: 0;
    height: 0;
    border-top: 1px solid rgba(0, 0, 0, 0.1);
    border-bottom: 1px solid rgba(255, 255, 255, 0.3);
    }
    hr.style-two {
    border: 0;
    height: 1px;
    background-image: -webkit-linear-gradient(left, rgba(0,0,0,0), rgba(0,0,0,0.75), rgba(0,0,0,0)); 
    background-image:    -moz-linear-gradient(left, rgba(0,0,0,0), rgba(0,0,0,0.75), rgba(0,0,0,0)); 
    background-image:     -ms-linear-gradient(left, rgba(0,0,0,0), rgba(0,0,0,0.75), rgba(0,0,0,0)); 
    background-image:      -o-linear-gradient(left, rgba(0,0,0,0), rgba(0,0,0,0.75), rgba(0,0,0,0)); 
	}
	#toPopup {
    font-family: "lucida grande",tahoma,verdana,arial,sans-serif;
    background: none repeat scroll 0 0 #FFFFFF;
    border: 10px solid #ccc;
    border-radius: 3px 3px 3px 3px;
    color: #333333;
    display: none;
    font-size: 14px;
    left: 50%;
    margin-left: -402px;
    position: fixed;
    top: 20%;
    width: 800px;
    z-index: 2;
}
div.loader {
    background: url("") no-repeat scroll 0 0 transparent;
    height: 32px;
    width: 32px;
    display: none;
    z-index: 9999;
    top: 40%;
    left: 50%;
    position: absolute;
    margin-left: -10px;
}
div.close {
    background: url("") no-repeat scroll 0 0 transparent;
    cursor: pointer;
    height: 30px;
    position: absolute;
    right: -27px;
    top: -24px;
    width: 30px;
}
span.ecs_tooltip {
    background: none repeat scroll 0 0 #000000;
    border-radius: 2px 2px 2px 2px;
    color: #FFFFFF;
    display: none;
    font-size: 11px;
    height: 16px;
    opacity: 0.7;
    padding: 4px 3px 2px 5px;
    position: absolute;
    right: -62px;
    text-align: center;
    top: -51px;
    width: 93px;
}
span.arrow {
    border-left: 5px solid transparent;
    border-right: 5px solid transparent;
    border-top: 7px solid #000000;
    display: block;
    height: 1px;
    left: 40px;
    position: relative;
    top: 3px;
    width: 1px;
}
div#popup_content {
    margin: 4px 7px;
    /* remove this comment if you want scroll bar
    overflow-y:scroll;
    height:200px
    */
	</style>
	
</head>
<body>

<!-- Site code start -->
<div id="site">

<!-- Header start -->
<div id="header">

<!-- Title start -->
<div id="title">
<h1>
	MyDay Java Bootcamp Project  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</div>
<!-- Title end -->

<!-- Login form start -->
<div id="login">
<%@include file="authorization.jsp" %>
</div>
<!-- Login form end -->

</div>
<!-- Header end -->

<!-- Main menu start -->
<div id="menu">
<a href="#id=new" class="topopup">New post</a>
<div id="toPopup"> 
    	
        <div class="close"></div>
       	<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
		<div id="popup_content"> <!--your content start-->
		
		<%@include file="new_post.jsp" %>
		
         </div> <!--your content end-->
    
    </div> <!--toPopup end-->
    
	<div class="loader"></div>
   	<div id="backgroundPopup"></div> 
</div>
<!-- Main menu end -->

<hr class="style-six"/>

<!-- Main body start -->
<div id="body">

<!-- Search start -->
<div id="search">
<form id="search_form">
<input type="text" value="Search"> <button type="submit">Search</button>
</form>
</div>
<!-- Search end -->

<!-- News start -->
<%@include file="posts.jsp" %>
<!-- News end -->

<!-- Page counter start -->
<div id="page_counter">
<p>[1][2][3]</p>
</div>
<!-- Page counter end -->

</div>
<!-- Main body end -->

<hr class="style-six"/>

<!-- Footer start -->
<div id="footer">
<p>All rights reserved (c) 2014 Riga, LV</p>
</div>
<!-- Footer end -->

</div>
<!-- Site code end -->
   
</body>
</html>
