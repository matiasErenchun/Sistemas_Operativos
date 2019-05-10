public class Oso extends Thread
{
    private Tarro miTarro;
    public Oso(Tarro tarro)
    {
        this.miTarro=tarro;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                this.miTarro.comer();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
