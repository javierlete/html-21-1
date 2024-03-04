package com.ipartek.formacion.tienda.accesodatos;

import java.io.IOException;
import java.util.Properties;

public class FabricaDao {
	private DaoProducto daoProducto = null;
	
	public FabricaDao() {
		Properties props = new Properties();
		
		try {
			props.load(FabricaDao.class.getClassLoader().getResourceAsStream("tienda.properties"));
			
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
			default:
				throw new AccesoDatosException("No se reconoce el tipo " + tipo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DaoProducto getDaoProducto() {
		return daoProducto;
	}
}
