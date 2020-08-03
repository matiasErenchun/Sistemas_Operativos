public class CPU
{
    private TraductoDeDirecciones diccionario;
    private PlanificadorProgramas planificadorProgramas;

    public CPU(TraductoDeDirecciones diccionario, PlanificadorProgramas planificadorProgramas)
    {
        this.diccionario = diccionario;
        this.planificadorProgramas = planificadorProgramas;
    }

    public void correrPrograma(Programa programa)
    {

    }

    public void ejecutar(int candidadProgramas)
    {
        int i=0;
        while(i<candidadProgramas)
        {
            Programa programaActual=this.planificadorProgramas.getFistProgram();
            this.correrPrograma(programaActual);
            i++;

        }
    }
}
