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
        double tiempoFuncionamiento=0;
        double arrivalTime=0;
        double tiempoRetorno=0;
        double retornoParcial=0;
        double tiempoEspera=0;
        double i=0;
        for (Proceso proceso:this.colaReady)
        {
            tiempoFuncionamiento+=proceso.getTiempoEnCPU();
            retornoParcial=tiempoFuncionamiento-arrivalTime;
            tiempoRetorno+=retornoParcial;
            double espera=retornoParcial-proceso.getTiempoEnCPU();
            tiempoEspera+=espera;
            i++;
        }
        System.out.println("tiempos de FCFS ");
        double funcionamientoMerdio=tiempoFuncionamiento/i;
        System.out.println("tiempo de completacion "+tiempoRetorno);
        System.out.println("tiempo de funcionamiento medio: "+funcionamientoMerdio);
        Double tiempoRetornoMedio=tiempoRetorno/i;
        System.out.println("tiempo de retorno medio: "+tiempoRetornoMedio);
        Double esperaMedio=tiempoEspera/i;
        System.out.println("tiempo de espera medio: "+esperaMedio);
        return 0;

    }
}
