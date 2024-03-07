<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main>
	<h1>Carrito</h1>

	<table class="table">
		<thead>
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th class="text-center">Fecha de caducidad</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrito.values()}" var="p">
				<tr>
					<th class="text-end">${p.id}</th>
					<td>${p.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${p.precio}" /></td>
					<td class="text-center"><javatime:format
							pattern="d' de 'MMMM' de 'yyyy" value="${p.fechaCaducidad}" /></td>
					<td><a class="btn btn-danger btn-sm"
						href="carrito?op=quitar&id=${p.id}">Quitar del carrito</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-primary btn-sm" href="index">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>