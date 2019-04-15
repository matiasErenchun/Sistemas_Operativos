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
        while (i<this.aProducir)
        {
            try
            {
                producir();
            }
            catch (Exception e)
            {
                System.out.println(e.getStackTrace());
            }

        }
    }

    public void producir()throws InterruptedException
    {
        while (this.cinta.getCantidad()==this.cinta.getCantidadMaxima())
        {
            wait();
        }
        this.cinta.poner();
        notifyAll();
    }
}
