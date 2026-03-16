import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String email;
    String password;
    String phone;
    List<String> historial;

    public User (String name,  String email, String password, String phone  ){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.historial = new ArrayList<>();
        historial.add("Usuario registrado");
    }
    public void actualizarNombre(String nuevoNombre) {
    this.name = nuevoNombre;
    historial.add("Nombre actualizado");
    }
    
    public void actualizarTelefono(String nuevoTelefono) {
    this.phone = nuevoTelefono;
    historial.add("Teléfono actualizado");
    }

    public void actualizarCorreo(String nuevoCorreo) {
    this.email = nuevoCorreo;
    historial.add("Correo actualizado");
    }

    public void restablecerContraseña(String nuevaContraseña) {
        this.password = nuevaContraseña;
        historial.add("Contraseña restablecida");
    }

    public void mostrarHistorial() {
        System.out.println("Historial de cambios:");
        for (String cambio : historial) {
            System.out.println("- " + cambio);
        }
    }

    public boolean autenticar(String contrasena) {
        return this.password.equals(contrasena);
    }
}
