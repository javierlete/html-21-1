package com.ipartek.formacion.tienda.presentacion.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if("javier@email.net".equals(email) && "contra".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			response.sendRedirect(request.getContextPath() + "/admin/listado");
		} else {
			request.setAttribute("email", email);
			request.setAttribute("error", "Email o contraseña incorrectos");
			
			request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
		}
	}
}