import java.util.ArrayList;
import java.util.HashMap;

public class TablaDeSegmentosViruales
{
    private HashMap<Integer, ArrayList<SegmentoVirtual>> tablaDeSegmentosProgramas;

    public TablaDeSegmentosViruales()
    {
        this.tablaDeSegmentosProgramas = new HashMap<>();
    }

    public SegmentoVirtual getSegmentoVirtual(int pID, int instruccion)
    {
        ArrayList<SegmentoVirtual>contenedor = this.tablaDeSegmentosProgramas.get(pID);
        for (SegmentoVirtual segmentoV:contenedor)
        {
            if(instruccion>=segmentoV.getIntruccionDeInicio()&& instruccion<=segmentoV.getInstruccionFinal())
            {
                return segmentoV;
            }
        }
        SegmentoVirtual error =new SegmentoVirtual(-1,-1,-1,-1);

        return error;
    }

    public void agregarSegmentoVirtual(Integer pID, SegmentoVirtual nuevoSegmento)
    {
        if(this.tablaDeSegmentosProgramas.containsKey(pID))
        {
            ArrayList<SegmentoVirtual>segmentosV = this.tablaDeSegmentosProgramas.get(pID);
            segmentosV.add(nuevoSegmento);
            this.tablaDeSegmentosProgramas.put(pID,segmentosV);

        }
        else
        {
            ArrayList<SegmentoVirtual>segmentosV = new ArrayList<>();
            segmentosV.add(nuevoSegmento);
            this.tablaDeSegmentosProgramas.put(pID,segmentosV);

        }
    }

    public void mostrar(int pID)
    {
        ArrayList<SegmentoVirtual>segmentosVirtuales=this.tablaDeSegmentosProgramas.get(pID);
        for (SegmentoVirtual seV: segmentosVirtuales)
        {
            seV.print();
        }
    }

}
