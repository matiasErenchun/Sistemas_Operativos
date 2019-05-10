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
            int i =0;
            while (i<5)
            {
                this.miTarro.sacar();
                i++;
            }

        }
    }
}
