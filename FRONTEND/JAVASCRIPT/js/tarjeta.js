class Tarjeta extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <div class="col">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">${this.getAttribute('nombre')}</h5>
                    </div>
                    <div class="card-footer">
                        <small class="text-body-secondary">${this.getAttribute('precio')}</small>
                    </div>
                </div>
            </div>`;
    }
}

customElements.define('jl-tarjeta', Tarjeta);