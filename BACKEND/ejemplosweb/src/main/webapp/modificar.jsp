<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.tienda.accesodatos.*,modelos.*, java.math.*, java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar producto</title>
</head>
<body>
	<h1>Modificar producto</h1>

	<form action="modificar.jsp" method="POST">
		<input type="number" name="id" placeholder="Id"> <input
			type="text" name="nombre" placeholder="Nombre"> <input
			type="number" step=".01" min="0" name="precio" placeholder="Precio">
		<input type="date" name="fecha" placeholder="Fecha de caducidad">

		<button>Modificar</button>
	</form>

	<%
	String sId = request.getParameter("id");
	String nombre = request.getParameter("nombre");
	String sPrecio = request.getParameter("precio");
	String sFecha = request.getParameter("fecha");

	if (sId != null) {

		Long id = Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);
		LocalDate fecha = LocalDate.parse(sFecha);

		Producto producto = new Producto(id, nombre, precio, fecha);

		DaoProducto dao = new FabricaDao().getDaoProducto();

		producto = dao.modificar(producto);
	}
	%>

</body>
</html>