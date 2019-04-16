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

                i=this.consumir(i);


            }catch (Exception e)
            {
                //System.out.println(e.getStackTrace());
            }


        }
        System.out.println("se consumieron: "+i);
    }

    public int consumir(int i)throws InterruptedException
    {

        while(this.cinta.getCantidad()==0)
        {


            System.out.println("cinta vacia");

            wait();
        }

        this.cinta.quitar();
        notifyAll();
        System.out.println("se consumio el elemento numero: "+i);
        return i++;
    }
}
