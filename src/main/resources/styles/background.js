document.addEventListener('DOMContentLoaded', function () {
    const box = document.querySelector('.box');
    const botonesEmociones = document.querySelector('.botonesEmociones');

    box.addEventListener('animationend', function () {
        // La animación de .box ha terminado, mostramos los botones
        botonesEmociones.classList.add('botonesEmociones-show');
    });
});
