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
            System.out.println("ejecuantado la instruccion:"+(i+1)+" del progema:"+programa.getId()+" la instruccion es:"+instruccion+" el total de instrucciones es:"+programa.getLargo());
            programa.decrementarTime();
            programa.incrementarPC();
            i++;
            instruccionesEjecutadas++;
        }

        return programa;
    }

    public void ejecutar()
    {
        int progrmasEjecutados=0;
        int totalProgrmas=this.planificadorProgramas.totalProgramas();
        System.out.println("total programas:"+totalProgrmas);
        Programa programaActual=this.planificadorProgramas.getFistProgram();
        Programa programaAux;
        boolean continuar =true;
        while( continuar)
        {
            programaAux=this.correrPrograma(programaActual);
            if(programaAux.getTime()<=0)
            {
                System.out.println("programa:"+programaAux.getId()+" termino su ejecucion");
                progrmasEjecutados++;
                System.out.println("total programas:"+totalProgrmas);
            }
            else
            {
                this.planificadorProgramas.agregarPrograma(programaAux);
            }
            if(progrmasEjecutados>=totalProgrmas && this.planificadorProgramas.isEmpty())
            {
                continuar=false;
            }
            else
            {
                programaActual=this.planificadorProgramas.getFistProgram();
            }

        }
    }
}
