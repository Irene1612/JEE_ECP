<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temas</title>
</head>
<body>
	<h1>Temas</h1>
	<c:set var="verTemasView" scope="request" value="${verTemasView}" />
	<div>${verTemasView.update()}</div>
	<form action="/VotacionesApp/jsp/verTemas" method="post">
		<c:choose>
			<c:when test="${verTemasView.hayTemas==false}">
				<p>${verTemasView.errorMsg}</p>
			</c:when>
			<c:otherwise>
				<select name="tema">
					<c:forEach var="tema" items="${verTemasView.temas}">
						<option value="${tema.id}">${tema.nombre}</option>
					</c:forEach>
				</select>
			</c:otherwise>
		</c:choose>		
	</form>
</body>
</html>