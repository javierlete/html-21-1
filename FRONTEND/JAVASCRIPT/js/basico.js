'use strict';

console.log('Hola');

console.log(nombre);

nombre = 'Javier';

console.log(nombre);

var nombre = 'Pepe';

console.log(nombre);

const numero = +prompt('Introduce un número');

// numero = 'asdf';

console.log(typeof numero);

// if(numero != NaN) {
if(!isNaN(numero)) {
    console.log(numero + 2);
} else {
    console.log('No es un número');
}
