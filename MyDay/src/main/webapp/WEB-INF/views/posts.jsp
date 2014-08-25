<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
<%@ page session="true" %>

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
	#backgroundPopup {
    z-index:1;
    position: fixed;
    display:none;
    height:100%;
    width:100%;
    background:#000000;
    top:0px;
    left:0px;
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
}
</style>
<%
PostDAOImpl p = new PostDAOImpl();
List <Post> posts = p.findLatestPosts();

for (int i = 0; i < posts.size(); i++){
%>
	<div id="news">
   <div id="news_top"><p><a href="?page=post&id=<%=posts.get(i).getPostID()%>"> <%=posts.get(i).getTitle() %> </a></p></div>
   <hr class="style-two">
   
    

<div id="news_text">
<%=posts.get(i).getBody() %>
</div>

<hr class="style-two">

<div id="news_bottom">Date published: <%=posts.get(i).getCreated() %> | Comment ($_COM)</div>

</div>
<% } %>