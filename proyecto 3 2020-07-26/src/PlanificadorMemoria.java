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
        int i=programa.getHead();
        int j=this.memoriaPrincipal.getFirsFreeblock();
        while (i<=programa.getEnd())
        {
            StringBuilder string = new StringBuilder("");
            string.append(Integer.toString(programa.getId())+Integer.toString(i));
            this.memoriaPrincipal.setcontenido(string.toString(),this.disco.getIndex(i));
            i++;
        }
    }

    public void volcarMemoriaADisco()
    {

    }

}
