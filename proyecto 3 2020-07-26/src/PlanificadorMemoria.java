import java.util.ArrayList;
import java.util.HashMap;

public class PlanificadorMemoria
{
    private MemoriaPrincipal memoriaPrincipal;
    private Disco disco;

    public PlanificadorMemoria(MemoriaPrincipal memoriaPrincipal, Disco disco)
    {
        this.memoriaPrincipal = memoriaPrincipal;
        this.disco = disco;
    }

    public void cargarSegmentoDesdeDisco(int pID, int sID)
    {
        Segmento segmento= this.disco.getSegmento(pID,sID);
        segmento.print();
        int largo= segmento.getEnd() - segmento.getHead();
        System.out.println("memoria libre:"+this.memoriaPrincipal.getMemoriaLibre()+" largo:"+largo);
        if((this.memoriaPrincipal.getMemoriaLibre()- largo)<0)//puede que salga algun problema aqui
        {
            this.volcarMemoriaADisco();
            System.out.println("se volco la memoria ");
            this.memoriaPrincipal.print();
        }
        int id =pID;
        int i= segmento.getHead();
        int headM=this.memoriaPrincipal.getFirsFreeblock();
        int endM= headM+ largo-1;
        Segmento segemntoMemoria = new Segmento(id,sID,headM,endM);
        this.memoriaPrincipal.addSegmento(id,segemntoMemoria);
        while (i< segmento.getEnd())
        {
            this.memoriaPrincipal.print();
            StringBuilder string = new StringBuilder("");
            string.append(Integer.toString(pID)+Integer.toString(i - segmento.getHead()));
            this.memoriaPrincipal.setcontenido(this.disco.getIndex(i));
            i++;
        }

    }

    private void volcarMemoriaADisco()
    {
        ArrayList<Segmento> segmentos= this.memoriaPrincipal.getSegmentos();
        for (Segmento segmeto: segmentos)
        {
            int headM= segmeto.getHead();
            int end= segmeto.getEnd();
            Segmento segmentoD=this.disco.getSegmento(segmeto.getpID(),segmeto.getsID());
            int headD=segmentoD.getHead();
            while(headM<=end)
            {
                String contenido=this.memoriaPrincipal.getIndex(headM);
                this.disco.setIndex(headD,contenido);
                headD++;
                headM++;
            }
        }
        this.memoriaPrincipal.borrarSegmentos();
        this.memoriaPrincipal.borrarTablaSegementosMemoria();
        this.memoriaPrincipal.resetParametros();
    }

    /*
    En base a un Program ID entregado, se verifica si el programa está cargado en memoria principal,
    retornando false si no se encuentra, y true si este se encuentra en la memoria principal
     */

}
