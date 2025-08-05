package caso2;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    String nombre;
    String telefono;
    String correo;
    List<String> historial;

    public Proveedor(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.historial = new ArrayList<>();
        historial.add("Proveedor registrado");
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        historial.add("Nombre actualizado");
    }

    public void actualizarTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
        historial.add("Teléfono actualizado");
    }

    public void actualizarCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
        historial.add("Correo actualizado");
    }

    public void mostrarHistorial() {
        System.out.println("Historial del proveedor:");
        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
    }
}
