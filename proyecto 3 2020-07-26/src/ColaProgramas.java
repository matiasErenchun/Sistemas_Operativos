import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ColaProgramas
{
    private ArrayDeque<Programa> colaDeEjecucion;

    public ColaProgramas()
    {
        this.colaDeEjecucion = new ArrayDeque();
    }

    public Programa getFirst()
    {
        return this.colaDeEjecucion.pollFirst();
    }

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

    public Programa verElPrimero()
    {
        return this.colaDeEjecucion.peekFirst();
    }

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

    public boolean isEmpty()
    {
        return this.colaDeEjecucion.isEmpty();
    }

    public int totalProgrmas()
    {
        return this.colaDeEjecucion.size();
    }
}
