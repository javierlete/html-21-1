<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>

<base href="${pageContext.request.contextPath}/">

<link href="imgs/icono.svg" rel="icon">

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark mb-3" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">Tienda</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-sm-0">
					<c:if test="${sessionScope.usuario.rol.nombre == 'ADMIN'}">
						<li class="nav-item"><a class="nav-link" href="admin/listado">Productos</a></li>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<li class="navbar-text">${sessionScope.usuario.nombre}</li>
					</c:if>
					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav-item"><a class="nav-link" href="login">Iniciar
									sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Cerrar
									sesión</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>