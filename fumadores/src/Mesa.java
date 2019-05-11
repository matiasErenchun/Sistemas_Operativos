
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Mesa
{
    private Semaphore papel;
    private Semaphore tabaco;
    private Semaphore fosforo;
    private Semaphore puedoAgregar;
    private Semaphore mutexMesa;
    private Random miRandom;



    public Mesa() {
        this.papel = new Semaphore(0,true);
        this.tabaco = new Semaphore(0,true);;
        this.fosforo = new Semaphore(0,true);;
        this.puedoAgregar = new Semaphore(1,true);;
        this.mutexMesa = new Semaphore(1,true);;
        this.miRandom= new Random(System.currentTimeMillis());
    }

    public void agregarIngredientes()throws InterruptedException
    {
        this.puedoAgregar.acquire();
        this.mutexMesa.acquire();

        int caso= this.miRandom.nextInt(3)+1;

        switch (caso)
        {
            case 1:
                this.fosforo.release();
                this.papel.release();
                System.out.println("se agrego  fosforo");
                System.out.println("se agrego  papel");

                break;
            case 2:
                this.fosforo.release();
                this.tabaco.release();
                System.out.println("se agrego  fosforo");
                System.out.println("se agrego  tabaco");
                break;

            default:
                this.papel.release();
                this.tabaco.release();
                System.out.println("se agrego  papel");
                System.out.println("se agrego  tabaco");
        }

        this.mutexMesa.release();//liberamos al mesa.


    }

    public void fumar(int quieroTabaco, int quieroPapel, int quieroFosforo, int id)throws InterruptedException
    {
        this.mutexMesa.acquire();
        if(this.puedoFumar(quieroPapel,quieroTabaco,quieroFosforo))
        {
            if(quieroFosforo==0)
            {

                this.fosforo.acquire();

            }
            if(quieroPapel==0)
            {

                this.papel.acquire();

            }
            if(quieroTabaco==0)
            {

                this.tabaco.acquire();

            }

            this.terminoFumar(id);
        }
        this.mutexMesa.release();
    }

    public void terminoFumar(int id)
    {
        System.out.println("termino de fumar :"+id);
        this.puedoAgregar.release();
    }

    public boolean puedoFumar(int bPapel, int bTabaco, int bFosforo)
    {
        if(bPapel==0 && bTabaco==0)
        {
            if(this.tabaco.availablePermits()==1 && this.papel.availablePermits()==1 )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(bPapel==0 && bFosforo==0)
            {
                if (this.papel.availablePermits()==1 && this.fosforo.availablePermits()==1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(bFosforo==0 && bTabaco==0)
                {
                    if (this.fosforo.availablePermits()==1&& this.tabaco.availablePermits()==1)
                    {
                        return true;
                    }
                }
                return false;
            }
        }
    }

}
