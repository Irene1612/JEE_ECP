<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Tema</title>
</head>
<body>
	<h1>Eliminar Tema</h1>
	<c:set var="eliminarTemaView" scope="request" value="${eliminarTemaView}" />
	<div>${eliminarTemaView.update()}</div>
	<form action="/VotacionesApp/jsp/eliminarTema" method="post">
		<c:choose>
			<c:when test="${eliminarTemaView.hayTemas==false}">
				<p>${eliminarTemaView.errorMsg}</p>
			</c:when>
			<c:otherwise>
				<select name="tema">
					<c:forEach var="tema" items="${eliminarTemaView.temas}">
						<option value="${tema.id}">${tema.nombre}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Eliminar" />
			</c:otherwise>			
		</c:choose>				
	</form>
	<form action="/VotacionesApp/jsp/home">
    	<input type="submit" value="Atrás">
	</form>
</body>
</html>