<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
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
<form id="login_form">
<input type="text" value="username"> <br/>
<input type="password" value="password"> <br/>
<button type="submit">Log In</button>
</form>
</div>
<!-- Login form end -->

</div>
<!-- Header end -->

<!-- Main menu start -->
<div id="menu">
<a href="/MyDay/new_post">New post</a> | <a href="/MyDay/edit_post/23">Edit post</a> | <a href="/MyDay/delete_post">Delete post</a>
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

<!-- Single news block start -->
<div id="news">
<div id="news_top"><p>$_TITLE</p></div>

<hr class="style-two">

<div id="news_text">
Russia's main consumer watchdog has temporarily shut four McDonald's restaurants in Moscow as part of an investigation into food standards.

Watchdog Rospotrebnadzor claimed the restaurants had breached "numerous" sanitary laws.

McDonald's said it was looking at the complaints, adding its "top priority is to provide safe and quality products".

The closures come amid rising tensions between Russia and the West over the crisis in the Ukraine. <br/><br/>

Previously when diplomatic tensions are high, the regulator has controversially banned products including wine from Georgia, cheese from Ukraine and apples from Poland, according to BBC Moscow correspondent Daniel Sandford.

Earlier this month, Russia imposed a "full embargo" on food imports from the EU, US and some other Western countries, in response to sanctions over Ukraine.

Wednesday's action by the regulator is part of an ongoing investigation into McDonald's food standards in Russia.

In July the watchdog filed a lawsuit in Moscow urging the restaurant 
</div>

<hr class="style-two">

<div id="news_bottom">Date published: $_DATE | Comment ($_COM)</div>
</div>
<!-- Single news block end -->

<!-- Single news block start -->
<div id="news">
<div id="news_top"><p>$_TITLE</p></div>

<hr class="style-two">

<div id="news_text">
Russia's main consumer watchdog has temporarily shut four McDonald's restaurants in Moscow as part of an investigation into food standards.

Watchdog Rospotrebnadzor claimed the restaurants had breached "numerous" sanitary laws.

McDonald's said it was looking at the complaints, adding its "top priority is to provide safe and quality products".

The closures come amid rising tensions between Russia and the West over the crisis in the Ukraine. <br/><br/>

Previously when diplomatic tensions are high, the regulator has controversially banned products including wine from Georgia, cheese from Ukraine and apples from Poland, according to BBC Moscow correspondent Daniel Sandford.

Earlier this month, Russia imposed a "full embargo" on food imports from the EU, US and some other Western countries, in response to sanctions over Ukraine.

Wednesday's action by the regulator is part of an ongoing investigation into McDonald's food standards in Russia.

In July the watchdog filed a lawsuit in Moscow urging the restaurant 
</div>

<hr class="style-two">

<div id="news_bottom">Date published: $_DATE | Comment ($_COM)</div>
</div>
<!-- Single news block end -->

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
