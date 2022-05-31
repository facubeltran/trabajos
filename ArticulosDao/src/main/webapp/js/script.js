var ajax;

function sumar() {
    url = 'http://localhost:8080/calculadora?nro1=' +
        document.getElementById('numero1').value +
        '&nro2=' +
        document.getElementById('numero2').value;
    //console.log('url=',url);
    ajax = new XMLHttpRequest();
    ajax.addEventListener('load', cargarValores);
    ajax.open('GET', url);
    ajax.send();
}

function cargarValores() {
    document.getElementById('resultado').innerHTML = ajax.response;
}