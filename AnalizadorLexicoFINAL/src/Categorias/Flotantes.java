package Categorias;
import Lista.Lista;

public class Flotantes {
    private String categoria;
    
    //inicializa la categoria e inserta el token a la lista que le corresponde, junto con su categoria y su atributo. 
    public Flotantes (Lista lista, String flotante){
        categoria = "Números de punto flotante (sin signo)";
        lista.insertar(flotante + " 299 " + categoria);
    }
}