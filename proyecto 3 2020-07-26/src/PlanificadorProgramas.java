public class PlanificadorProgramas
{
    private ColaProgramas colaProgramas;
    private PlanificadorMemoria planificadorMemoria;

    public PlanificadorProgramas(ColaProgramas colaProgramas, PlanificadorMemoria planificadorMemoria)
    {
        this.colaProgramas = colaProgramas;
        this.planificadorMemoria=planificadorMemoria;
    }

    public Programa getFistProgram()
    {
        Programa programa=this.colaProgramas.getFirst();// sacamos el primer programa de la cola
        this.planificadorMemoria.cargarProgramaDesdeDisco(programa);// carga los datos del programa desde el disco a al memoria principal
        return programa;
    }
}
