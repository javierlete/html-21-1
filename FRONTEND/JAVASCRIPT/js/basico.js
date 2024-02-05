'use strict';

// bases();

let arr = Array(3);

// arrays();

// sentenciasDeControl();

// funciones();

objetos();

function bases() {
    console.log('Hola');

    console.log(nombre);

    nombre = 'Javier';

    console.log(nombre);

    var nombre = 'Pepe';

    console.log(nombre);

    const numero = 5; //+prompt('Introduce un número');



    // numero = 'asdf';
    console.log(typeof numero);

    // if(numero != NaN) {
    if (!isNaN(numero)) {
        console.log(numero + 2);
    } else {
        console.log('No es un número');
    }
}

function arrays() {
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;

    arr[3] = 5;

    arr[8] = 7;

    arr[9] = 'asdfasdf';

    arr['casa'] = 'home';
    arr.perro = 'dog';

    arr.push('Nuevo');

    console.log(arr);

    console.log(arr.casa);
}

function sentenciasDeControl() {
    const mes = 7;
    let dias;

    switch (mes) {
        case 2: dias = 28; break;
        case 4:
        case 6:
        case 9:
        case 11: dias = 30; break;
        default: dias = 31;
    }

    console.log(dias);

    console.log(arr);

    for (let i = 0; i < arr.length; i++) {
        console.log(i, arr[i]);
    }

    for (let clave in arr) {
        console.log(clave, arr[clave]);
    }

    for (let valor of arr) {
        console.log(valor);
    }

    arr.forEach((valor, indice) => {
        console.log('forEach', indice, valor);
    });

    const mapeado = arr.map(valor => valor + 2);

    console.log(mapeado);

    const filtrado = arr.filter(valor => valor > 4);

    console.log(filtrado);

    const reducido = arr.reduce((anterior, actual) => +actual ? anterior + actual: anterior, 0);

    console.log(reducido);

    let anterior = 0;
    for(let actual of arr) {
        anterior = +actual ? anterior + actual: anterior;
    }
}

function funciones() {
    function sumar(a, b) {
        if (b === undefined) {
            b = 0;
        }

        return a + b;
    }

    console.log(typeof sumar);
    console.log(sumar(6, 7));
    console.log(sumar(6));

    let operacion = sumar;

    console.log(typeof operacion, operacion);

    console.log(operacion(6, 3));

    const restar = function(a, b) { return a - b; };

    operacion = restar;

    console.log(operacion(6, 3));

    const multiplicar = (a, b) => a * b;

    operacion = multiplicar;

    console.log(operacion(6, 3));

    operacion = (a, b) => a / b;

    console.log(operacion(6, 3));

    console.log(operacion(6, 0));

    console.log(calcular(5, restar, 2));

    function calcular(a, operacion, b) {
        return operacion(a, b);
    }

    (function() {
        const saludo = 'Hola';
        console.log(saludo);
    })(); // IIFE

    // console.log(saludo);

    console.log(Math.max(3, 5, 6, 8, 7, 56, 4));

    const arr = [3, 5, 6, 8, 7, 56, 4];

    console.log(Math.max(...arr));

    const [primero, segundo, ...resto] = arr;

    console.log(primero, segundo, resto);
}

function objetos() {
    const javier = new Object();

    javier.nombre = 'Javier';
    javier['apellido'] = 'Lete';

    javier.nombreCompleto = function() { return `${this.nombre} ${this.apellido}` };

    console.log(typeof javier, javier, javier.nombreCompleto());

    const juan = { nombre: 'Juan', apellido: 'González' };

    console.log(typeof juan, juan);

    function Persona(nombre, apellido) {
        this.nombre = nombre; this.apellido = apellido;
    }

    Persona.prototype.nombreCompleto = function() { return `${this.nombre} ${this.apellido}` };

    const pepe = new Persona('Pepe', 'Pérez');

    pepe.trabajo = 'Albañil';
    pepe.nombbre = 'Pepillo';

    console.log(typeof pepe, pepe, pepe.nombreCompleto());

    console.log('Hola'.toUpperCase());
    
    String.prototype.toUpperCase = function() { return 'TE JODES'; };
    
    console.log('Hola'.toUpperCase());

    class CPersona {
        constructor(nombre, apellido) {
            this.nombre = nombre; this.apellido = apellido;
        }
        nombreCompleto() { return `${this.nombre} ${this.apellido}`; }
    }

    const pepe2 = new CPersona('Pepe', 'Pérez');

    pepe2.nombbre = 'Pepillo';

    console.log(typeof pepe2, pepe2, pepe2.nombreCompleto());

    const juan2 = new Persona(juan.nombre, juan.apellido);

    console.log(typeof juan2, juan2, juan2.nombreCompleto());
}