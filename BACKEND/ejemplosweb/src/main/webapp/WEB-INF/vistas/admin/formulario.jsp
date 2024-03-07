<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
<main>
	<h1>Formulario de productos</h1>

	<form action="formulario" method="POST" class="container">
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="id">Id</label>
			<div class="col">
				<input class="form-control" readonly type="number" id="id" name="id"
					value="${producto.id}" placeholder="Id">
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="nombre">Nombre</label>
			<div class="col">
				<input class="form-control" type="text" id="nombre" name="nombre"
					value="${producto.nombre}" placeholder="Nombre">
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="precio">Precio</label>
			<div class="col">
				<input class="form-control" type="number" step=".01" min="0" id="precio" name="precio"
					value="${producto.precio}" placeholder="Precio">
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="fecha">Fecha de caducidad</label>
			<div class="col">
				<input class="form-control" type="date" id="fecha" name="fecha"
					value="${producto.fechaCaducidad}" placeholder="Fecha de caducidad">
			</div>
		</div>
		
		<div class="row mb-2">
			<div class="offset-sm-2 col">
				<button class="btn btn-primary">Guardar</button>
			</div>
		</div>

		
	</form>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>