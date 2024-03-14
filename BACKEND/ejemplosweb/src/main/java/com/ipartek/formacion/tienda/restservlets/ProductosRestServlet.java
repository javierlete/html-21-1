package com.ipartek.formacion.tienda.restservlets;

import static com.ipartek.formacion.tienda.presentacion.controladores.GlobalesControladores.ADMIN_NEGOCIO;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.catalina.connector.Response;

import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/productos/*")
public class ProductosRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Jsonb JSON = JsonbBuilder.create();
	
	static {
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto1").precio(new BigDecimal("1234")).build());
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto2").precio(new BigDecimal("2234")).build());
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto3").precio(new BigDecimal("3234")).fechaCaducidad(LocalDate.now().plusYears(1)).build());
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		Long id = obtenerId(request);
		
		if(id != null) {
			var producto = ADMIN_NEGOCIO.verDetalleProducto(id);
			
			if(producto == null) {
				response.setStatus(Response.SC_NOT_FOUND);
				
				return;
			}
			
			response.getWriter().append(JSON.toJson(producto));
			
			return;
		}
		
		var productos = ADMIN_NEGOCIO.listarProductos();
		
		String json = JSON.toJson(productos);
		
		response.getWriter().append(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		var producto = JSON.fromJson(request.getInputStream(), Producto.class);
		
		ADMIN_NEGOCIO.agregarProducto(producto);
		
		response.setStatus(Response.SC_CREATED);
		response.getWriter().append(JSON.toJson(producto));
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		Long id = obtenerId(request);
		
		var producto = JSON.fromJson(request.getInputStream(), Producto.class);

		producto.setId(id);
		
		ADMIN_NEGOCIO.modificarProducto(producto);
		
		response.getWriter().append(JSON.toJson(producto));
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = obtenerId(request);
		
		ADMIN_NEGOCIO.borrarProducto(id);
		
		response.setStatus(Response.SC_NO_CONTENT);
	}
	
	private Long obtenerId(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null || pathInfo.trim().length() == 0) {
			return null;
		}
		
		return Long.valueOf(pathInfo.substring(1));
	}
}
