public class CPU
{
    private TraductoDeDirecciones diccionario;
    private PlanificadorProgramas planificadorProgramas;
    private int instruccionesMax;
    private  MemoriaPrincipal memoriaPrincipal;

    public CPU(TraductoDeDirecciones diccionario, PlanificadorProgramas planificadorProgramas,MemoriaPrincipal memoriaPrincipal, int instruccionesMax)
    {
        this.diccionario = diccionario;
        this.planificadorProgramas = planificadorProgramas;
        this.memoriaPrincipal=memoriaPrincipal;
        this.instruccionesMax=instruccionesMax;
    }

    public Programa correrPrograma(Programa programa)
    {
        int i=programa.getPc();
        int instruccionesEjecutadas=0;
        int head = this.diccionario.getDireccion(programa.getId());
        while(i < programa.getLargo() && instruccionesEjecutadas<this.instruccionesMax)
        {
            String instruccion=this.memoriaPrincipal.getIndex(head+i);
            System.out.println("ejecuantado la instruccion:"+i+" del progema:"+programa.getId()+" la instruccion es:"+instruccion+" el total de instrucciones es:"+programa.getLargo());
            programa.decrementarTime();
            programa.incrementarPC();
            i++;
            instruccionesEjecutadas++;
        }

        return programa;
    }

    public void ejecutar()
    {
        Programa programaActual=this.planificadorProgramas.getFistProgram();
        Programa programaAux;
        while(!this.planificadorProgramas.isEmpty())
        {
            programaAux=this.correrPrograma(programaActual);
            programaActual=this.planificadorProgramas.getFistProgram();
            if(programaAux.getTime()<1)
            {
                System.out.println("programa:"+programaAux.getId()+"termino su ejecucion");
            }
            else
            {
                this.planificadorProgramas.agregarPrograma(programaAux);
            }
        }
    }
}
