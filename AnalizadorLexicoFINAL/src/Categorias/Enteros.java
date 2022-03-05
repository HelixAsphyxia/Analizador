package Categorias;
import Lista.Lista;

public class Enteros {
    //atributo de la categoria
    private String categoria;
    
    //inicializa la categoria e inserta el token a la lista que le corresponde, junto con su categoria y su atributo. 
    public Enteros (Lista lista, String numero){
        categoria = "Números enteros (naturales)";
        lista.insertar(numero + " 298 " + categoria);
    }
}