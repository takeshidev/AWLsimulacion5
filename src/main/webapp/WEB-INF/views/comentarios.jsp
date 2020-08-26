<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulacion 5 - TK</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
		<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
		<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="contenido">
	<h1 class="text-center">Simulación 5</h1>
	<h2 class="text-center">Comentarios</h2>


<table class="table table-sm">
		<thead class="thead-dark">
		<tr>
			<th colspan="3"><h3>${titulo}</h3></th>
			
		</tr>
		<tr>
			<th>id</th>
			<th>Email</th>
			<th>Mensaje (20)</th>
		</tr>
		</thead>		
		<tbody>
		<tr>
			<td>
				<c:forEach items="${comentarios}" var="c">
					<tr>
						<td><c:out value="${c.getId()}" /></td>
						<td><c:out value="${c.getEmail()}" /></td>
						<td><c:out value="${c.getVeinte()}" /></td>
					</tr>
				</c:forEach>
			</td>
		</tr>
		
		</tbody>
	</table>
	<a class="btn btn-primary text-center"
				href="${pageContext.request.contextPath}/" role="button">Volver</a>





	
</div>
</body>
</html>