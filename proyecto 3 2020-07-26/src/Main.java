public class Main
{
    public static void main(String[] args)
    {
        Disco disco= new Disco(30);
        TraductoDeDirecciones traductor= new TraductoDeDirecciones();
        MemoriaPrincipal memoria= new MemoriaPrincipal(10,traductor);
        ColaProgramas cola = new ColaProgramas();
        GeneradorProgramas generador = new GeneradorProgramas(disco,cola,10,4);
        PlanificadorMemoria memoryPlaning = new PlanificadorMemoria(memoria,disco);
        PlanificadorProgramas planificador= new PlanificadorProgramas(cola,memoryPlaning);
        generador.generarProgramas(4);
        CPU cpu= new CPU(traductor,planificador,memoria,2);
        cpu.ejecutar();
       /* cola.mostrarColaProgramas();
        while(!cola.isEmpty())
        {
            planificador.getFistProgram();
            memoria.print();
        }

        */
        traductor.print();



    }
}
