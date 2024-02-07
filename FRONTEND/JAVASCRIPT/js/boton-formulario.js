class BotonFormulario extends HTMLElement {
    constructor() {
        super();
        this.observer = new MutationObserver(() => this.sePuedeLeerElInterior());
    }

    connectedCallback() {
        this.observer.observe(this, { childList: true });
    }

    sePuedeLeerElInterior() {
        this.observer.disconnect();
        
        const texto = this.innerHTML;
        const ancho = this.getAttribute('ancho') ?? 2;

        this.innerHTML = `
        <div class="row mb-3">
            <div class="offset-sm-${ancho} col-sm">
                <button class="btn btn-primary">${texto}</button>
            </div>
        </div>`
    }
}

customElements.define("jl-boton-formulario", BotonFormulario);
