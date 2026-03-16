class Estudiante {
    constructor(nombre, edad, documento, nota) {
        this.nombre = nombre
        this.edad = edad
        this.documento = documento
        this.nota = nota
    }

    mostrarInfo() {
        return `Nombre: ${this.nombre} | Edad: ${this.edad} | Documento: ${this.documento} | Nota: ${this.nota}`
    }

    aprobo() {
        if (this.nota >= 3.0) {
            return "Aprobó el curso "
        } else {
            return "Reprobó el curso "
        }
    }
}

// =====================================
// PRESENTACIÓN
// =====================================
let estudiante = null

function registrarEstudiante() {
    let nombre = document.getElementById("nombre").value
    let edad = Number(document.getElementById("edad").value)
    let documento = document.getElementById("documento").value
    let nota = Number(document.getElementById("nota").value)
    estudiante = new Estudiante(nombre, edad, documento, nota)
    mostrarResultado("Estudiante registrado: " + nombre)
}

function mostrarResultado(mensaje) {
    document.getElementById("resultado").textContent = mensaje
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnRegistrar").addEventListener("click", registrarEstudiante)

document.getElementById("btnMostrarInfo").addEventListener("click", function() {
    mostrarResultado(estudiante.mostrarInfo())
})

document.getElementById("btnAprobo").addEventListener("click", function() {
    mostrarResultado(estudiante.aprobo())
})