// Capturamos los elementos
let boton = document.getElementById("agregar")
let input = document.getElementById("tarea")
let lista = document.getElementById("lista")

// Escuchamos el clic del botón
boton.addEventListener("click", function() {

    let tarea = input.value

    // Creamos el <li>
    let item = document.createElement("li")
    item.textContent = tarea

    // Creamos el botón eliminar
    let btnEliminar = document.createElement("button")
    btnEliminar.textContent = "Eliminar"
    btnEliminar.classList.add("btn-eliminar")
    btnEliminar.addEventListener("click", function() {
        item.remove()
    })

    // Metemos el botón dentro del <li>
    item.appendChild(btnEliminar)
    
    // Metemos el <li> en la lista
    lista.appendChild(item)
    
    // Limpiamos el input
    input.value = ""

})