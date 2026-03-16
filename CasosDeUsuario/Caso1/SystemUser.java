import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SystemUser {
    static Scanner sc = new Scanner(System.in);
    static Map<String, User> usuarios = new HashMap<>();
    static User usuarioActual = null;

    public static void registrarUsuario() {
        System.out.println("Ingrese el nombre");
        String name = sc.nextLine();
        System.out.print("Ingrese el Correo: ");
        String email = sc.nextLine();
        if (usuarios.containsKey(email)) {
            System.out.println("Ya existe un usuario con ese correo.");
            return;
        }
        System.out.println("Ingrese el número de telefono");
        String phone = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        usuarios.put(email, new User(name, email, password, phone));
        System.out.println("Usuario registrado correctamente.");
    }

    public static void iniciarSesion() {
        System.out.print("Correo: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();

        User u = usuarios.get(email);
        if (u != null && u.autenticar(password)) {
            usuarioActual = u;
            System.out.println("Sesión iniciada correctamente.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    public static void actualizarPerfil() {
        if (usuarioActual == null){
            System.out.println("Debe iniciar sesión primero");
            return;
        }
        int op = 0;
        System.out.println("¿Que deseas actualizar?");
        System.out.println("1. Nombre");
        System.out.println("2. Telefono");
        System.out.println("3. Correo");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = sc.nextLine();
                usuarioActual.actualizarNombre(nuevoNombre);
                System.out.println("Nombre actualizado");
                break;
            case 2:
                System.out.println("Ingrese el nuevo telefono");
                 String nuevoTelefono = sc.nextLine();
                 usuarioActual.actualizarTelefono(nuevoTelefono);
                 System.out.println("Numero actualizado");
                break;
            case 3:
                System.out.println("Ingrese el nuevo correo");
                String nuevoEmail = sc.nextLine();
                usuarioActual.actualizarCorreo(nuevoEmail);
                System.out.println("Correo actualizado");
                break;
            default:
            System.out.println("Opción incorrecta");
                break;

        }
    }

    public static void verHistorial() {
        if (usuarioActual != null) {
            usuarioActual.mostrarHistorial();
        }
    }

    public static void restablecerContraseña() {
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        User u = usuarios.get(correo);
        if (u != null) {
            System.out.print("Nueva contraseña: ");
            String nueva = sc.nextLine();
            u.restablecerContraseña(nueva);
            System.out.println("Contraseña restablecida.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void autenticar() {
        if (usuarioActual == null) return;
        System.out.print("Confirme su contraseña: ");
        String clave = sc.nextLine();
        if (usuarioActual.autenticar(clave)) {
            System.out.println("Autenticado correctamente.");
        } else {
            System.out.println("Autenticación fallida.");
        }
    }
}
