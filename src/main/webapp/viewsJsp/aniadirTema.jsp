<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Tema</title>
</head>
<body>
	<h1>Añadir Tema</h1>
	<c:set var="verTemasView" scope="request" value="${aniadirTemaView}" />
<%-- 	<div>${aniadirTema.update()}</div> --%>
	<form action="/VotacionesApp/jsp/aniadirTema" method="post">
		Nombre: <input type="text" name="nombreTema"><br>
		Pregunta: <input type="text" name="preguntaTema"><br>
		<input type="submit" value="Añadir">
	</form>
</body>
</html>