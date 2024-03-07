package com.ipartek.formacion.tienda.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final DaoProducto dao = new FabricaDao().getDaoProducto();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		if(sId != null) {
			Long id = Long.parseLong(sId);
			
			request.setAttribute("producto", dao.obtenerPorId(id));
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sFecha = request.getParameter("fecha");

		BigDecimal precio = new BigDecimal(sPrecio);
		LocalDate fecha = sFecha.trim().length() == 0 ? null : LocalDate.parse(sFecha);
		
		Producto producto = new Producto(null, nombre, precio, fecha);

		if(sId.trim().length() != 0) {
			Long id = Long.parseLong(sId);
			
			producto.setId(id);
			
			dao.modificar(producto);
		} else {
			dao.insertar(producto);
		}
		
		response.sendRedirect(request.getContextPath() + "/listado");
	}
}
