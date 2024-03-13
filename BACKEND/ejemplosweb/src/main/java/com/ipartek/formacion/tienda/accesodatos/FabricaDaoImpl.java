package com.ipartek.formacion.tienda.accesodatos;

import java.io.IOException;
import java.util.Properties;

public class FabricaDaoImpl implements FabricaDao {
	private DaoProducto daoProducto = null;
	private DaoUsuario daoUsuario = null;
	private DaoRol daoRol = null;
	
	public FabricaDaoImpl() {
		Properties props = new Properties();
		
		try {
			props.load(FabricaDaoImpl.class.getClassLoader().getResourceAsStream("tienda.properties"));
			
			String tipo = props.getProperty("accesodatos.tipo");
			String baseDeDatos = props.getProperty("accesodatos.bdd");
			String usuario = props.getProperty("accesodatos.usuario");
			String password = props.getProperty("accesodatos.password");
			
			
			switch(tipo) {
			case "treemap":
				daoProducto = DaoProductoTreeMap.getInstancia();
				break;
			case "fichero":
				daoProducto = new DaoProductoFichero(baseDeDatos);
				break;
			case "sqlite":
				daoProducto = new DaoProductoSqlite(baseDeDatos);
				break;
			case "mysql":
				daoProducto = new DaoProductoMySql(baseDeDatos, usuario, password);
				break;
			case "jpa":
				daoProducto = new DaoProductoJpa();
				daoUsuario  = new DaoUsuarioJpa();
				daoRol = new DaoRolJpa();
				break;
			default:
				throw new AccesoDatosException("No se reconoce el tipo " + tipo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public DaoProducto getDaoProducto() {
		return daoProducto;
	}

	@Override
	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	@Override
	public DaoRol getDaoRol() {
		return daoRol ;
	}
}
