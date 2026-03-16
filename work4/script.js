class Producto {
    constructor(nombre, precio) {
        this.nombre = nombre
        this.precio = precio
    }
}

class Carrito {
    constructor() {
        this.productos = []
    }

    agregar(producto) {
        this.productos.push(producto)
        return "Producto agregado: " + producto.nombre
    }

    eliminar(nombre) {
        this.productos = this.productos.filter(p => p.nombre !== nombre)
        return "Producto eliminado: " + nombre
    }

    calcularTotal() {
        let total = 0
        this.productos.forEach(p => total += p.precio)
        return total
    }
}

// =====================================
// PRESENTACIÓN
// =====================================
let carrito = new Carrito()

function mostrarResultado(mensaje) {
    document.getElementById("resultado").textContent = mensaje
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnAgregar").addEventListener("click", function() {
    let nombre = document.getElementById("nombre").value
    let precio = Number(document.getElementById("precio").value)
    let producto = new Producto(nombre, precio)
    mostrarResultado(carrito.agregar(producto))
})

document.getElementById("btnEliminar").addEventListener("click", function() {
    let nombre = document.getElementById("nombreEliminar").value
    mostrarResultado(carrito.eliminar(nombre))
})

document.getElementById("btnCalcularTotal").addEventListener("click", function() {
    mostrarResultado("Total del carrito: $" + carrito.calcularTotal())
})