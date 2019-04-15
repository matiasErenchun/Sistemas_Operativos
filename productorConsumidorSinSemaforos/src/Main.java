public class Main
{
    private static Productor miPoductor;
    private static Consumidor miConsumidor;
    private static int cantidadMaxima=4;
    private static int aProducir=20;
    private static Cinta miCinta;
    public static void main(String[] args)
    {
        miCinta=new Cinta(cantidadMaxima);
        miPoductor=new Productor(miCinta,aProducir);
        miConsumidor=new Consumidor(aProducir,miCinta);
        miPoductor.start();
        miConsumidor.start();
        System.out.println("Hello World!");
    }
}
