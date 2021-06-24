<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>the code</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
   <p class="red">${errorMessage } </p>
	<form method="post" action="/code">
	<label>what is the code?</label>
	<input type="text" name="code">
	<button>Try Code</button>
	</form>
</html>