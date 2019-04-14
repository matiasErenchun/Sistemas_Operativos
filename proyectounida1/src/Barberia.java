import java.util.ArrayList;

public class Barberia
{
    private int sillasLibres;
    private int sillasTotales;
    private int clientesEsperando;
    private Barbero miBarbero;

    public Barberia(int sillas)
    {
        this.sillasLibres = sillas;
        this.sillasTotales=sillas;
        this.clientesEsperando=0;
        this.miBarbero=new Barbero();
        this.miBarbero.run();
    }

    public synchronized void Atender(int id)
    {
        this.clientesEsperando--;
        this.sillasLibres++;
        this.miBarbero.atender(id);
        System.out.println("barberoa atiende a :"+id);
    }
    public synchronized void levantarseYSalir(int id)
    {
        this.miBarbero.setOcupado(false);
        System.out.println("El barbero Termino de atender a: "+id);
    }

    public synchronized int getSillasLibres()
    {
        return this.sillasLibres;
    }

    public synchronized int getSillasTotales()
    {
        return this.sillasTotales;
    }

    public synchronized int getClientesEsperando()
    {
        return this.clientesEsperando;
    }


    public synchronized void aumentarClientesEsperando()
    {
        this.sillasLibres--;
        this.clientesEsperando++;
    }

    public synchronized boolean todasLasSillasLibres()
    {
        if(this.getSillasTotales()-this.getSillasLibres()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean tengoSillasLibres()
    {
        if(this.getSillasTotales()-this.getSillasLibres()>0)
        {
            return true;
        }

        return false;
    }

    public synchronized boolean barberoOcupado()
    {
        return this.miBarbero.isOcupado();
    }

    public synchronized boolean barberoDormido()
    {
        return this.miBarbero.isDormido();
    }

}
