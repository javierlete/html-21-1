package com.ipartek.formacion.tienda.presentacion.controladores;

import com.ipartek.formacion.tienda.negocio.AdminNegocio;
import com.ipartek.formacion.tienda.negocio.AdminNegocioImpl;
import com.ipartek.formacion.tienda.negocio.AnonimoNegocio;
import com.ipartek.formacion.tienda.negocio.AnonimoNegocioImpl;

public class GlobalesControladores {
	static final AnonimoNegocio ANONIMO_NEGOCIO = new AnonimoNegocioImpl();
	static final AdminNegocio ADMIN_NEGOCIO = new AdminNegocioImpl();
}
