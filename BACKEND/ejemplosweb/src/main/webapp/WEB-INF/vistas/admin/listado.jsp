<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<main>
	<h1>Listado de productos</h1>

	<table class="table table-hover table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th class="text-center">Fecha de caducidad</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th class="text-end">${p.id}</th>
					<td>${p.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${p.precio}" /></td>
					<td class="text-center"><javatime:format
							pattern="d' de 'MMMM' de 'yyyy" value="${p.fechaCaducidad}" /></td>
					<td><a class="btn btn-primary btn-sm"
						href="admin/formulario?id=${p.id}">Editar</a> <a
						class="btn btn-danger btn-sm" href="admin/borrar?id=${p.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-primary btn-sm" href="admin/formulario">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>