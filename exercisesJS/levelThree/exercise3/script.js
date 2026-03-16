// 1. Capturamos los elementos
let btnIniciar = document.getElementById("btnIniciar")
let btnDetener = document.getElementById("btnDetener")
let btnReiniciar = document.getElementById("btnReiniciar")
let tiempo = document.getElementById("tiempo")

// 2. Variables necesarias
let contador = 0
let intervalo = null

// 3. Iniciar
btnIniciar.addEventListener("click", function() {
    // Evita que se creen múltiples intervalos
    if (intervalo !== null) return

    intervalo = setInterval(function() {
        contador++
        tiempo.textContent = contador + " segundos"
    }, 1000)
})

// 4. Detener
btnDetener.addEventListener("click", function() {
    clearInterval(intervalo)
    intervalo = null
})

// 5. Reiniciar
btnReiniciar.addEventListener("click", function() {
    clearInterval(intervalo)
    intervalo = null
    contador = 0
    tiempo.textContent = "0"
})