<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tema 1</title>
</head>
<body>
	<h1>Tema 1</h1>
	<c:set var="verTemasView" scope="request" value="${verDetallesTemaView}" />
<%-- 	<div>${verDetallesTemaView.update()}</div> --%>
	<form action="/VotacionesApp/jsp/votarTemas" method="post">
		
		<input type="submit" value="Votar" />	
	</form>
	<p>
		<a href="/VotacionesApp/jsp/verTemas">Atr�s</a>
	</p>
</body>
</html>