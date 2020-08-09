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
        if(this.planificadorMemoria.estaEnMemoriaPrincipal(programa.getId()))
        {
            System.out.println("el programa:"+programa.getId()+" esta cargado en memoria ");
        }
        else
        {
            this.planificadorMemoria.cargarProgramaDesdeDisco(programa);// carga los datos del programa desde el disco a al memoria principal
        }

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
