package com.ipartek.formacion.tienda.presentacion.filtros;

import java.io.IOException;

import com.ipartek.formacion.tienda.modelos.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1979910050604147826L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		// HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		var usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || !usuario.getRol().getNombre().equals("ADMIN")) {
			request.setAttribute("error", "Debes iniciar sesión y ser administrador para poder entrar en la parte de administración");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
			
			return;
		}
		
		chain.doFilter(request, response);
	}
}
