<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">Lookify</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/dashboard">Dashboard</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/search/topTen">Top Songs</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="/search/">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</header>
<div class="container">  
<h1>Edit song</h1>
<form:form action="/songs/${song.id}" method="post" modelAttribute="song" >
    <input type="hidden" name="_method" value="post">
    <div class="form-group">
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
        <div class="d-flex justify-content-center my-4">
		  <span class="font-weight-bold indigo-text mr-2 mt-1">1</span>
		    <form:input class="border-0" type="range" min="1" max="10" />
		  <span class="font-weight-bold indigo-text ml-2 mt-1">10</span>
		</div>
    </div>    
    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</div>  