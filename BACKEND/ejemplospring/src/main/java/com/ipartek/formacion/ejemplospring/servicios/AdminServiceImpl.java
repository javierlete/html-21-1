package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Log
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se van a listar los productos");
		return productoRepository.findAll();
	}

	@Override
	public Producto verDetalleProducto(Long id) {
		log.info("Se va a pedir el producto " + id);
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		log.info("Se va a guardar el producto " + producto);
		producto.setId(null);
		return productoRepository.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		log.info("Se va a modificar el producto " + producto);
		return productoRepository.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		log.info("Se va a borrar el producto " + id);
		productoRepository.deleteById(id);
	}
}
