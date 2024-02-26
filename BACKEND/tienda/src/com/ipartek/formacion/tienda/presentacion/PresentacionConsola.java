package com.ipartek.formacion.tienda.presentacion;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.entidades.Producto;

public class PresentacionConsola {

	public static void main(String[] args) {
		FabricaDao fabrica = new FabricaDao();
		DaoProducto dao = fabrica.getDaoProducto(); // DaoProductoTreeMap.getInstancia();
		
		for(Producto p: dao.obtenerTodos()) {
			System.out.println(p);
		}
		
		Producto p = dao.obtenerPorId(2L);
		
		System.out.println(p);
		
		dao.insertar(new Producto(null, "Producto Nuevo", new BigDecimal("1234"), LocalDate.now()));
		
		dao.modificar(new Producto(3L, "Modificado", new BigDecimal("4321"), LocalDate.now()));
		
		dao.borrar(1L);

		for(Producto producto: dao.obtenerTodos()) {
			System.out.println(producto);
		}
	}

}
