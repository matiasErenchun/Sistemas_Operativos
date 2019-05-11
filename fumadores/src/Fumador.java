import java.util.Random;

public class Fumador extends Thread
{
    private int papel;
    private int tabaco;
    private int fosforo;
    private Random miRandom;
    private int id;
    private Mesa miMesa;

    public Fumador(int papel, int tabaco, int fosforo, int id,Mesa mesa)
    {
        this.papel = papel;
        this.tabaco = tabaco;
        this.fosforo = fosforo;
        this.miRandom = new Random(System.currentTimeMillis());
        this.id = id;
        this.miMesa=mesa;

    }

    @Override
    public void run()
    {
        while (true)
        {
            boolean resultado=this.miMesa.puedoFumar(this.papel,this.tabaco,this.fosforo);
                try{
                    this.miMesa.fumar(this.tabaco,this.papel,this.fosforo,this.id);
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }
}
