public class Main
{
    public static void main(String[] args)
    {
        Scaner scaner=new Scaner();
        
        System.out.println("Bienvenido a su Simulador de Memoria, por favor, defina la siguiente información [Las Unidades se encuentran en Bloques de Memoria");

        Integer tamañaoMemoria=scaner.leerNumeroPositivo("Tamaño de la Memoria Principal (EJ: 10)");
        Integer tamañoDisco=scaner.leerNumeroPositivo("Tamaño del Disco Duro (EJ: 30)");
        Integer largoMaximoPrograma=scaner.leerNumeroPositivoSegunValor("Largo Máximo de un Programa (EJ: 10)",tamañaoMemoria);
        Integer cantidadDeProgramas=scaner.leerNumeroPositivo("Cantidad de programas a Crear (EJ: 5)");
        Integer cantidadDeInstruccionesPorTurno=scaner.leerNumeroPositivo("Cantidad de Instrucciones a Ejecutar por turno en la CPU (EJ: 2)");
        System.out.println("");

        TablaDeSegmentosViruales tablaSV = new TablaDeSegmentosViruales();
        Disco disco= new Disco(tamañoDisco,tablaSV);
        TablaSegmentosEnMemoria tablaSegmentosEnMemoria= new TablaSegmentosEnMemoria();
        MemoriaPrincipal memoria= new MemoriaPrincipal(tamañaoMemoria,tablaSegmentosEnMemoria);
        ColaProgramas cola = new ColaProgramas();
        GeneradorProgramas generador = new GeneradorProgramas(disco,cola,largoMaximoPrograma);
        PlanificadorMemoria memoryPlaning = new PlanificadorMemoria(memoria,disco);
        PlanificadorProgramas planificador= new PlanificadorProgramas(cola,memoryPlaning);
        generador.generarProgramas(cantidadDeProgramas);
        TraductoDeDirecciones traductor = new TraductoDeDirecciones(tablaSegmentosEnMemoria,tablaSV,memoryPlaning);
        CPU cpu= new CPU(traductor,planificador,memoria,cantidadDeInstruccionesPorTurno);
        cpu.ejecutar();
    }
}
