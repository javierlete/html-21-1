'use strict';

window.addEventListener('DOMContentLoaded', function() {
    const h1 = document.querySelector('h1');
    console.log(h1.innerText);

    h1.innerText = 'Ya no hace falta mirar la consola';

    const form = document.querySelector('#form-saludo');
    const input = document.querySelector('#nombre');

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        console.log(input.value);

        const span = document.createElement('span');

        span.innerText = `Hola ${input.value}`;

        form.appendChild(span);
    });
});