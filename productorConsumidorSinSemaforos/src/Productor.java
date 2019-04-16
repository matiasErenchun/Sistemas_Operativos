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


                i=this.producir(i);

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
        System.out.println("se produjo el elemento numero:"+i);
        notifyAll();
        return i++;
    }
}
