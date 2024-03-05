<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de productos</title>
</head>
<body>
	<h1>Formulario de productos</h1>

	<form action="formulario" method="POST">
		<input readonly type="number" name="id" value="${producto.id}" placeholder="Id"> <input
			type="text" name="nombre" value="${producto.nombre}" placeholder="Nombre"> <input
			type="number" step=".01" min="0" name="precio" value="${producto.precio}" placeholder="Precio">
		<input type="date" name="fecha" value="${producto.fechaCaducidad}" placeholder="Fecha de caducidad">

		<button>Guardar</button>
	</form>

</body>
</html>