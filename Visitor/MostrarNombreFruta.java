// Visitante que muestra el nombre de la fruta
public class MostrarNombreFruta implements Visitante {
    public void visitar(Manzana manzana) {
    System.out.println("Es una manzana ");
    }
    public void visitar(Naranja naranja) {
    System.out.println("Es una naranja ");
    }
}

