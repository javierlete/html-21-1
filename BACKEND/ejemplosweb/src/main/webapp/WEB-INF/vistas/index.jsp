<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container-fluid">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
					<div class="card-body text-center">
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text"><fmt:formatNumber type="currency" value="${p.precio}"/></p>
						<p class="card-text"><a href="carrito?id=${p.id}" class="stretched-link btn btn-primary w-100">Agregar al carrito</a></p>
					</div>
					<div class="card-footer text-center">
						<small class="text-body-secondary text-center"><javatime:format pattern="d' de 'MMMM' de 'yyyy" value="${p.fechaCaducidad}"/></small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>