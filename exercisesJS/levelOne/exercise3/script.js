 function cambiarColor(color) {
            document.body.style.backgroundColor = color;
        }
document.getElementById("btnRojo").addEventListener("click", function() { cambiarColor("red") })
document.getElementById("btnAzul").addEventListener("click", function() { cambiarColor("blue") })
document.getElementById("btnVerde").addEventListener("click", function() { cambiarColor("green") })