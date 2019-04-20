import java.util.Random;

public class Barbero extends Thread
{
    private Barberia miBarberia;
    private Random miRandom;

    public Barbero(Barberia miBarberia)
    {
        this.miRandom=new Random(System.currentTimeMillis());
        this.miBarberia = miBarberia;
    }

    @Override
    public  void run()
    {


            while (this.miBarberia.nadieEnBarberia())
            {
                try
                {
                    wait();
                } catch (Exception e)
                {
                    //e.printStackTrace();
                }
            }
            int tiempoAtencion = miRandom.nextInt(100);
            this.miBarberia.setTiempoAtension(tiempoAtencion);
            try
            {
                sleep(tiempoAtencion);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


    }


}
