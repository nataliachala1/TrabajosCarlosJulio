class Producto {
    constructor(cantidad, precio, nombre) {
     this.cantidad = cantidad
     this.precio = precio
     this.nombre = nombre
    }

    consultar() {
        return `Nombre: ${this.nombre} | Precio: $${this.precio} | Cantidad: ${this.cantidad}`
    }
    calcularValorTotal() {
         return this.precio * this.cantidad
}
}

let producto = null

function registrarProducto() {
    let cantidad = Number(document.getElementById("cantidad").value)
    let precio = Number(document.getElementById("precio").value)
    let nombre = (document.getElementById("nombre").value)
    producto = new Producto(cantidad, precio, nombre)
    mostrarResultado(mensaje)
        document.getElementById("resultado").textContent = mensaje
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnRegistrar").addEventListener("click", function() {
    registrarProducto()
    mostrarResultado("Producto registrado: " + producto.nombre)
})

document.getElementById("btnConsultar").addEventListener("click", function() {
    mostrarResultado(producto.consultar())
})

document.getElementById("btnCalcularValorTotal").addEventListener("click", function() {
    mostrarResultado("Valor total del inventario: $" + producto.calcularValorTotal())
})