import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Sjf
{
    private HashMap<Integer,ArrayList<Proceso>> miHash;

    public Sjf()
    {
        this.miHash=new HashMap<>();
    }

    public void agregarProceso(Integer tiempoLlegada,Proceso proceso)
    {
        if(this.miHash.get(tiempoLlegada)!=null)
        {
            ArrayList<Proceso>aux=this.miHash.get(tiempoLlegada);
            aux.add(proceso);
            this.miHash.put(tiempoLlegada,aux);
        }
        else
        {
            ArrayList<Proceso>aux=new ArrayList<>();
            aux.add(proceso);
            this.miHash.put(tiempoLlegada,aux);
        }
    }

    public void cargarProcesos(ArrayList<Proceso>aux)
    {
        for (Proceso p:aux)
        {
            int i=p.getTiempoDeLlegada();
            this.agregarProceso(i,p);
        }
    }

    public void calcularTiempos()
    {
        int i=0;
        ArrayList<Proceso> aux=new ArrayList<>();

        if(this.miHash.get(i)!=null)
        {
            ArrayList<Proceso>aux2=this.miHash.get(i);
            for (Proceso pro:aux2)
            {
                aux.add(pro);
            }
        }
        if(!aux.isEmpty())
        {
            Collections.sort(aux);

        }
        i++;
    }
}
