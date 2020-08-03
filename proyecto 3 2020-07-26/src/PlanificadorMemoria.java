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
        int j=this.memoriaPrincipal.getFlagLastIndex();
        while (i<=programa.getEnd())
        {
            //falta copiar las cosas y todo lo de la memoria principal
        }
    }

    public void volcarMemoriaADisco()
    {

    }

}
