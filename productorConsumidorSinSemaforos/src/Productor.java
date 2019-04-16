public class Productor extends Thread
{
    private Cinta cinta;
    private int aProducir;

    public Productor(Cinta cinta, int aProducir)
    {
        this.cinta = cinta;
        this.aProducir = aProducir;
    }

    @Override
    public void run()
    {
        int i=0;

        while (this.cinta.getProducidos()<this.aProducir)
        {
            System.out.println("producidos hasta ahora"+this.cinta.getProducidos());
            try
            {


                i=this.producir(i);
                System.out.println(i+" i");

            }
            catch (Exception e)
            {
                //System.out.println(e.getStackTrace());
            }


        }
    }

    public int producir(int i)throws InterruptedException
    {

        System.out.println(" cantidad actual"+this.cinta.getCantidad());
        while (this.cinta.getCantidad()==this.cinta.getCantidadMaxima())
        {

            System.out.println("cinta llena");
            wait();
        }
        this.cinta.poner();
        notifyAll();
        return i++;
    }
}
