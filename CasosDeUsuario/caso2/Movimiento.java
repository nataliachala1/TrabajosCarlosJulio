package caso2;

public class Movimiento {
    String tipo; // "Entrada" o "Salida"
    int idProducto;
    int cantidad;
    String fecha;

    public Movimiento(String tipo, int idProducto, int cantidad, String fecha) {
        this.tipo = tipo;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public void mostrarDatos() {
        System.out.println("Tipo de movimiento: " + tipo);
        System.out.println("ID Producto: " + idProducto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha: " + fecha);
    }
}
