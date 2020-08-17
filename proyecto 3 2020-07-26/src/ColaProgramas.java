import java.util.ArrayDeque;


public class ColaProgramas
{
    private ArrayDeque<Programa> colaDeEjecucion;

    public ColaProgramas()
    {
        this.colaDeEjecucion = new ArrayDeque();
    }

    /*
    Retorna el primer elemento de la Cola (Quitándolo de esta)
    */
    public Programa getFirst()
    {
        return this.colaDeEjecucion.pollFirst();
    }


    /*
    
    Permite agregar un Programa a la Cola de Programas.
    
    Si el programa tiene una prioridad mayor a 8 se añade al principio de la
    Cola de Programas, caso contrario, si este tiene una prioridad menor a 9,
    se añade al FINAL de la Cola de Programas.
    
    */
    public void agregarPrograma(Programa programa)
    {
        System.out.println("\n*****AVISO*****\nSe agregó el Programa: "+programa.getId()+" | Prioridad: "+programa.getPrioridad());
        if(programa.getPrioridad()>8)
        {
            this.colaDeEjecucion.addFirst(programa);
            System.out.println("Ubicación: Al Principio de la Cola\n");
        }
        else
        {
            this.colaDeEjecucion.addLast(programa);
            System.out.println("Ubicación: Al final de la Cola\n");
        }

    }

    /*
    Retorna el primer elemento de la Cola (Sin quitarlo de esta) (Usado para inspección) 
    */
    public Programa verElPrimero()
    {
        return this.colaDeEjecucion.peekFirst();
    }

    /*
    Imprime por consola una representación de la Cola de Programas Actual
    (Para Depuración)
    */
    public void mostrarColaProgramas()
    {
        System.out.println(" ");
        Programa[] p=this.colaDeEjecucion.toArray(new Programa[0]);
        for (int i = 0; i <p.length ; i++)
        {
            System.out.println("Cola de Programas: ");
            p[i].printProgram();
            System.out.println(" ");
        }
    }

    /*
    Retorna true si la cola está vacía, y false si esta tiene elementos
    */
    public boolean isEmpty()
    {
        return this.colaDeEjecucion.isEmpty();
    }

    /*
    Retorna un entero que indica la cantidad total de programas en la Cola de Ejecución
    */
    public int totalProgrmas()
    {
        return this.colaDeEjecucion.size();
    }
}
