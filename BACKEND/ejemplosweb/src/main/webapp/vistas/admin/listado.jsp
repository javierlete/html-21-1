<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>
	<h1>Listado de productos</h1>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Fecha de caducidad</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td>${p.fechaCaducidad}</td>
					<td><a href="formulario?id=${p.id}">Editar</a> <a href="borrar?id=${p.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="formulario">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
	<%-- <%
			@SuppressWarnings("unchecked")
			Iterable<Producto> productos = (Iterable<Producto>)request.getAttribute("productos");
		
			for(Producto p: productos) {
		%>
		<li><%= p %></li>
		<%
			}
		%> --%>


</body>
</html>