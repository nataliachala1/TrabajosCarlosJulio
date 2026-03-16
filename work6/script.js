class Libro {
    constructor(titulo, autor, estado) {
        this.titulo = titulo
        this.autor = autor
        this.estado = estado
    }

    prestar() {
        if (this.estado === "No disponible") {
            return "El libro ya está prestado"
        }
        this.estado = "No disponible"
        return "Libro prestado: " + this.titulo
    }

    devolver() {
        if (this.estado === "Disponible") {
            return "El libro ya está disponible"
        }
        this.estado = "Disponible"
        return "Libro devuelto: " + this.titulo
    }

    mostrarEstado() {
        return `Título: ${this.titulo} | Autor: ${this.autor} | Estado: ${this.estado}`
    }
}

// =====================================
// PRESENTACIÓN
// =====================================
let libro = null

function mostrarResultado(mensaje) {
    document.getElementById("resultado").textContent = mensaje
}

function registrarLibro() {
    let titulo = document.getElementById("titulo").value
    let autor = document.getElementById("autor").value
    libro = new Libro(titulo, autor, "Disponible")
    mostrarResultado("Libro registrado: " + titulo)
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnRegistrarLibro").addEventListener("click", registrarLibro)

document.getElementById("btnPrestar").addEventListener("click", function() {
    mostrarResultado(libro.prestar())
})

document.getElementById("btnDevolver").addEventListener("click", function() {
    mostrarResultado(libro.devolver())
})

document.getElementById("btnConsultarInfo").addEventListener("click", function() {
    mostrarResultado(libro.mostrarEstado())
})