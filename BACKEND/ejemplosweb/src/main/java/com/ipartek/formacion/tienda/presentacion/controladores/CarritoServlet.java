package com.ipartek.formacion.tienda.presentacion.controladores;

import java.io.IOException;
import java.util.Map;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DaoProducto dao = new FabricaDao().getDaoProducto();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String op = request.getParameter("op");

		@SuppressWarnings("unchecked")
		var carrito = (Map<Long, Producto>) request.getSession().getAttribute("carrito");

		if (sId != null) {
			var id = Long.parseLong(sId);

			if (op != null && "quitar".equals(op)) {
				carrito.remove(id);
			} else {
				var producto = dao.obtenerPorId(id);

				carrito.put(producto.getId(), producto);
			}
		}

		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}