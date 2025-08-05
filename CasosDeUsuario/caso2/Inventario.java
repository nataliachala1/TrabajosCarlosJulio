package caso2;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    static Scanner sc = new Scanner(System.in);

    ArrayList<Producto> productos;
    ArrayList<Proveedor> proveedores;
    ArrayList<Movimiento> movimientos;

    public Inventario() {
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();
        movimientos = new ArrayList<>();
    }

    public void agregarProducto() {
        System.out.println("Ingrese ID del producto:");
        int id = Integer.parseInt(sc.nextLine());

        for (Producto p : productos) {
            if (p.idProducto == id) {
                System.out.println("Producto con ese ID ya existe.");
                return;
            }
        }

        System.out.println("Ingrese nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese categoría:");
        String categoria = sc.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese stock mínimo:");
        int stockMinimo = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese proveedor:");
        String proveedor = sc.nextLine();

        Producto nuevo = new Producto(id, nombre, categoria, cantidad, stockMinimo, proveedor);
        productos.add(nuevo);
        System.out.println("Producto agregado correctamente.");
    }

    public void actualizarStock() {
        System.out.println("Ingrese ID del producto a actualizar:");
        int id = Integer.parseInt(sc.nextLine());

        for (Producto p : productos) {
            if (p.idProducto == id) {
                System.out.println("Stock actual: " + p.cantidad);
                System.out.println("Ingrese nueva cantidad:");
                int nuevaCant = Integer.parseInt(sc.nextLine());
                p.cantidad = nuevaCant;
                p.historial.add("Stock actualizado a " + nuevaCant);
                System.out.println("Stock actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void mostrarProductosBajoStock() {
        System.out.println("Productos con bajo stock:");
        for (Producto p : productos) {
            if (p.cantidad < p.stockMinimo) {
                System.out.println("- " + p.nombre + " | Cantidad: " + p.cantidad + " | Stock mínimo: " + p.stockMinimo);
            }
        }
    }

    public void buscarProductoPorNombre() {
        System.out.println("Ingrese nombre del producto a buscar:");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado:");
                p.mostrarDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarProveedor() {
        System.out.println("Ingrese nombre del proveedor:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese teléfono:");
        String telefono = sc.nextLine();
        System.out.println("Ingrese correo:");
        String correo = sc.nextLine();

        for (Proveedor pr : proveedores) {
            if (pr.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Proveedor ya existe.");
                return;
            }
        }

        Proveedor nuevo = new Proveedor(nombre, telefono, correo);
        proveedores.add(nuevo);
        System.out.println("Proveedor agregado correctamente.");
    }

    public void mostrarProveedores() {
        System.out.println("Lista de proveedores:");
        for (Proveedor p : proveedores) {
            p.mostrarDatos();
            System.out.println("-------------------");
        }
    }

    public void registrarMovimiento() {
        System.out.println("Tipo de movimiento (entrada/salida):");
        String tipo = sc.nextLine();
        System.out.println("ID del producto:");
        int idProducto = Integer.parseInt(sc.nextLine());
        System.out.println("Cantidad:");
        int cantidad = Integer.parseInt(sc.nextLine());
        System.out.println("Fecha (formato dd/mm/aaaa):");
        String fecha = sc.nextLine();

        Movimiento mov = new Movimiento(tipo, idProducto, cantidad, fecha);
        movimientos.add(mov);

        for (Producto p : productos) {
            if (p.idProducto == idProducto) {
                if (tipo.equalsIgnoreCase("entrada")) {
                    p.cantidad += cantidad;
                    p.historial.add("Entrada de " + cantidad + " unidades el " + fecha);
                } else if (tipo.equalsIgnoreCase("salida")) {
                    p.cantidad -= cantidad;
                    p.historial.add("Salida de " + cantidad + " unidades el " + fecha);
                }
                System.out.println("Movimiento registrado y stock actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado para aplicar movimiento.");
    }

    public void mostrarMovimientos() {
        System.out.println("Historial de movimientos:");
        for (Movimiento m : movimientos) {
            m.mostrarDatos();
            System.out.println("-------------------");
        }
    }
}
