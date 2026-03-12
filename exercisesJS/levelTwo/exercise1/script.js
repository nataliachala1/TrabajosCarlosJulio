let clics = 0;

        document.getElementById("boton").addEventListener("click", function() {
            clics++;
        document.getElementById("contador").textContent = "Clics: " + clics;

        });