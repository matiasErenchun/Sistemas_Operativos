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

    /*
    se ejecuta un programa  el cual  se pasa como parametro
    la cpu tiene uan cantidad de instrucciones maximaspor turno,
    de manera que si un programa requiere mas instrucciones tiene que salir de la cpu,
    volviendo a la cola de programas
     */
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

    /*
    inicia el proceso de ejecucion de cada programa en al cola de programas
     */
    public void ejecutar()
    {
        int progrmasEjecutados=0;
        int totalProgrmas=this.planificadorProgramas.totalProgramas();
        Programa programaActual=this.planificadorProgramas.getFistProgram();//este es el programa que se esta cargando o ejecutando en la cpu
        Programa programaAux;// este es el programa que esta saliendo de la cpu
        boolean continuar =true;
        while( continuar)
        {
            programaAux=this.correrPrograma(programaActual);
            if(programaAux.getTime()<=0)//cuando no ya no le quedna ams ejecuciones termina el programa
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
