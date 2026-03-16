// 1. Capturamos los elementos
let nombre = document.getElementById("nombre")
let correo = document.getElementById("correo")
let edad = document.getElementById("edad")
let btnEnviar = document.getElementById("btnEnviar")
let resultado = document.getElementById("resultado")

// 2. Escuchamos el clic
btnEnviar.addEventListener("click", function() {

    let regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/


    
    // 3. Verificamos si algún campo está vacío
    if (nombre.value === "" || correo.value === "" || edad.value === "") {
        resultado.textContent = "Debe completar todos los campos"
        resultado.style.color = "red"

    // Validamos el correo
    } else if (!regexCorreo.test(correo.value)) {
        resultado.textContent = "El correo no es válido"
        resultado.style.color = "red"
    
    // 4. Si todos tienen valor
    } else {
        resultado.textContent = "Formulario enviado correctamente"
        resultado.style.color = "green"
    }
    

})