package Categorias;
import Lista.Lista;

public class PalabrasReservadas {
    //atributo de categoria
    private String categoria;
    //Arreglo de las 7 palabras reservadas que se nos piden
    private String [] listaPalabrasReservadas = {"Programa", "Real", "Entero", "Leer", "Escribir", "Inicio", "Fin"};
    
    //constructor vacio
    public PalabrasReservadas(){}
    
    //le pasamos un string, verificamos si es igual o no a la palabra eservada y nos retorna el atributo de lo que estamos buscando
    private int generarToken (String palabraReservada){
        for (int i = 0; i < listaPalabrasReservadas.length; i++){
            if (palabraReservada.equals(listaPalabrasReservadas[i])){
                return 300 + i;
            }
        }
        return -1;
    }
    
    //con un for buscar nuestras palabras reservadas y nos retorna verdadera si encuentra una coincidencia
    public boolean encontrarPalabra (String palabraReservada){
        for (int i = 0; i < listaPalabrasReservadas.length; i++){
            if (palabraReservada.equals(listaPalabrasReservadas[i])){
                return true;
            }
        }
        return false;
    }
    
    //le estamos pasando una lista y la apalabra qu eestamos generan, al igual que la categoria en la que se encuentra
    public void setPalabra (Lista lista, String palabra){
        categoria = "Palabra reservada";
        lista.insertar(palabra + " " + generarToken(palabra) + " " + categoria);
    }
}