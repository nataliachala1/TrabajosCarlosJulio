// 1. Capturamos los elementos
let btnEjecutar = document.getElementById("btnEjecutar")
let resultado = document.getElementById("resultado")

btnEjecutar.addEventListener("click", function() {

    // 2. Leemos los valores
    let num1 = Number(document.getElementById("numero1").value)
    let num2 = Number(document.getElementById("numero2").value)
    let operacion = document.getElementById("operacion").value

    // 3. Switch para cada operación
    let total
    switch(operacion) {
        case "+":
            total = num1 + num2
            break
        case "-":
            total = num1 - num2
            break
        case "*":
            total = num1 * num2
            break
        case "/":
            total = num1 / num2
            break
    }

    // 4. Mostramos el resultado
    resultado.textContent = "Resultado: " + total

})