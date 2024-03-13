package com.ipartek.formacion.tienda.negocio;

import com.ipartek.formacion.tienda.modelos.Producto;
import com.ipartek.formacion.tienda.modelos.Usuario;

import static com.ipartek.formacion.tienda.negocio.GlobalesNegocio.*;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto verDetalleProducto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Producto> listarProductosCarrito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarProductoACarrito(Producto producto) {
		// TODO Auto-generated method stub
		
	}

}
