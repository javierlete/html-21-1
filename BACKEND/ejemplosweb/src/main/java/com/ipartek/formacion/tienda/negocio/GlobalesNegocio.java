package com.ipartek.formacion.tienda.negocio;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.DaoRol;
import com.ipartek.formacion.tienda.accesodatos.DaoUsuario;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.accesodatos.FabricaDaoImpl;
import com.ipartek.formacion.tienda.modelos.Rol;
import com.ipartek.formacion.tienda.modelos.Usuario;

public class GlobalesNegocio {
	private static final FabricaDao FAB = new FabricaDaoImpl();
	static final DaoUsuario DAO_USUARIO = FAB.getDaoUsuario();
	static final DaoProducto DAO_PRODUCTO = FAB.getDaoProducto();
	static final DaoRol DAO_ROL = FAB.getDaoRol();
	
	static {
		var admin = DAO_ROL.insertar(Rol.builder().nombre("ADMIN").build());
		var user = DAO_ROL.insertar(Rol.builder().nombre("USER").build());
		
		DAO_USUARIO.insertar(Usuario.builder().email("javier@email.net").password("javier").nombre("Javier Lete").rol(admin).build());
		DAO_USUARIO.insertar(Usuario.builder().email("pepe@email.net").password("pepe").nombre("Pepe Pérez").rol(user).build());
		
	}
}
