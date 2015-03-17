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
	<form action="/VotacionesApp/jsp/votarTema" method="post">
		<fieldset>
    		<legend>Puntuaciones</legend>
    		<c:forEach var="nivelEstudio" items="${verDetallesTemaView.nivelEstudioVotos}" >
    			${nivelEstudio.nombre}:
    			<c:choose>
					<c:when test="${nivelEstudio.mediaVotos==null}">-</c:when>
					<c:otherwise>${nivelEstudio.mediaVotos}</c:otherwise>
				</c:choose>
    		</c:forEach>
    	</fieldset>
		<input type="hidden" name="tema" value="${verDetallesTemaView.id}">
		<input type="submit" value="Votar" />	
	</form>	
	<form action="/VotacionesApp/jsp/verTemas">
    	<input type="submit" value="Atrás">
	</form>	
</body>
</html>