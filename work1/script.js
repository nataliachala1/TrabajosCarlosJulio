class CuentaBancaria {
    constructor(titular, saldo) {
     this.titular = titular
     this.saldo = saldo
    }

    depositar(monto) {
         this.saldo += monto
     }
retirar(monto) {
    if (monto > this.saldo) {
     return "Saldo insuficiente"
    }
     this.saldo -= monto
     return "Retiro exitoso"
}
consultarSaldo() {
     return this.saldo
}
}


// =====================================
// PRESENTACIÓN
// =====================================
let cuenta = null

function crearCuenta() {
    let titular = document.getElementById("titular").value
    let saldo = Number(document.getElementById("saldo").value)
    cuenta = new CuentaBancaria(titular, saldo)
    mostrarResultado("Cuenta creada para " + titular + " con saldo: $" + saldo)
}

function mostrarResultado(mensaje) {
    document.getElementById("resultado").textContent = mensaje
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("btnCrear").addEventListener("click", crearCuenta)
document.getElementById("btnDepositar").addEventListener("click", function() {
    let monto = Number(document.getElementById("monto").value)
    cuenta.depositar(monto)
    mostrarResultado("Depósito exitoso. Saldo actual: $" + cuenta.consultarSaldo())
})

document.getElementById("btnRetirar").addEventListener("click", function() {
    let monto = Number(document.getElementById("monto").value)
    let resultado = cuenta.retirar(monto)
    mostrarResultado(resultado + ". Saldo actual: $" + cuenta.consultarSaldo())
})

document.getElementById("btnConsultar").addEventListener("click", function() {
    mostrarResultado("Saldo de " + cuenta.titular + ": $" + cuenta.consultarSaldo())
})