        let resultado = document.getElementById("resultado")
        let boton = document.getElementById("btnSumar")
        
        boton.addEventListener("click", function()  {
        let numero1 = document.getElementById("numero1").value
        let numero2 = document.getElementById("numero2").value

        let suma = Number(numero1) + Number(numero2)

    
            resultado.textContent = suma
        })