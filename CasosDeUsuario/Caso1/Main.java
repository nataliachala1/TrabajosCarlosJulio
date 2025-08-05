import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int flag = 1;
        int op = 0;

        while(flag == 1) {
            System.out.println("Ingrese una opción");
            System.out.println("1. Registrar un usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Actualizar información del perfil");
            System.out.println("4. Ver historial de cambios");
            System.out.println("5. Restablecer Contraseña");
            System.out.println("6. Autenticar");
            System.out.println("7. Salir");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    SystemUser.registrarUsuario();
                    break;
                case 2:
                    SystemUser.iniciarSesion();
                    break;
                case 3:
                    SystemUser.actualizarPerfil();  
                    break;
                case 4:
                    SystemUser.verHistorial();
                    break;
                case 5:
                    SystemUser.restablecerContraseña(); 
                    break;
                case 6:
                    SystemUser.autenticar();
                    break;
                case 7:
                    flag = 0;
                    System.out.println("Saliendo...");
                    break;            
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }

}
