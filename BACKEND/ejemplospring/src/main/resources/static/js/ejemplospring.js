'use strict';

const URL = 'http://localhost:8080/api/v2/productos'
let sections, cards, tbody;
let form, inputId, inputNombre, inputPrecio, inputFechaCaducidad;

window.addEventListener('DOMContentLoaded', async function() {
	sections = document.querySelectorAll('section');
	cards = document.querySelector('#index>div');
	tbody = document.querySelector('#productos tbody');

	form = document.querySelector('form');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputPrecio = document.querySelector('#precio');
	inputFechaCaducidad = document.querySelector('#fechaCaducidad');

	index();
});

async function index() {
	const respuesta = await fetch(URL);
	const datos = await respuesta.json();

	const productos = datos._embedded.productos;

	cards.innerHTML = '';

	productos.forEach(p => {
		const card = document.createElement('div');
		card.className = 'col';
		card.innerHTML = `
			<div class="card h-100">
				<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
				<div class="card-body text-center">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">${p.precio}</p>
					<p class="card-text">
						<a href="carrito?id=${p.id}"
							class="stretched-link btn btn-primary w-100">Agregar al
							carrito</a>
					</p>
				</div>
				<div class="card-footer text-center">
					<small class="text-body-${p.fechaCaducidad ? 'secondary' : 'tertiary'} text-center">${p.fechaCaducidad ?? 'No tiene caducidad'}</small>
				</div>
			</div>`;

		cards.appendChild(card);
	});

	mostrar('index');
}

async function productos() {
	const respuesta = await fetch(URL);
	const datos = await respuesta.json();

	const productos = datos._embedded.productos;

	tbody.innerHTML = '';

	productos.forEach(p => {
		const tr = document.createElement('tr');
		tr.innerHTML = `
			<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end">${p.precio} €</td>
				<td>${p.fechaCaducidad}</td>
				<td><a class="btn btn-primary btn-sm"
					href="javascript:formulario(${p.id})">Editar</a> <a
					class="btn btn-danger btn-sm"
					href="javascript:borrar(${p.id})">Borrar</a></td>`;

		tbody.appendChild(tr);
	});

	mostrar('productos');
}

async function borrar(id) {
	const respuesta = await fetch(`${URL}/${id}`, { method: 'DELETE' });
	if (!respuesta.ok) {
		alert('Ha fallado el borrado');

		console.error(respuesta);

		return;
	}

	productos();
}

async function formulario(id) {
	if (id) {
		const respuesta = await fetch(`${URL}/${id}`);
		const producto = await respuesta.json();

		console.log(producto);

		inputId.value = producto.id;
		inputNombre.value = producto.nombre;
		inputPrecio.value = producto.precio;
		inputFechaCaducidad.value = producto.fechaCaducidad;
	}

	mostrar('formulario');
}

async function guardar() {
	const producto = { nombre: inputNombre.value, precio: +inputPrecio.value, fechaCaducidad: inputFechaCaducidad.value };

	if (inputId.value) {
		producto.id = +inputId.value;

		console.log(producto);

		const respuesta = await fetch(`${URL}/${producto.id}`, {
			method: 'PUT',
			body: JSON.stringify(producto),
			headers: {
				'Content-type': 'application/json'
			}
		});

		console.log(respuesta);
	} else {
		await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(producto),
			headers: {
				'Content-type': 'application/json'
			}
		});
	}

	inputId.value = '';
	inputNombre.value = '';
	inputPrecio.value = '';
	inputFechaCaducidad.value = '';

	productos();
}

function mostrar(id) {
	sections.forEach(section => section.style.display = 'none');

	document.getElementById(id).style.display = 'block';
}