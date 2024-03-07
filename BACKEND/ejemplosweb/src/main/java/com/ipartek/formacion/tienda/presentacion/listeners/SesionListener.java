package com.ipartek.formacion.tienda.presentacion.listeners;

import java.util.TreeMap;

import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	var carrito = new TreeMap<Long, Producto>();
    	
    	se.getSession().setAttribute("carrito", carrito);
    }

}
