public class Consumidor extends Thread
{
    private int aProducir;
    private Cinta cinta;

    public Consumidor(int aProducir, Cinta cinta) {
        this.aProducir = aProducir;
        this.cinta=cinta;
    }

    @Override
    public void run() {
        int i=0;
        while(i<aProducir)
        {
            try
            {
                this.consumir();
            }catch (Exception e)
            {
                System.out.println(e.getStackTrace());
            }
            i++;
        }
        System.out.println("se consumieron: "+i);
    }

    public void consumir()throws InterruptedException
    {
        while(this.cinta.getCantidad()==0)
        {
            wait();
        }
        this.cinta.quitar();
        notifyAll();
    }
}
