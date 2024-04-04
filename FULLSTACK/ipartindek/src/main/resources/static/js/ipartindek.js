'use strict';

const URL_CONTACTOS = 'http://localhost:8080/api/contactos';
const URL_GENEROS = 'http://localhost:8080/api/generos';

let usuarioLogin;

window.addEventListener('DOMContentLoaded', function() {
	const sections = document.querySelectorAll('section');

	const loginForm = document.querySelector('form:first-of-type');
	const registroForm = document.querySelector('form:last-of-type');

	const menuLogin = document.querySelector('#menu-login');
	const menuLogout = document.querySelector('#menu-logout');
	const menuRegistro = document.querySelector('#menu-registro');
	const menuUsuario = document.querySelector('#menu-usuario');

	const cards = document.querySelector('#listado>div');

	menuLogout.style.display = 'none';

	loginForm.addEventListener('submit', hacerLogin);

	registroForm.addEventListener('submit', hacerRegistro);

	menuLogin.addEventListener('click', () => mostrar('login'));
	menuLogout.addEventListener('click', logout);
	menuRegistro.addEventListener('click', () => mostrar('login'));

	mostrar('login');

	// FUNCIONES
	function mostrar(id) {
		sections.forEach(s => s.style.display = 'none');

		document.querySelector('#' + id).style.display = null;
	}

	async function listado() {
		const respuesta = await fetch(`${URL_CONTACTOS}/search/congenero`);
		const contactos = await respuesta.json();

		cards.innerHTML = '';

		contactos.forEach(c => tarjetaContacto(c));

		mostrar('listado');
	}

	function tarjetaContacto(c) {
		const div = document.createElement('div');
		div.className = 'col';
		div.innerHTML =
			`
	            <div class="card mb-3">
	                <div class="row g-0">
	                    <div class="col-sm-4">
	                        <img src="https://picsum.photos/600/800?${c.id}" class="img-fluid rounded-start" alt="...">
	                    </div>
	                    <div class="col-sm-8">
	                        <div class="card-body">
	                            <h5 class="card-title">${c.nombre}</h5>
	                            <ul class="list-group list-group-flush">
	                                <li class="list-group-item">${c.genero.nombre}</li>
	                            </ul>
	                            <p class="card-text">${c.descripcion}</p>
	                            <p class="card-text"><small class="text-body-secondary">${c.fechaNacimiento}</small>
	                            </p>
	                            <div class="d-flex justify-content-between">
	                                <div class="form-check form-check-inline fs-2">
	                                    <input class="form-check-input" type="checkbox" value=""
	                                        id="flexCheckDefault">
	                                    <label class="form-check-label" for="flexCheckDefault">
	                                        Me gusta
	                                    </label>
	                                </div>
	                                <div class="form-check form-check-inline form-check-reverse fs-2">
	                                    <input class="form-check-input" type="checkbox" value=""
	                                        id="flexCheckDefault">
	                                    <label class="form-check-label" for="flexCheckDefault">
	                                        Confirmar
	                                    </label>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        `;

		cards.appendChild(div);
	}

	async function hacerLogin(e) {
		e.preventDefault();

		const usuario = { email: loginForm.emailLogin.value, password: loginForm.passwordLogin.value };

		console.log(usuario);

		const respuesta = await fetch(`${URL_CONTACTOS}/search/findByEmail?email=${usuario.email}`);

		let contacto = null;

		if (respuesta.status !== 404) {
			contacto = await respuesta.json();
		}

		if (contacto && contacto.password === usuario.password) {
			login(contacto);
		} else {
			alert('El usuario o la contraseña son incorrectos');
		}
	}

	async function hacerRegistro(e) {
		e.preventDefault();

		const usuario = { 
			email: registroForm.email.value, 
			password: registroForm.password.value, 
			nombre: registroForm.nombre.value, 
			telefono: registroForm.telefono.value, 
			fechaNacimiento: registroForm.fechaNacimiento.value, 
			descripcion: registroForm.descripcion.value, 
			genero: `${URL_GENEROS}/${+registroForm.genero.value}`, 
		};

		console.log(usuario);

		const respuesta = await fetch(URL_CONTACTOS, { 
			method: 'POST', 
			headers: { 'Content-type': 'application/json' }, 
			body: JSON.stringify(usuario) 
		});

		login(await respuesta.json());
	}

	function login(contacto) {
		usuarioLogin = contacto;

		menuUsuario.innerText = usuarioLogin.nombre;

		menuLogout.style.display = null;
		menuLogin.style.display = 'none';

		loginForm.reset();
		registroForm.reset();

		listado();
	}
	
	function logout() {
		usuarioLogin = undefined;
		
		menuUsuario.innerText = '';
		
		menuLogout.style.display = 'none';
		menuLogin.style.display = null;
		
		mostrar('login');
	}
});
