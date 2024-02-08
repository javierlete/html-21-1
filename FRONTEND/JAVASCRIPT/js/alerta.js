class Alerta extends HTMLElement {
    connectedCallback() {
        const mensaje = this.getAttribute('mensaje');
        const tipo = this.getAttribute('tipo');

        this.innerHTML = 
        `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
            <strong>${mensaje}</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>`
    }
}

customElements.define('jl-alerta', Alerta);