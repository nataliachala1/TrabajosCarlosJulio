// =====================================
// LÓGICA
// =====================================
function calcularSuma(numero1, numero2) {
    return Number(numero1) + Number(numero2)
}

// =====================================
// PRESENTACIÓN
// =====================================
function mostrarSuma() {
    let numero1 = document.getElementById("numero1").value
    let numero2 = document.getElementById("numero2").value
    let resultado = document.getElementById("resultado")

    resultado.textContent = "Resultado: " + calcularSuma(numero1, numero2)
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnSumar").addEventListener("click", mostrarSuma)