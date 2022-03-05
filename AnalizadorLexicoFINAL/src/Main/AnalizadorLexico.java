package Main;
import Lista.Lista;
import Categorias.*;
import Lectura.AccesoArchivo;
import java.util.ArrayList;

public class AnalizadorLexico {
    //instanciamos las listas de cada una de las cateogrias que tenemos, asi como una de error, nuestro acceso al archivo y el programa que se tiene
    //en el mismo
    private Lista listaPalabrasReservadas;
    private Lista listaIdentificadores;
    private Lista listaEnteros;
    private Lista listaFlotantes;
    private Lista listaCaracteres;
    private Lista listaErrores;
    private AccesoArchivo acceso;
    private String programa;
    //asi como inicializamos en 0 nuestro inicio, fin y el estado
    private int inicio = 0;
    private int fin = 0;
    private int estado = 0;
    ArrayList<String> leyendo;
    
    public AnalizadorLexico (){
        //inciializamos nuestras lista
        listaPalabrasReservadas = new Lista();
        listaIdentificadores = new Lista();
        listaEnteros = new Lista();
        listaFlotantes = new Lista();
        listaCaracteres = new Lista();
        listaErrores = new Lista();
        acceso = new AccesoArchivo();
        //programa = acceso.leerArchivo();
        leyendo=acceso.leerArchivo();
        leerPrograma_(leyendo);
        System.out.println("\n\n");
        listaPalabrasReservadas.visualizar();        
        System.out.println("");
        listaIdentificadores.visualizar();
        System.out.println("");
        listaEnteros.visualizar();
        System.out.println("");
        listaFlotantes.visualizar();
        System.out.println("");
        listaCaracteres.visualizar();
        System.out.println("");
        listaErrores.visualizar();
    }
    
//    public void leerPrograma(){
//        do {
//            analizar (programa);
//        } while (fin < programa.length());
//    }
    
    //analizamos el progrma pientras el apuntar de fin sea menor a la longitud del progtrama pero con ayuda de un Array
    public void leerPrograma_(ArrayList<String> l){
        for (String linea : l) {
            inicio=0;
            fin =0;
            estado=0;
            do {
                 analizar (linea);
            } while (fin < linea.length());
        }
    }
            
