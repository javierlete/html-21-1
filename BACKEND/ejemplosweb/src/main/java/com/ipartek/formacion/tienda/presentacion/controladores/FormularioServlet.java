package com.ipartek.formacion.tienda.presentacion.controladores;

import static com.ipartek.formacion.tienda.presentacion.controladores.GlobalesControladores.ADMIN_NEGOCIO;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeMap;

import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

@WebServlet("/admin/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		if(sId != null) {
			Long id = Long.parseLong(sId);
			
			request.setAttribute("producto", ADMIN_NEGOCIO.verDetalleProducto(id));
		}
		
		request.setAttribute("hoy", LocalDate.now());
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sFecha = request.getParameter("fecha");

		BigDecimal precio = sPrecio.trim().length() == 0 ? null : new BigDecimal(sPrecio);
		LocalDate fecha = sFecha.trim().length() == 0 ? null : LocalDate.parse(sFecha);
		
		Producto producto = new Producto(null, nombre, precio, fecha);

        var validador = Validation.buildDefaultValidatorFactory().getValidator();
		
        Set<ConstraintViolation<Producto>> violaciones = validador.validate(producto);
        
        var errores = new TreeMap<String, String>();
        
        for(ConstraintViolation<Producto> violacion: violaciones) {
        	errores.put(violacion.getPropertyPath().toString(), violacion.getMessage());
        }
        
        for(var error: errores.entrySet()) {
        	System.out.println(error.getKey());
        	System.out.println(error.getValue());
        }
        
        if(errores.size() > 0) {
        	request.setAttribute("errores", errores);
        	request.setAttribute("producto", producto);
        	
        	request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);
        	return;
        }
        
		if(sId.trim().length() != 0) {
			Long id = Long.parseLong(sId);
			
			producto.setId(id);
			
			ADMIN_NEGOCIO.modificarProducto(producto);
		} else {
			ADMIN_NEGOCIO.agregarProducto(producto);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}
}
