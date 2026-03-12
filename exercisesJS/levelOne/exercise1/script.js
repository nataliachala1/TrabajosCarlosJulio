//1. capturamos el botón usando su id
        let boton = document.getElementById("btnMensaje")

        //2. Capturamos el párrafo donde mostraremos el mensaje
        let resultado = document.getElementById("resultado")

        //3. Le decimos al botón: "cuando te hagan clic, ejecuta esto"
        boton.addEventListener("click", function() {
            
            //4. Cambiamos el texto del párrafo 
            resultado.textContent = "Hello world"
        })