// =====================================
// LÓGICA
// =====================================
let clics = 0

function incrementarClics() {
    clics++
    return clics
}

// =====================================
// PRESENTACIÓN
// =====================================
function mostrarClics() {
    let contador = document.getElementById("contador")
    contador.textContent = "Clics: " + incrementarClics()
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("boton").addEventListener("click", mostrarClics)