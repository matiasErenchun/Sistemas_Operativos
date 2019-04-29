public class Main
{
    private static Consumidor miConsumidor;
    private static Productor miPeoductor;
    private static Buffer miBuffer;

    public static void main(String[] args)
    {
        miBuffer=new Buffer(4);
        miPeoductor=new Productor(miBuffer,20);
        miConsumidor=new Consumidor(miBuffer,20);

        miPeoductor.start();
        miConsumidor.start();
    }
}
