<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalles Tema</title>
</head>
<body>	
	<c:set var="verDetallesTemaView" scope="request" value="${verDetallesTemaView}" />
	<div>${verDetallesTemaView.update()}</div>
	<h1>${verDetallesTemaView.tema.nombre}</h1>
	<h2>${verDetallesTemaView.tema.pregunta}</h2>
	<p>Numero de votos: ${verDetallesTemaView.numeroVotos}</p>
	<form action="/VotacionesApp/jsp/votarTema" method="get">
		<fieldset>
    		<legend>Puntuaciones</legend>
    		Sin estudios: 
    		<c:choose>
				<c:when test="${verDetallesTemaView.mediaPorNivelEstudios[0]==0}">-</c:when>
				<c:otherwise>${verDetallesTemaView.mediaPorNivelEstudios[0]}</c:otherwise>
			</c:choose>
    		Eso: 
    		<c:choose>
				<c:when test="${verDetallesTemaView.mediaPorNivelEstudios[1]==0}">-</c:when>
				<c:otherwise>${verDetallesTemaView.mediaPorNivelEstudios[1]}</c:otherwise>
			</c:choose>    		
    		Bachillerato-FP: 
			<c:choose>
				<c:when test="${verDetallesTemaView.mediaPorNivelEstudios[2]==0}">-</c:when>
				<c:otherwise>${verDetallesTemaView.mediaPorNivelEstudios[2]}</c:otherwise>
			</c:choose>  
    		Universitario: 
			<c:choose>
				<c:when test="${verDetallesTemaView.mediaPorNivelEstudios[3]==0}">-</c:when>
				<c:otherwise>${verDetallesTemaView.mediaPorNivelEstudios[3]}</c:otherwise>
			</c:choose>
    	</fieldset>
		<input type="hidden" name="tema" value="${verDetallesTemaView.id}">
		<input type="submit" value="Votar" />	
	</form>	
	<form action="/VotacionesApp/jsp/verTemas">
    	<input type="submit" value="Atrás">
	</form>	
</body>
</html>