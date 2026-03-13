// =====================================
// LÓGICA
// =====================================
function crearItem(tarea) {
    let item = document.createElement("li")
    item.textContent = tarea

    let btnEliminar = document.createElement("button")
    btnEliminar.textContent = "Eliminar"
    btnEliminar.classList.add("btn-eliminar")
    btnEliminar.addEventListener("click", function() {
        item.remove()
    })

    item.appendChild(btnEliminar)
    return item
}

// =====================================
// PRESENTACIÓN
// =====================================
function agregarTarea() {
    let input = document.getElementById("tarea")
    let lista = document.getElementById("lista")

    let tarea = input.value
    if (tarea === "") return

    let item = crearItem(tarea)
    lista.appendChild(item)
    input.value = ""
}

// =====================================
// EVENTOS
// =====================================
document.getElementById("agregar").addEventListener("click", agregarTarea)
