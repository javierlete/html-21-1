<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container">

	<h1>Inicio de sesión</h1>

	<form action="login" method="POST">
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="email">Email</label>
			<div class="col">
				<input class="form-control" type="email" id="email" name="email"
					value="${email}" placeholder="Email">
			</div>
		</div>
		<div class="row mb-2">
			<label class="col-sm-2 form-label" for="password">Contraseña</label>
			<div class="col">
				<input class="form-control" type="password"
					id="password" name="password" value=""
					placeholder="Contraseña">
			</div>
		</div>

		<div class="row mb-2">
			<div class="offset-sm-2 col">
				<button class="btn btn-primary">Iniciar sesión</button>
				<div class="text-danger">${error}</div>
			</div>
		</div>


	</form>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>