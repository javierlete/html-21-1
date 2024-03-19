'use strict';

const URL = "http://localhost:8080/ejemplosweb/api/v2/productos/";
const EURO = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR', useGrouping: 'always' });
const FECHA = new Intl.DateTimeFormat('es-ES', { dateStyle: 'full' });

let table, tbody, form, idInput, nombreInput, precioInput, fechaCaducidadInput;

window.addEventListener('DOMContentLoaded', async function() {
	tbody = document.querySelector('tbody');
	table = document.querySelector('table');
	form = document.querySelector('form');

	idInput = document.querySelector('#id');
	nombreInput = document.querySelector('#nombre');
	precioInput = document.querySelector('#precio');
	fechaCaducidadInput = document.querySelector('#fecha');

	listado();

	form.addEventListener('submit', async function(e) {
		e.preventDefault();

		var producto = { nombre: nombreInput.value, precio: precioInput.value };
		
		if(fechaCaducidadInput.value) {
			producto.fechaCaducidad = fechaCaducidadInput.value;
		}

		if (idInput.value) {
			producto.id = idInput.value;
			
			await fetch(URL + producto.id, {
				method: 'PUT',
				body: JSON.stringify(producto),
				headers: {
					'Content-Type': 'application/json', // Tipo de contenido: JSON
				},
			});
		} else {
			await fetch(URL, {
				method: 'POST',
				body: JSON.stringify(producto),
				headers: {
					'Content-Type': 'application/json', // Tipo de contenido: JSON
				},
			});
		}

		listado();
	})
});

async function listado() {
	table.style.display = 'table';
	form.style.display = 'none';

	const respuesta = await fetch(URL);
	const productos = await respuesta.json();

	tbody.innerHTML = '';

	let tr;

	for (const p of productos) {
		tr = document.createElement('tr');

		tr.innerHTML = `
			<th class="text-end">${p.id}</th>
			<td>${p.nombre}</td>
			<td class="text-end">${EURO.format(p.precio)}</td>
			<td class="text-center">${p.fechaCaducidad ? FECHA.format(new Date(p.fechaCaducidad)) : 'NO ESPECIFICADA'}</td>
			<td><a class="btn btn-primary btn-sm"
				href="javascript:formulario(${p.id})">Editar</a> <a
				class="btn btn-danger btn-sm" href="javascript:borrar(${p.id})">Borrar</a></td>
		`;

		tbody.appendChild(tr);
	}
}

async function formulario(idEditar) {
	form.style.display = 'block';
	table.style.display = 'none';

	if (idEditar) {
		const respuesta = await fetch(URL + idEditar);
		const producto = await respuesta.json();

		idInput.value = producto.id;
		nombreInput.value = producto.nombre;
		precioInput.value = producto.precio;
		fechaCaducidadInput.value = producto.fechaCaducidad;
	} else {
		form.reset();
	}
}

async function borrar(id) {
	await fetch(URL + id, { method: 'DELETE' });

	listado();
}