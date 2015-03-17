<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validación de identificador</title>
</head>
<body>
	<h1>Eliminar Tema</h1>
	<c:set var="introducirIdentificadorView" scope="request" value="${introducirIdentificadorView}" />
	<form action="/VotacionesApp/jsp/introducirIdentificador" method="post">
		Introduzca código de autorización: <input type="text" name="codigoAutorizacion"><br>
		<input type="submit" value="Enviar">
	</form>
	<p>
		<a href="/VotacionesApp/jsp/home">Atrás</a>
	</p>
</body>
</html>