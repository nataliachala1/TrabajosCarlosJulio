import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Book> books = new ArrayList<>();
    static List<Reader> reader= new ArrayList<>(); 
    static List<Loan> loan = new ArrayList<>(); 
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        do {
            System.out.println("Sistema de biblioteca");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libro");
            System.out.println("3. Registrar datos del lector");
            System.out.println("4. Lista  del lector");
            System.out.println("5. Registrar un prestamo");
            System.out.println("6. Lista   el prestamo");
            System.out.println("7. Devolucion del libro");
            System.out.println("8. salir");
            opcion = scan.nextInt();
            scan = new Scanner(System.in);
            switch (opcion) {
                case 1:
                    registerBook();
                    break;
                case 2:
                    getListBooks();
                    break;
                case 3:
                    readerDate();
                    break;
                case 4:
                    listReader();
                    break;
                case 5:
                    loan();
                    break;
                case 6:

                default:
                    System.out.println("Opción no valida");
                    break;
            }

        } while (opcion != 8);
        System.out.println("saliendo");
    }

    public static void registerBook() {
        Book book = new Book();
        System.out.println("Ingrese la información del libro");
        System.out.println("ISBN");
        book.isbn =scan.nextLine();
        System.out.println("Titulo");
        book.title = scan.nextLine();
        System.out.println("Autor");
        book.author = scan.nextLine();
        System.out.println("Genero");
        book.genere = scan.nextLine();
        System.out.println("Fecha de publicación (DD-MM-AA)");
        book.publicationDate = scan.nextLine();
        App.books.add(book);
        System.out.println("Informacion del libro guardada en el sistema");
    }

    public static void getListBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
        if (books.size() == 0) {
            System.out.println("No hay libros registrados");
        }
    }
    /**
     * 
     */
    public static void readerDate() {
        Reader reader = new Reader(null, null, null);
        System.out.println("Ingrese su ID");
        reader.id = scan.nextLine();
        System.out.println("Ingrese su nombre");
        reader.name = scan.nextLine();
        System.out.println("Ingrese su email");
        reader.email = scan.nextLine();
        System.out.println("Informacion del lector guardada en el sistema");
        App.reader.add(reader); 
    }
    public static void listReader() {
    if (reader.isEmpty()) {
        System.out.println("No hay lectores registrados");
    } else {
        for (Reader r : reader) {
            System.out.println(r.toString());
        }
    }
}
public static void loan() {
    if (books.isEmpty() || reader.isEmpty()) {
        System.out.println("Debe haber al menos un libro y un lector registrados.");
        return;
    }

    System.out.println("Seleccione el índice del libro a prestar:");
    for (int i = 0; i < books.size(); i++) {
        System.out.println(i + ": " + books.get(i).title);
    }
    int bookIndex = scan.nextInt();
    scan.nextLine(); // limpiar buffer

    if (bookIndex < 0 || bookIndex >= books.size()) {
        System.out.println("Índice de libro no válido.");
        return;
    }

    System.out.println("Seleccione el índice del lector:");
    for (int i = 0; i < reader.size(); i++) {
        System.out.println(i + ": " + reader.get(i).name);
    }
    int readerIndex = scan.nextInt();
    scan.nextLine(); // limpiar buffer

    if (readerIndex < 0 || readerIndex >= reader.size()) {
        System.out.println("Índice de lector no válido.");
        return;
    }

    Loan newLoan = new Loan(books.get(bookIndex), reader.get(readerIndex));
    loan.add(newLoan);
    System.out.println("Préstamo registrado exitosamente.");
}
}

