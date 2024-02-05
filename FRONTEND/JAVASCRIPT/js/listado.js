'use strict';

const URL = 'json/productos.json';

window.addEventListener('DOMContentLoaded', async function() {
    const tbody = document.querySelector('tbody');

    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    console.log(productos);

    for(const producto of productos) {
        console.log(producto);

        const tr = document.createElement('tr');

        tr.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
        `;

        tbody.appendChild(tr);
    }


});