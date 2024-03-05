<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.tienda.accesodatos.*,modelos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>
	<h1>Listado de productos</h1>
	
	<ul>
		<%
			DaoProducto dao = new FabricaDao().getDaoProducto();
			
			for(Producto p: dao.obtenerTodos()) {
		%>
		<li><%= p %></li>
		<%
			}
		%>
	</ul>
	

</body>
</html>