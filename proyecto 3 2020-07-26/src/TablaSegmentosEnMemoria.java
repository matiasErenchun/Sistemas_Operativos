import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TablaSegmentosEnMemoria
{
    private HashMap<Integer, ArrayList<Segmento>> tablaMemoria;

    public TablaSegmentosEnMemoria()
    {
        this.tablaMemoria = new HashMap<>();
    }

    public boolean existeSegmentoEnMemoria(int pID, int segmento)
    {
        System.out.println("pid:"+pID+" segmento:"+segmento);

        if(this.tablaMemoria.isEmpty())
        {
            return false;
        }
        if(this.tablaMemoria.containsKey(pID))
        {
            ArrayList<Segmento>segmentosM=this.tablaMemoria.get(pID);
            if(!segmentosM.isEmpty())
            {
                for (Segmento segmentoM: segmentosM)
                {
                    if(segmentoM.getsID()==segmento)
                    {
                        System.out.println(" segmento:"+segmento+" esta en memoria");
                        return true;
                    }
                }
            }
            return false;
        }
        else
        {
            System.out.println("no esta cargado nada de ese programa wei ");
            return false;
        }
    }

    public Segmento getSegmentoMemoria(int pID, int segmento)
    {
        ArrayList<Segmento>segmentosM=this.tablaMemoria.get(pID);
        for (Segmento segmentoM: segmentosM)
        {
            if(segmentoM.getsID()==segmento)
            {
                System.out.println(" segmento:"+segmento+" esta en memoria");
                return segmentoM;
            }
        }
        Segmento error = new Segmento(-1,-1,-1,-1);
        return error;
    }

    public void agregarSegmento(int pID, Segmento segmentoNuevo)
    {
        if (this.tablaMemoria.containsKey(pID))
        {
            ArrayList<Segmento> segmentosV = this.tablaMemoria.get(pID);
            segmentosV.add(segmentoNuevo);
            this.tablaMemoria.put(pID, segmentosV);

        } else
            {
            ArrayList<Segmento> segmentosV = new ArrayList<>();
            segmentosV.add(segmentoNuevo);
            this.tablaMemoria.put(pID, segmentosV);

        }
    }

    public void borrar()
    {
        this.tablaMemoria.clear();
    }

    public void mostrarSegmentosEnMemoria()
    {
        Collection<ArrayList<Segmento>> segmentosProgramas= this.tablaMemoria.values();

        for (ArrayList<Segmento> arry: segmentosProgramas)
        {
            for (Segmento segg: arry)
            {
                segg.print();
            }
        }
    }


}