    //aqui es donde se modela todas las transiciones del automata
    private void analizar (String programa){
        switch (estado){
            case 0:
                if (programa.charAt(fin) >= 'a' && programa.charAt(fin) <= 'z'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 1;
                    fin++;
                }
                else if (programa.charAt(fin) >= '1' && programa.charAt(fin) <= '9'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 4;
                    fin++;
                }
                else if (programa.charAt(fin) >= 'A' && programa.charAt(fin) <= 'Z'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 9;
                    fin++;
                }
                else if (isCharacter(programa.charAt(fin))){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 8;
                }
                else if (programa.charAt(fin) == ' '){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 0;
                    inicio++;
                    fin++;
                }
                else{
                    estado = 11;
                }
                break;
            case 1:
                if ((programa.charAt(fin) >= 'a' && programa.charAt(fin) <= 'z') || (programa.charAt(fin) >= '0' && programa.charAt(fin) <= '9')){
                    
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 1;
                    fin++;
                }
                else if (programa.charAt(fin) == '_'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 2;
                    fin++;
                }
                // Nuevo
                else if (programa.charAt(fin) == ' '){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 3;
                    fin++;
                }
                else { 
                    estado = 11;
                }
                break;
            case 2:
                if ((programa.charAt(fin) >= 'a' && programa.charAt(fin) <= 'z') || (programa.charAt(fin) >= '0' && programa.charAt(fin) <= '9')){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 2;
                    fin++;
                }
                // Nuevo
                else if (programa.charAt(fin) == ' '){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 3;
                    fin++;
                }
                else { 
                    estado = 11;
                }
                break;
            case 3:
                //armamos la palabra, instanciamos un string que nos almacena le token que va del inciio al fin e inserta el identificador en la lista 
                //correspondiente, va a mover le inikcio al fin y va a retornar de nuevo al estado 0
                System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                String id = "";
                for (int i = inicio; i < fin; i++){
                    id += programa.charAt(i);
                }
                new Identificadores (listaIdentificadores, id);
                listaIdentificadores.visualizar();
                inicio=fin;
                estado = 0;
                break;
            case 4:
                if (programa.charAt(fin) >= '0' && programa.charAt(fin) <= '9'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 4;
                    fin++;
                }
                else if (programa.charAt(fin) == '.'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 5;
                    fin++;
                }
                else {
                    estado = 7;
                }
                break;
            case 5:
                if (programa.charAt(fin) >= '0' && programa.charAt(fin) <= '9'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 5;
                    fin++;
                }
                else {
                    estado = 6;
                }
                break;
            case 6:
                //armamos la palabra, instanciamos un string que nos almacena le token que va del inciio al fin e inserta el identificador en la lista 
                //correspondiente, va a mover le inikcio al fin y va a retornar de nuevo al estado 0
                String flotante = "";
                System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                for (int i = inicio; i < fin; i ++){
                    flotante += programa.charAt(i);
                }
                new Flotantes(listaFlotantes, flotante);
                listaFlotantes.visualizar();
                inicio = fin;
                estado = 0;
                break;
            case 7:
                //armamos la palabra, instanciamos un string que nos almacena le token que va del inciio al fin e inserta el identificador en la lista 
                //correspondiente, va a mover le inikcio al fin y va a retornar de nuevo al estado 0
                String entero = "";
                System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                for (int i = inicio; i < fin; i ++){
                    entero += programa.charAt(i);
                }
                new Enteros(listaEnteros, entero);
                listaEnteros.visualizar();
                inicio = fin;
                estado = 0;
                break;
            case 8:
                //armamos la palabra, instanciamos un string que nos almacena le token que va del inciio al fin e inserta el identificador en la lista 
                //correspondiente, va a mover le inikcio al fin y va a retornar de nuevo al estado 0
                System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                new Caracteres(listaCaracteres, programa.charAt(fin));
                listaCaracteres.visualizar();
                inicio++;
                fin++;
                estado = 0;
                break;
            case 9: 
                //mientras lea una letra minuscula permanece en el estado 9 , para corroborar que sea reservada
                if (programa.charAt(fin) >= 'a' && programa.charAt(fin) <= 'z'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 9;
                    fin++;
                }
                else if (programa.charAt(fin) >= '0' && programa.charAt(fin) <= '9'){
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 9;
                    fin++;
                }
                else {
                    System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                    estado = 10;
                }
                break;
            case 10:
                //en el estado de aceptacion vamos a iniciar nuestras palabras reservadas con nuestro constructor vacio armamos la palabra,
                //si la encuentra la añade a su lista y mueve le apuntador de inicio al fin 
                String pr = "";
                System.out.println(programa.charAt(fin) + " " + fin + " " + estado);
                PalabrasReservadas palabras = new PalabrasReservadas();
                for (int i = inicio; i < fin; i++){
                    pr += programa.charAt(i);
                }
                //n caso de que no lo sea lo mandara a nuestra lista de errores lexicos, igualmente mueve el apuntador 
                if (palabras.encontrarPalabra(pr)){
                    palabras.setPalabra(listaPalabrasReservadas, pr);
                    listaPalabrasReservadas.visualizar();
                    inicio =fin;
                }
                else{
                    listaErrores.insertar(pr + "Error lexico");
                    listaErrores.visualizar();
                    inicio = fin;
                }
                estado = 0;
                break;
            case 11:
                //lista de errores para todo tipo de caracteres que no identifique el programa, el inicio y el fin lo mueve una posicion 
                listaErrores.insertar(programa.charAt(fin) + "Error lexico");
                listaErrores.visualizar();
                inicio++;
                fin++;
                estado = 0;
                break;
        }
    }
    
    private boolean isCharacter (char caracter){
        if (caracter == ';' || caracter == '=' || caracter == '+' || caracter == '-'
            || caracter == '/' || caracter == '(' || caracter == ')' || caracter == ','){
            return true;
        }
        else {
            return false;
        }
    }
}