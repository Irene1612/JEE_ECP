<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar Tema</title>
</head>
<body>
	<c:set var="votarTemaView" scope="request" value="${votarTemaView}" />
	<div>${votarTemaView.update()}</div>
	<h1>${votarTemaView.tema.nombre}</h1>
	<h2>${votarTemaView.tema.pregunta}</h2>
	<form action="/VotacionesApp/jsp/votarTema" method="post">
		Seleccione una puntuaci�n para votar este tema:
		<select name="valoracion">
		<c:forEach var="i" begin="0" end="10">
			<option value="${i}">${i}</option>
		</c:forEach>
		</select><br>
		Seleccione el nivel de estudios:
		<select name="nivelEstudios">
			<option value="SIN_ESTUDIOS">Sin estudios</option>	
			<option value="ESO">Eso</option>	
			<option value="BACHILLERATO_FP">Bachillerato-FP</option>	
			<option value="UNIVERSITARIO">Universitario</option>		
		</select>
		<input type="hidden" name="tema" value="${votarTemaView.id}">
		<input type="submit" value="Votar">
	</form>
	<form action="/VotacionesApp/jsp/verDetallesTema">
		<input type="hidden" name="tema" value="${votarTemaView.id}">
    	<input type="submit" value="Atr�s">
	</form>
</body>
</html>
