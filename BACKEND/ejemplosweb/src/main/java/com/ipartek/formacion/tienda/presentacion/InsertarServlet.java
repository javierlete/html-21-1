package com.ipartek.formacion.tienda.presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDaoImpl;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertar")
public class InsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sFecha = request.getParameter("fecha");
		
		BigDecimal precio = new BigDecimal(sPrecio);
		LocalDate fecha = LocalDate.parse(sFecha);
		
		Producto producto = new Producto(null, nombre, precio, fecha);
		
		DaoProducto dao = new FabricaDaoImpl().getDaoProducto();
		
		producto = dao.insertar(producto);
		
		out.append(String.format("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Inserción de producto</title>
					<meta charset="UTF-8">
				</head>
				<body>
					<h1>Producto insertado</h1>
					
					<dl>
						<dt>Id</dt>
						<dd>%s</dd>
						<dt>Nombre</dt>
						<dd>%s</dd>
						<dt>Precio</dt>
						<dd>%s</dd>
						<dt>Fecha de caducidad</dt>
						<dd>%s</dd>
					</dl>
				</body>
				</html>
				""", producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getFechaCaducidad()));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
