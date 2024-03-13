<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main>
	<h1>Formulario de productos</h1>

	<p>
	${errores}
	${errores.fechaCaducidad}
	</p>

	<form action="admin/formulario" method="POST"
		class="container needs-validation" novalidate>
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
				<input class="form-control" type="text" id="nombre"
					name="nombre" value="${producto.nombre}" placeholder="Nombre">
				<div class="invalid-feedback">El nombre es obligatorio</div>
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="precio">Precio</label>
			<div class="col">
				<input class="form-control" type="number" step=".01"
<<<<<<< HEAD
					id="precio" name="precio" value="${producto.precio}"
=======
					min="0" id="precio" name="precio" value="${producto.precio}"
>>>>>>> branch 'main' of https://github.com/javierlete/html-21-1
					placeholder="Precio">
				<div class="invalid-feedback">El precio es obligatorio y debe
					ser positivo</div>
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="fecha">Fecha de
				caducidad</label>
			<div class="col">
				<input class="form-control"
					type="date" id="fecha" name="fecha"
					value="${producto.fechaCaducidad}" placeholder="Fecha de caducidad">
				<div class="invalid-feedback">La fecha de caducidad debe ser
					como mínimo de hoy</div>
			</div>
		</div>

		<div class="row mb-2">
			<div class="offset-sm-2 col">
				<button class="btn btn-primary">Guardar</button>
			</div>
		</div>


	</form>

	<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
	</script>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>