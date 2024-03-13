package com.ipartek.formacion.tienda.presentacion.controladores;

import static com.ipartek.formacion.tienda.presentacion.controladores.GlobalesControladores.ANONIMO_NEGOCIO;

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
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		var usuario = ANONIMO_NEGOCIO.verificarLogin(email, password);
		
		if(usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("email", email);
			request.setAttribute("error", "Email o contraseña incorrectos");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}
}