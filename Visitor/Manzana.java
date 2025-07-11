// Clase Manzana
public class Manzana implements Fruta {
    public void aceptar(Visitante visitante) {
    visitante.visitar(this);
    }
}

