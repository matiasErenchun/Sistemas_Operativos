public class Diler extends Thread
{
    private Mesa miMesa;
    public Diler(Mesa mesa)
    {
        this.miMesa=mesa;
    }

    @Override
    public void run()
    {
       while (true)
       {
           try{
               this.miMesa.agregarIngredientes();
           }
           catch (InterruptedException e)
           {
               e.printStackTrace();
           }

       }
    }
}
