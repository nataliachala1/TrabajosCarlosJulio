class Vehiculo {
    constructor(nombre, velocidad, estado) {
        this.nombre = nombre
        this.velocidad = velocidad
        this.estado = estado
    }

    acelerar(cantidad) {
        this.velocidad += cantidad
        return "Velocidad actual: " + this.velocidad + " km/h"
    }

    frenar(cantidad) {
        if (this.velocidad - cantidad < 0) {
            this.velocidad = 0
            return "El vehículo está detenido"
        }
        this.velocidad -= cantidad
        return "Velocidad actual: " + this.velocidad + " km/h"
    }

    mostrarEstado() {
        return `Nombre: ${this.nombre} | Velocidad: ${this.velocidad} km/h | Estado: ${this.estado}`
    }
}

// =====================================
// PRESENTACIÓN
// =====================================
let vehiculo = null

function mostrarResultado(mensaje) {
    document.getElementById("resultado").textContent = mensaje
}

function crearVehiculo() {
    let nombre = document.getElementById("nombre").value
    let velocidad = Number(document.getElementById("velocidad").value)
    vehiculo = new Vehiculo(nombre, velocidad, "En marcha")
    mostrarResultado("Vehículo creado: " + nombre)
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnCrear").addEventListener("click", crearVehiculo)

document.getElementById("btnAcelerar").addEventListener("click", function() {
    let cantidad = Number(document.getElementById("cantidad").value)
    mostrarResultado(vehiculo.acelerar(cantidad))
})

document.getElementById("btnFrenar").addEventListener("click", function() {
    let cantidad = Number(document.getElementById("cantidad").value)
    mostrarResultado(vehiculo.frenar(cantidad))
})

document.getElementById("btnMostrarEstado").addEventListener("click", function() {
    mostrarResultado(vehiculo.mostrarEstado())
})