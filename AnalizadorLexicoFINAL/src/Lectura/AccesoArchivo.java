//se va a encargar de leer el archivo donde tenemos le programa a leer
package Lectura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccesoArchivo {
    //string de la direccion del archivo
    private final String archivo = "src/Lectura/programaAnalizar.txt";
    
    public ArrayList<String> leerArchivo(){
        String leer = "";
        ArrayList <String> leyendo = new ArrayList();
        try{
            //metemos todas las lineas dentro de nuestro string
            Scanner acceso = new Scanner (new FileInputStream(archivo));
            while (acceso.hasNext()){
                leyendo.add(acceso.nextLine()+' ');
                //leer += acceso.nextLine();
            }
        } catch (FileNotFoundException e){
            System.err.println("No se encontro el archivo");
        }
        return leyendo;
    }
}