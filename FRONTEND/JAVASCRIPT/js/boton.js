class Boton extends HTMLElement {
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
        const sm = this.getAttribute('sm');
        const href = this.getAttribute('href');

        if(href) {
            this.innerHTML = `
                <a href="${href}" class="btn btn-primary ${sm ? 'btn-sm' : ''}">${texto}</a>
                `;
        } else {
            this.innerHTML = `
                <button class="btn btn-primary ${sm ? 'btn-sm' : ''}">${texto}</button>
                `;
        }
    }
}

customElements.define("jl-boton", Boton);
