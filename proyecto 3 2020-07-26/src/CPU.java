import java.util.Random;

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
    Acá se ejecutan los programas, estos son recibidos como parámetros.
    La CPU tiene una cantidad de instrucciones MÁXIMAS por turno, de esta manera, si
    el programa requiere más cantidad de instrucciones, tiene que dejar su ejecución
    para volver a la cola de programas.
    */
    public Programa correrPrograma(Programa programa)
    {
        Random random= new Random(System.currentTimeMillis());
        int instruccionesEjecutadas=0;
        int instruccionActual;
        int direccionActual;
        String valorDireccionActual;
        while(instruccionesEjecutadas<this.instruccionesMax)
        {
            instruccionActual= random.nextInt(programa.getLargo());
            direccionActual=this.diccionario.getDireccion(programa.getId(),instruccionActual);
            valorDireccionActual=this.memoriaPrincipal.getIndex(direccionActual);
            System.out.println("*****AVISO*****\nEjecuantado la Instrucción: "+(instruccionActual)+" | Programa:: "+programa.getId()+" | Contenido de la Instrucción: "+valorDireccionActual+" | El total de Instrucciones es: "+programa.getLargo());
            programa.decrementarTime();
            instruccionesEjecutadas++;
        }

        return programa;
    }

    /*
    Acá se ejecutan los programas que van llegando desde la Cola de Programas
    */
    public void ejecutar()
    {
        int progrmasEjecutados=0;
        int totalProgrmas=this.planificadorProgramas.totalProgramas();
        Programa programaActual=this.planificadorProgramas.getFistProgram();//Programa actual en ejecución
        Programa programaAux;// este es el programa que esta saliendo de la cpu
        boolean continuar =true;
        while( continuar)
        {
            programaAux=this.correrPrograma(programaActual);
            if(programaAux.getTime()<=0)//Si al programa ya no le queda más tiempo de ejecución, este se termina
            {
                System.out.println("\n*****[AVISO]*****\nPrograma: "+programaAux.getId()+"\nACCIÓN: Ejecución Finalizada\nMOTIVO: Se ha completado el Tiempo de Ejecución");
                progrmasEjecutados++;
                System.out.println("\n*****[INFORMACIÓN]*****\nNº Total de Programas Ejecutados en CPU: "+totalProgrmas + "\n");
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
