// =====================================
// LÓGICA
// =====================================
function obtenerMensaje(numero) {
    let mensajes = {
        1: "Hello",
        2: "How are you",
        3: "Are you crazy?",
        4: "Yes?",
        5: "Fine"
    }
    return mensajes[numero]
}

// =====================================
// PRESENTACIÓN
// =====================================
function mostrarMensaje(numero) {
    let resultado = document.getElementById("resultado")
    resultado.textContent = obtenerMensaje(numero)
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnMensaje1").addEventListener("click", function() { mostrarMensaje(1) })
document.getElementById("btnMensaje2").addEventListener("click", function() { mostrarMensaje(2) })
document.getElementById("btnMensaje3").addEventListener("click", function() { mostrarMensaje(3) })
document.getElementById("btnMensaje4").addEventListener("click", function() { mostrarMensaje(4) })
document.getElementById("btnMensaje5").addEventListener("click", function() { mostrarMensaje(5) })