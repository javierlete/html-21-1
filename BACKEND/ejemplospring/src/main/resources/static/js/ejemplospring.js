const URL = 'http://localhost:8080/api/v2/productos'

window.addEventListener('DOMContentLoaded', async function() {
	const ul = document.querySelector('main>ul');
	
	console.log(ul);
	
	const respuesta = await fetch(URL);
	const datos = await respuesta.json();
	
	const productos = datos._embedded.productos;
	
	productos.forEach(p => {
		const li = document.createElement('li');
		li.innerHTML = `${p.nombre}: ${p.precio} (${p.fechaCaducidad})`;
		
		ul.appendChild(li);
	});
});