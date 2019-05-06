import java.util.concurrent.Semaphore;

public class Tarro
{
    private String[] tarro;
    private Semaphore mutex;
    private Semaphore espacio;


    public Tarro(int cTarro)
    {
        this.mutex= new Semaphore(1,true);//puedo agregar.
        this.espacio=new Semaphore(cTarro,true);//si tengo espacio.
        this.tarro = new String[cTarro];
    }

    public void sacar()
    {
        this.
    }

    public void poner(int id)
    {

    }



}
