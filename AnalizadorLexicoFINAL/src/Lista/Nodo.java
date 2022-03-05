
package Lista;

public class Nodo {
    //atributos
    String datos;
    Nodo enlace;
    
    //constructor para pasar el dato e inicializar
    public Nodo (String n){
        datos = n;
        enlace = null;
    }

    //retornar le valor que se tenga en el nodo
    public String getDatos() {
        return datos;
    }

    //asignar cual es el que sigue en la pila
    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
}