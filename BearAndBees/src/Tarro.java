import java.util.concurrent.Semaphore;

public class Tarro
{
    private String[] tarro;
    private Semaphore mutex;
    private Semaphore espacio;
    private int pActual;


    public Tarro(int cTarro)
    {
        this.mutex= new Semaphore(1,true);//puedo agregar.
        this.espacio=new Semaphore(cTarro,true);//si tengo espacio.
        this.tarro = new String[cTarro];
        for (int i = 0; i <cTarro; i++)
        {
            this.tarro[i]="_";
        }
        this.pActual=0;
    }

    public void sacar()
    {
        while (this.pActual==0)
        {
            try
            {
                System.out.println("el osos se duerme");
                notifyAll();

                wait();
            }
            catch (Exception e)
            {

            }
        }
        try
        {
            this.mutex.acquire();
            this.tarro[this.pActual-1]="_";
            for (int j = 0; j < 5; j++)
            {
                System.out.print(this.tarro[j]);
            }
            System.out.println(" ");
            this.pActual--;
            this.mutex.release();
            this.espacio.release();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public void poner(int id)
    {

        while(this.pActual>=5)
        {
            try
            {

                notify();

                wait();
            }
            catch (Exception e)
            {

            }

        }
        try
        {
            this.espacio.acquire();
            this.mutex.acquire();
            System.out.println("la abeja :"+id+" puso miel");
            for (int p= 0; p < 5; p++)
            {
                System.out.print(this.tarro[p]);
            }
            System.out.println(" ");
            this.tarro[pActual]="M";
            this.pActual++;
            this.mutex.release();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }






}
