public class Main
{
    private static Productor miPoductor;
    private static Consumidor miConsumidor;
    private static Cinta miCinta;
    public static void main(String[] args)
    {
        int cantidadMaxima=4;
        int aProducir=20;
        miCinta=new Cinta(cantidadMaxima);
        miPoductor=new Productor(miCinta,aProducir);
        miConsumidor=new Consumidor(aProducir,miCinta);
        miPoductor.start();
        miConsumidor.start();
        try{
            miPoductor.join();
        }catch (Exception e)
        {

        }
        try{
            miConsumidor.join();
        }catch (Exception e)
        {

        }

        System.out.println("Hello World!");


    }
}
