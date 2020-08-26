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
	<h2 class="text-center">Lista Publicaciones</h2>
<p><a href="carga">Cargar datos</a>


<table class="table table-sm">
		<thead class="thead-dark">
		<tr>
			<th colspan="4"><h3>Publicaciones</h3></th>
			
		</tr>
		</thead>		
		<tbody>
		<tr>
			<td>
				<c:forEach items="${publicaciones}" var="p">
					<tr class="table-primary">
						<td  colspan="2"><strong><c:out	value="${p.getTitle()}" /></strong></td>
						<td><i class="fas fa-user-edit"></i> <c:out value="${p.getUsername()}" /></td>
						<td>
							<a href="detalle/${p.getId()}">
							<i class="fas fa-comments"></i> <c:out value="${p.getIdcomment()}" />
							</a>
						</td>
					</tr>
					<tr>
						<td colspan="4"><c:out value="${p.getBody()}" /><hr width="50%"></td>
					</tr>
				</c:forEach>
			</td>
		</tr>
		
		</tbody>
	</table>





	
</div>
</body>
</html>