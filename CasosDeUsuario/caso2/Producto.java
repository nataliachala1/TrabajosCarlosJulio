package caso2;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    int idProducto;
    String nombre;
    String categoria;
    int cantidad;
    int stockMinimo;
    String proveedor;
    List<String> historial;

    public Producto(int idProducto, String nombre, String categoria, int cantidad, int stockMinimo, String proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
        this.proveedor = proveedor;
        this.historial = new ArrayList<>();
        historial.add("Producto registrado");
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        historial.add("Nombre actualizado");
    }

    public void actualizarCategoria(String nuevaCategoria) {
        this.categoria = nuevaCategoria;
        historial.add("Categoría actualizada");
    }

    public void actualizarCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
        historial.add("Cantidad actualizada a " + nuevaCantidad);
    }

    public void actualizarProveedor(String nuevoProveedor) {
        this.proveedor = nuevoProveedor;
        historial.add("Proveedor actualizado");
    }

    public void mostrarHistorial() {
        System.out.println("Historial del producto:");
        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }

    public void mostrarDatos() {
        System.out.println("ID: " + idProducto);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Stock mínimo: " + stockMinimo);
        System.out.println("Proveedor: " + proveedor);
    }
}