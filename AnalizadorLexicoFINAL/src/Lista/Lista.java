//Va a funcionar como una pila, el ultimo en entrar es le primeor en salir
package Lista;

public class Lista {
    protected Nodo primero;
    
    //constructor vacio, delimtaria el primer nodod como nulo
    public Lista(){
        primero = null;
    }
    
    //si no es igual crea un nuev nodo, lo incializa y lo coloca en enlace la primero, asi mismo nombre a un nuevo primero
    //para poder ir enlazando los demas
    public Lista insertar (String entrada){
        if (verificar (entrada)){
            Nodo nuevo;
            nuevo = new Nodo (entrada);
            nuevo.enlace = primero;
            primero = nuevo;
            return this;
        }
        return null;
    }
    
    //nos muestra en un ciclo todo slos elemntos que se tengan en una misma lista
    public void visualizar (){
        Nodo n;
        n = primero;
        while (n != null){
            System.out.println(n.datos);
            n = n.enlace;
        }
    }
    
    //compara el string que se le esta pasando, para ver is es repetido y no volver a listarlo
    public boolean verificar (String entrada){
        Nodo n;
        n = primero;
        while(n != null){
            if (n.datos.equals(entrada))
                return false;
            n = n.enlace;
        }
        return true;
    }
}