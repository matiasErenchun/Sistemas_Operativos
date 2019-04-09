import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Fifo
{
    private ArrayList<Proceso>colaReady;
    public Fifo(ArrayList<Proceso>listaProcesos)
    {
        this.colaReady=listaProcesos;
    }

    public void ordenarProcesos()
    {
        Collections.sort(this.colaReady);
    }

    public double calcularTiempoDeCompletacion()
    {
        double completationTime=0;
        double arrivalTime=0;
        double acumulado=0;
        double i=0;
        for (Proceso proceso:this.colaReady)
        {
            completationTime+=proceso.getTiempoEnCPU();
            arrivalTime+=proceso.getTiempoDeLlegada();
            i++;
        }
        acumulado=completationTime-arrivalTime;
        Double waitingTime=acumulado/i;
        System.out.println("waiting time: "+waitingTime);
        return waitingTime;

    }
}
