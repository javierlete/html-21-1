package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Carrito;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;
import com.ipartek.formacion.ejemplospring.repositorios.UsuarioRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {
	@Autowired
	private Carrito carrito;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Usuario verificarLogin(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null || !usuario.getPassword().equals(password)) {
			return null;
		}

		return usuario;
	}

	@Override
	public Iterable<Producto> listarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto verDetalleProducto(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Producto> listarProductosCarrito() {
		return carrito.getProductos();
	}

	@Override
	public void agregarProductoACarrito(Producto producto) {
		carrito.getProductos().add(producto);
	}

	@Override
	public void agregarProductoACarrito(Long idProducto) {
		var producto = verDetalleProducto(idProducto);
		agregarProductoACarrito(producto);
	}

	@Override
	public void quitarProductoDeCarrito(Long id) {
		carrito.getProductos().removeIf(p -> p.getId().equals(id));
	}

}
