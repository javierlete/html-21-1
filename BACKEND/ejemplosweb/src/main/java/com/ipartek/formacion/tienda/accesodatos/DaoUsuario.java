package com.ipartek.formacion.tienda.accesodatos;

import com.ipartek.formacion.tienda.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario buscarPorEmail(String email);
}
