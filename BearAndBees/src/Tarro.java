import java.util.concurrent.Semaphore;

public class Tarro
{
    private String[] tarro;
    private Semaphore mutex;
    private Semaphore espacio;
    private Semaphore puedoComer;
    private int pActual;
    private boolean puedoPoner;


    public Tarro(int cTarro)
    {
        this.mutex= new Semaphore(1,true);//puedo agregar.
        this.espacio=new Semaphore(cTarro,true);//si tengo espacio.
        this.puedoComer=new Semaphore(0,true);
        this.tarro = new String[cTarro];
        for (int i = 0; i <cTarro; i++)
        {
            this.tarro[i]="_";
        }
        this.pActual=0;
        this.puedoPoner=true;
    }



    public void comer()throws InterruptedException
    {
        this.puedoComer.acquire();
        this.mutex.acquire();
        int i=this.tarro.length-1;
        while(i>=0)
        {

                this.sacar(i);
                i--;
        }
        this.pActual=0;
        this.mutex.release();
    }
    public void sacar(int index)
    {

        this.tarro[index]="_";
        System.out.println(" el oso saco un tarro");
        for (int j = 0; j < this.tarro.length ; j++)
        {
            System.out.print(this.tarro[j]);
        }
        System.out.println("");
        this.pActual--;
        this.espacio.release();

    }

    public void poner(int id)throws InterruptedException
    {
            this.espacio.acquire();
            this.mutex.acquire();
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
            if(this.pActual==this.tarro.length)
            {
                this.puedoComer.release();
            }

    }

}
