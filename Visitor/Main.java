// Clase principal con el main
public class Main {
    public static void main(String[] args) {
// Crear arreglo de frutas
        Fruta[] frutas = { new Manzana(), new Naranja(), new Manzana() 
        };
// Crear visitante
        Visitante visitante = new MostrarNombreFruta();
// Aplicar visitante a cada fruta
        for (Fruta fruta : frutas) {
        fruta.aceptar(visitante);
        }
    }
}