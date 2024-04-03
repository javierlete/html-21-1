'use strict';

const URL_CONTACTOS = 'http://localhost:8080/api/contactos';
const URL_GENEROS = 'http://localhost:8080/api/generos';

const contactos = [
    { id: 1, email: 'javier@email.net', password: 'javier', nombre: 'Javier Lete', genero: 'Hombre', fechaNacimiento: '2000-01-02', descripcion: 'Yo soy muy guay' },
    { id: 2, email: 'pepe@email.net', password: 'pepe', nombre: 'Pepe Pérez', genero: 'Hombre', fechaNacimiento: '2002-03-04', descripcion: 'Yo soy muy guay' },
    { id: 3, email: 'ines@email.net', password: 'ines', nombre: 'Inés González', genero: 'Mujer', fechaNacimiento: '2005-06-07', descripcion: 'Yo soy muy guay' },
];

let usuarioLogin;

window.addEventListener('DOMContentLoaded', function () {
    const sections = document.querySelectorAll('section');

    const loginForm = document.querySelector('form:first-of-type');
    const registroForm = document.querySelector('form:last-of-type');
    
    const menuLogin = document.querySelector('#menu-login');
    const menuLogout = document.querySelector('#menu-logout');
    const menuUsuario = document.querySelector('#menu-usuario');

    const cards = document.querySelector('#listado>div');

	menuLogout.style.display = 'none';

    loginForm.addEventListener('submit', async function (e) {
        e.preventDefault();

        const usuario = { email: loginForm.emailLogin.value, password: loginForm.passwordLogin.value };
        
        console.log(usuario);
        
        const respuesta = await fetch(`${URL_CONTACTOS}/search/findByEmail?email=${usuario.email}`);
        
        let contacto = null;
        
        if(respuesta.status !== 404) {
        	contacto = await respuesta.json();            
		}
        
        if(contacto && contacto.password === usuario.password) {
            usuarioLogin = contacto;
            
            menuUsuario.innerText = usuarioLogin.nombre;
            
            menuLogout.style.display = null;
            menuLogin.style.display = 'none';
            
            listado();
        } else {
            alert('El usuario o la contraseña son incorrectos');
        }
    });

    registroForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const usuario = { email: registroForm.email.value, password: registroForm.password.value, genero: registroForm.genero.value, nombre: registroForm.nombre.value, telefono: registroForm.telefono.value, fechaNacimiento: registroForm.fechaNacimiento.value, descripcion: registroForm.descripcion.value };

        const id = Math.max(...contactos.map(c => c.id)) + 1;

        usuario.id = id;

        console.log(usuario);

        contactos.push(usuario);

        usuarioLogin = usuario;

        listado();
    });


    mostrar('login');

    function mostrar(id) {
        sections.forEach(s => s.style.display = 'none');

        document.querySelector('#' + id).style.display = 'block';
    }

    async function listado() {
        const respuesta = await fetch(URL_CONTACTOS);
        const objeto = await respuesta.json();
        const contactos = objeto._embedded.contactos;

        cards.innerHTML = '';

        contactos.forEach(c => {
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
                                        <li class="list-group-item">${c.genero}</li>
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
        });

        mostrar('listado');
    }
});

