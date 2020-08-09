import java.util.ArrayDeque;


public class ColaProgramas
{
    private ArrayDeque<Programa> colaDeEjecucion;

    public ColaProgramas()
    {
        this.colaDeEjecucion = new ArrayDeque();
    }

    /*
    permite sacar de la cola el primer elemento.
     */
    public Programa getFirst()
    {
        return this.colaDeEjecucion.pollFirst();
    }


    /*
    permite agregar un programa a la cola de progrmas
    si el programa tiene prioridad mayor a 8 se añaande en la cabecera,
    si tiene prioridad  menor a 9 se agrega al final de la cola.
     */
    public void agregarPrograma(Programa programa)
    {
        System.out.println("se agrego programa:"+programa.getId()+" prioridad:"+programa.getPrioridad());
        if(programa.getPrioridad()>8)
        {
            this.colaDeEjecucion.addFirst(programa);
            System.out.println("se agrego arriba");
        }
        else
        {
            this.colaDeEjecucion.addLast(programa);
            System.out.println("se agrego abajo");
        }

    }

    /*
    permite inspeccionar el primer elemento d ela cola de programas
     */
    public Programa verElPrimero()
    {
        return this.colaDeEjecucion.peekFirst();
    }

    /*
    imprime en la consola un representacion de la cola de progrmas
     */
    public void mostrarColaProgramas()
    {
        System.out.println(" ");
        Programa[] p=this.colaDeEjecucion.toArray(new Programa[0]);
        for (int i = 0; i <p.length ; i++)
        {
            System.out.println("cola de porgramas");
            p[i].printProgram();
            System.out.println(" ");
        }
    }

    /*
    regresa un valor voleano true si la cola esta vacia
    y false si la cola tiene elementos.
     */
    public boolean isEmpty()
    {
        return this.colaDeEjecucion.isEmpty();
    }

    /*
    regresa un entero con la cantidad de programas en al cola.
     */
    public int totalProgrmas()
    {
        return this.colaDeEjecucion.size();
    }
}
