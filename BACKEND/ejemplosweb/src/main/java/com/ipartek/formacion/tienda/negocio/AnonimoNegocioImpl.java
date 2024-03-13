package com.ipartek.formacion.tienda.negocio;

import static com.ipartek.formacion.tienda.negocio.GlobalesNegocio.DAO_PRODUCTO;
import static com.ipartek.formacion.tienda.negocio.GlobalesNegocio.DAO_USUARIO;

import com.ipartek.formacion.tienda.modelos.Producto;
import com.ipartek.formacion.tienda.modelos.Usuario;

public class AnonimoNegocioImpl implements AnonimoNegocio {
	
	@Override
	public Usuario verificarLogin(String email, String password) {
		Usuario usuario = DAO_USUARIO.buscarPorEmail(email);
		
		if(usuario == null || !usuario.getPassword().equals(password)) {
			return null;
		}
		
		return usuario;
	}

	@Override
	public Iterable<Producto> listarProductos() {
		return DAO_PRODUCTO.obtenerTodos();
	}

	@Override
	public Producto verDetalleProducto(Long id) {
		return DAO_PRODUCTO.obtenerPorId(id);
	}

	@Override
	public Iterable<Producto> listarProductosCarrito() {
		throw new NegocioException("NO IMPLEMENTADO");
	}

	@Override
	public void agregarProductoACarrito(Producto producto) {
		throw new NegocioException("NO IMPLEMENTADO");		
	}

}
