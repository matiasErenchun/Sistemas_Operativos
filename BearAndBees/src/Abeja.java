public class Abeja extends Thread
{
    private int id;
    private int entregados;
    private Tarro miTarro;

    public Abeja(int id,Tarro tarro)
    {

        this.id=id;
        this.entregados=0;
        this.miTarro=tarro;
    }

    @Override
    public void run()
    {
        while(this.entregados<2)
        {
            try
            {
                this.miTarro.poner(this.id);
                this.entregados++;
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }



        }

        System.out.println(" la abeja :"+this.id+" se fue a dormir");
    }
}
