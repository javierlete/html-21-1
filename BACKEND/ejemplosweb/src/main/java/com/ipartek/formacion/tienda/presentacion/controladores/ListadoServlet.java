package com.ipartek.formacion.tienda.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		DaoProducto dao = new FabricaDaoImpl().getDaoProducto();
		
		var productos = dao.obtenerTodos();
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listado.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
