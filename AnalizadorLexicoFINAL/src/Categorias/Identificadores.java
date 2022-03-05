package Categorias;
import Lista.Lista;

public class Identificadores {
    private String categoria;
    private String [] listaIdentificadores = {"cuenta","num","numero","res","multiple","ejemplo","programa"};
    
    //inicializa la categoria e inserta el token a la lista que le corresponde, junto con su categoria y su atributo.
    public Identificadores (Lista lista, String identificador){
        int idd = 500;
        
        for (int i=0; i < listaIdentificadores.length; i++){
                categoria = " Identificadores";
                lista.insertar(identificador + idd + categoria);
                idd++;
            
            
        }
    }
}
//private int generarToken (String palabraReservada){
//        for (int i = 0; i < listaPalabrasReservadas.length; i++){
//            if (palabraReservada.equals(listaPalabrasReservadas[i])){
//                return 300 + i;
//            }
//        }
//        return -1;
//    }
//    