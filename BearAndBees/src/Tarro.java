import java.util.concurrent.Semaphore;

public class Tarro
{
    private String[] tarro;
    private Semaphore mutex;
    private Semaphore espacio;
    private Semaphore vasio;
    private int pActual;
    private boolean puedoPoner;


    public Tarro(int cTarro)
    {
        this.mutex= new Semaphore(1,true);//puedo agregar.
        this.espacio=new Semaphore(cTarro,true);//si tengo espacio.
        this.vasio=new Semaphore(1,true);
        this.tarro = new String[cTarro];
        for (int i = 0; i <cTarro; i++)
        {
            this.tarro[i]="_";
        }
        this.pActual=0;
        this.puedoPoner=true;
    }



    public void comer()
    {
        int i=this.tarro.length-1;
        while(i>=0)
        {
            try
            {
                this.sacar(i);
                i--;
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.pActual=0;
    }
    public void sacar(int index)throws InterruptedException
    {
        this.mutex.acquire();
        this.tarro[index]="_";
        for (int j = 0; j < this.tarro.length ; j++)
        {
            System.out.print(this.tarro[j]);
        }
        System.out.println("");
        this.mutex.release();
        this.espacio.release();
    }

    public void poner(int id)throws InterruptedException
    {
            this.espacio.acquire();
            this.mutex.acquire();
            System.out.println("sem len "+this.espacio.getQueueLength());
            System.out.println("actual "+this.pActual);
            this.tarro[this.pActual]="M";
            System.out.println("abeja "+id+" puso un tarro");
            for (int j = 0; j < this.tarro.length ; j++)
            {
                System.out.print(this.tarro[j]);
            }
            System.out.println("");
            this.pActual++;
            this.mutex.release();

    }

}
