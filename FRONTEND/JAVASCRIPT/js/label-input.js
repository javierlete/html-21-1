class LabelInput extends HTMLElement {
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
        const i = this.getAttribute('i');
        const tipo = this.getAttribute('tipo');
        const paso = this.getAttribute('paso');
        const minimo = this.getAttribute('minimo');
        const requerido = this.getAttribute('requerido');
        const soloLectura = this.getAttribute('solo-lectura');
        const error = this.getAttribute('error');
        const ancho = this.getAttribute('ancho') ?? 2;

        this.innerHTML = `
            <div class="row mb-3">
                <label for="${i}" class="col-sm-${ancho} col-form-label">${texto}</label>
                <div class="col-sm">
                    <input class="form-control" ${paso ? `step="${paso}"` : ''} ${minimo ? `min="${minimo}"` : ''} ${soloLectura ? 'readonly' : ''} ${requerido ? 'required' : ''} id="${i}" type="${tipo}" name="${i}" placeholder="${texto}">
                    ${error ? `<div class="invalid-feedback">${error}</div>`: ''}
                </div>
            </div>
            `;
    }

}

customElements.define('jl-label-input', LabelInput);