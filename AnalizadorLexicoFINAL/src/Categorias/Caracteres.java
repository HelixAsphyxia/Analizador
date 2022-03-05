package Categorias;
import Lista.Lista;

public class Caracteres {
    private String categoria;
    
    //inicializa la categoria e inserta el token a la lista que le corresponde, junto con su categoria y su atributo.
    //utilizamos el ascii del caracter para tener al tributo especial que le corresponde
    public Caracteres (Lista lista, char caracter){
        categoria = "Caracteres simples";
        int ASCII = caracter;
        lista.insertar(caracter + " " + ASCII + " " + categoria);
    }
}