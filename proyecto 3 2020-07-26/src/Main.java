public class Main
{
    public static void main(String[] args)
    {
        Disco disco= new Disco(10);
        ColaProgramas cola = new ColaProgramas();
        GeneradorProgramas generador = new GeneradorProgramas(disco,cola,2);
        generador.generarProgramas(4);
        cola.mostrarColaProgramas();
    }
}
