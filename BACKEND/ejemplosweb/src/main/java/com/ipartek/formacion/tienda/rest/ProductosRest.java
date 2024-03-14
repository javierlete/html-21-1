package com.ipartek.formacion.tienda.rest;

import static com.ipartek.formacion.tienda.presentacion.controladores.GlobalesControladores.ADMIN_NEGOCIO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/productos")
public class ProductosRest {
	
	static {
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto1").precio(new BigDecimal("1234")).build());
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto2").precio(new BigDecimal("2234")).build());
		ADMIN_NEGOCIO.agregarProducto(Producto.builder().nombre("Producto3").precio(new BigDecimal("3234")).fechaCaducidad(LocalDate.now().plusYears(1)).build());
	}
	
	@GET
	public Iterable<Producto> get() {
		return ADMIN_NEGOCIO.listarProductos();
	}
	
	@GET
	@Path("{id}")
	public Producto getId(@PathParam("id") Long id) {
		var producto = ADMIN_NEGOCIO.verDetalleProducto(id);
		
		if(producto == null) {
			throw new NotFoundException();
		}
		
		return producto;
	}
	
	@POST
	public Response post(Producto producto) {
		return Response.status(Status.CREATED).entity(ADMIN_NEGOCIO.agregarProducto(producto)).build();
	}
	
	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		producto.setId(id);
		
		return ADMIN_NEGOCIO.modificarProducto(producto);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		ADMIN_NEGOCIO.borrarProducto(id);
	}
}
