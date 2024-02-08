// var URL = 'http://localhost:3000/productos/';

$(function() {
    $('main>section').hide();
    $('#principal').show();
    
    $('#menu-principal').on('click', function() {
        $('main>section').hide();
        $('#principal').show();
    });
    
    $('#menu-administracion').on('click', function() {
        $('main>section').hide();
        $('#admin').show();
    });

    $.getJSON(URL).done(function(productos) {
        $('#principal>div').empty();

        $(productos).each(function() {
            $('#principal>div').append($(`<jl-tarjeta nombre="${this.nombre}" precio="${this.precio}"></jl-tarjeta>`));
        });
    }).fail(function() {
        $('#principal>div').empty();
        
        $('body>nav').after($('<jl-alerta mensaje="No se han podido cargar los datos" tipo="danger"></jl-alerta>'));
    });
});
