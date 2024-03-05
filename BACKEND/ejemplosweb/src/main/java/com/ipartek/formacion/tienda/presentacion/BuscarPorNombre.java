package com.ipartek.formacion.tienda.presentacion;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscar")
public class BuscarPorNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		
		out.append(String.format("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Búsqueda por nombre</title>
					<meta charset="UTF-8">
				</head>
				<body>
					<h1>Buscando por el nombre %s</h1>
					
					<ul>
					""", nombre));
		
		DaoProducto dao = new FabricaDao().getDaoProducto();
		
		for(Producto p: dao.buscarPorNombre(nombre)) {
			out.append(String.format("<li>%s</li>\n", p));
		}
		
		out.append("""
				</ul>
				</body>
				</html>
				""");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
