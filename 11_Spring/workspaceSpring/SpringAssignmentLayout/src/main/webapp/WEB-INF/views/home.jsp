<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="bg-dark text-white text-center">${serverTime }</div>
	
	<div class="bg-white text-black text-center text-bottom mt-4 mb-2">스마트 인재 개발원</div>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary mt-0">
		<div class="container-fluid">
		    <a class="navbar-brand" href="/home">스마트 인재개발원</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      	<span class="navbar-toggler-icon"></span>
		    </button>
	    	<div class="collapse navbar-collapse" id="navbarNav">
	      		<ul class="navbar-nav">
		        	<li class="nav-item">
		          		<a class="nav-link active" aria-current="page" href="#">홈</a>
		        	</li>
		        	<li class="nav-item">
		         		<a class="nav-link" href="#">로그인</a>
		        	</li>
		        	<li class="nav-item">
		          		<a class="nav-link" href="#">커뮤니티</a>
		        	</li>
	     		</ul>
	    	</div>
	  	</div>
	</nav>
	
	
	<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
