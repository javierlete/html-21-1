package com.ipartek.formacion.tienda.presentacion;

import static com.ipartek.formacion.bibliotecas.Consola.leerDecimal;
import static com.ipartek.formacion.bibliotecas.Consola.leerFecha;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.leerLong;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;
import static com.ipartek.formacion.bibliotecas.Consola.pl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.entidades.Producto;

public class PresentacionConsola {

	private static final int LISTADO = 1;
	private static final int SALIR = 0;
	private static final int BUSCAR_ID = 2;
	private static final int INSERTAR = 3;
	private static final int MODIFICAR = 4;
	private static final int BORRAR = 5;

	private static final DaoProducto DAO = new FabricaDao().getDaoProducto();
	
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion != SALIR);
	}
	
	private static void mostrarMenu() {
		pl();
		pl("MENU");
		pl("----");
		pl("1. LISTADO");
		pl("2. BUSCAR POR ID");
		pl();
		pl("3. INSERTAR");
		pl("4. MODIFICAR");
		pl("5. BORRAR");
		pl();
		pl("0. SALIR");
		pl();
	}

	private static int pedirOpcion() {
		return leerInt("Introduce la opción que deseas");
	}

	private static void ejecutarOpcion(int opcion) {
		pl();
		
		switch(opcion) {
		case LISTADO:
			listado();
			break;
		case BUSCAR_ID:
			buscarId();
			break;
		case INSERTAR:
			insertar();
			break;
		case MODIFICAR:
			modificar();
			break;
		case BORRAR:
			borrar();
			break;
		case SALIR:
			pl("Gracias por usar esta aplicación");
			break;
		default:
			pl("No se reconoce la opción " + opcion);
		}
	}

	private static void listado() {
		pl("*LISTADO*");
		
		for(Producto p: DAO.obtenerTodos()) {
			mostrarLinea(p);
		}
	}

	private static void mostrarLinea(Producto p) {
		pl(p);
	}

	private static void buscarId() {
		pl("*BUSCAR POR ID*");
		
		long id = leerLong("Dime el id a buscar");
		
		Producto producto = DAO.obtenerPorId(id);
		
		mostrarFicha(producto);
	}

	private static void mostrarFicha(Producto producto) {
		if(producto == null) {
			pl("No hay ningún producto que mostrar");
			return;
		}
		
		pl(producto);
	}

	private static void insertar() {
		pl("*INSERTAR*");
		
		Producto p = new Producto();
		
		p.setNombre(leerString("Nombre"));
		p.setFechaCaducidad(leerFecha("Fecha de caducidad"));
		p.setPrecio(leerDecimal("Precio"));
		
		DAO.insertar(p);
	}

	private static void modificar() {
		pl("*MODIFICAR*");
		
		Producto p = new Producto();
		
		p.setId(leerLong("Id"));
		p.setNombre(leerString("Nombre"));
		p.setFechaCaducidad(leerFecha("Fecha de caducidad"));
		p.setPrecio(leerDecimal("Precio"));
		
		DAO.modificar(p);
	}

	private static void borrar() {
		pl("*BORRAR*");
		
		long id = leerLong("Dime el id a borrar");
		
		DAO.borrar(id);
	}

	public static void mainPrueba(String[] args) {
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
