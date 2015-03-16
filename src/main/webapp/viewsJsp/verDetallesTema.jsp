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
	<c:set var="verDetallesTemaView" scope="request" value="${verDetallesTemaView}" />
<%-- 	<div>${verDetallesTemaView.update()}</div> --%>
	<h1>${verDetallesTemaView.tema.nombre}</h1>
	<form action="/VotacionesApp/jsp/votarTemas" method="post">
		
		<input type="submit" value="Votar" />	
	</form>
	<p>
		<a href="/VotacionesApp/jsp/verTemas">Atrás</a>
	</p>
</body>
</html>