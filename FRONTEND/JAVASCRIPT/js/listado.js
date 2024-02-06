'use strict';

const URL = 'http://localhost:3000/productos/';

let form, id, nombre, precio, tbody;

window.addEventListener('DOMContentLoaded', async function() {
    form = document.querySelector('form');

    id = document.querySelector('#id');
    nombre = document.querySelector('#nombre');
    precio = document.querySelector('#precio');

    form.style.display = 'none';

    tbody = document.querySelector('tbody');

    await listado();

    form.addEventListener('submit', async function(evento) {
        evento.preventDefault();

        const producto = {
            nombre: nombre.value,
            precio: precio.value
        };

        if(id.value) {
            producto.id = id.value;
            
            const respuesta = await fetch(URL + id.value, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(producto)
            });
        } else {
            const respuesta = await fetch(URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(producto)
            });
        }

        await listado();

        form.style.display = 'none';

    });

    
});

async function listado() {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    console.log(productos);

    tbody.innerHTML = '';

    for (const producto of productos) {
        console.log(producto);

        const tr = document.createElement('tr');

        tr.dataset.id = producto.id;

        tr.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>
                <a href="javascript:formulario('${producto.id}')">Editar</a>
                <a href="javascript:borrar('${producto.id}')">Borrar</a>
            </td>
        `;

        tbody.appendChild(tr);
    }
}

async function formulario(idRecibido) {
    form.style.display = 'block';

    if(idRecibido) {
        id.value = idRecibido;

        const respuesta = await fetch(URL + idRecibido);
        const producto = await respuesta.json();

        nombre.value = producto.nombre;
        precio.value = producto.precio;
    } else {
        form.reset();
    }
}

async function borrar(id) {
    const respuesta = await fetch(URL + id, {
        method: 'DELETE'
    });

    if(respuesta.ok) {
        document.querySelector(`tr[data-id="${id}"]`).remove();
    }
}