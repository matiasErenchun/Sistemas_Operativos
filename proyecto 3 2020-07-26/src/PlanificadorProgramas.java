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
        Programa programa=this.colaProgramas.getFirst();//Se saca el primer programa de la Cola
        return programa;
    }

    public boolean isEmpty()
    {
        return this.colaProgramas.isEmpty();
    }

    public void agregarPrograma(Programa programa)
    {
        this.colaProgramas.agregarPrograma(programa);
    }

    public void mostrarCola()
    {
        this.colaProgramas.mostrarColaProgramas();
    }

    public int totalProgramas()
    {
        return this.colaProgramas.totalProgrmas();
    }
}
