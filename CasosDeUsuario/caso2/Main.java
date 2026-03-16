package caso2;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        int flag = 1;
        int op = 0;

        while (flag == 1) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar stock");
            System.out.println("3. Mostrar productos con bajo stock");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Agregar proveedor");
            System.out.println("6. Mostrar proveedores");
            System.out.println("7. Registrar movimiento (entrada/salida)");
            System.out.println("8. Mostrar historial de movimientos");
            System.out.println("9. Salir");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    inventario.agregarProducto();
                    break;
                case 2:
                    inventario.actualizarStock();
                    break;
                case 3:
                    inventario.mostrarProductosBajoStock();
                    break;
                case 4:
                    inventario.buscarProductoPorNombre();
                    break;
                case 5:
                    inventario.agregarProveedor();
                    break;
                case 6:
                    inventario.mostrarProveedores();
                    break;
                case 7:
                    inventario.registrarMovimiento();
                    break;
                case 8:
                    inventario.mostrarMovimientos();
                    break;
                case 9:
                    flag = 0;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println(); // línea en blanco para separar iteraciones
        }
    }
}
