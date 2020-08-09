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

    public void cargarProgramaDesdeDisco(Programa programa)
    {
        if((this.memoriaPrincipal.getMemoriaLibre()- programa.getLargo())<0)
        {
            this.volcarMemoriaADisco();
        }
        int id =programa.getId();
        Segmento segmento=this.disco.getSegmentoPID(id);
        int i= segmento.getHead();
        int headM=this.memoriaPrincipal.getFirsFreeblock();
        int endM= headM+ programa.getLargo()-1;
        Segmento segemntoMemoria = new Segmento(id,headM,endM);
        this.memoriaPrincipal.addSegmento(segemntoMemoria);
        while (i<= segmento.getEnd())
        {
            StringBuilder string = new StringBuilder("");
            string.append(Integer.toString(programa.getId())+Integer.toString(i - segmento.getHead()));
            this.memoriaPrincipal.setcontenido(this.disco.getIndex(i));
            i++;
        }

    }

    private void volcarMemoriaADisco()
    {
        ArrayList<Integer> listaAux= this.memoriaPrincipal.getPids();
        for (Integer pID:listaAux)
        {
            Segmento segmentoM=this.memoriaPrincipal.getSegmentoPID(pID);
            Segmento segmentoD=this.disco.getSegmentoPID(pID);
            int headM= segmentoM.getHead();
            int headD= segmentoD.getHead();
            while (headM<=segmentoM.getEnd())
            {
                String contenidoM=this.memoriaPrincipal.getIndex(headM);
                this.disco.setIndex(headD,contenidoM);
                headD++;
                headM++;
            }
        }

        this.memoriaPrincipal.borrarSegmentos();
        this.memoriaPrincipal.borrarTraductor();
        this.memoriaPrincipal.resetParametros();
        this.memoriaPrincipal.print();
    }

    public boolean estaEnMemoriaPrincipal(int pID)
    {
        int answer=this.memoriaPrincipal.ExistePID(pID);
        System.out.println("answer:"+answer+" pid:"+pID);
        this.memoriaPrincipal.print();
        if(answer==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


}
