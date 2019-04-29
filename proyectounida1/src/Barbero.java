import java.util.Random;

public class Barbero extends Thread
{

    private Random miRandom;
    private boolean barberoOcupado;
    private boolean sillaBarbero;
    private boolean barberoDormido;
    private int clientesTotales;
    private int clientesAtendidos;

    public Barbero(int clientesTotales)
    {
        this.clientesTotales=clientesTotales;
        this.miRandom=new Random(System.currentTimeMillis());
        this.barberoOcupado=false;
        this.sillaBarbero=true;
        this.barberoDormido=true;

    }

    public int getClientesTotales()
    {
        return clientesTotales;
    }

    public void setClientesTotales(int clientesTotales)
    {
        this.clientesTotales = clientesTotales;
    }

    public boolean isBarberoOcupado()
    {
        return barberoOcupado;
    }

    public void setBarberoOcupado(boolean barberoOcupado)
    {
        this.barberoOcupado = barberoOcupado;
    }

    public boolean isSillaBarbero()
    {
        return sillaBarbero;
    }

    public void setSillaBarbero(boolean sillaBarbero)
    {
        this.sillaBarbero = sillaBarbero;
    }

    public boolean isBarberoDormido()
    {
        return barberoDormido;
    }

    public void setBarberoDormido(boolean barberoDormido)
    {
        this.barberoDormido = barberoDormido;
    }

    /* metodo el cual resive la (int)id del cliente a atender y regresa
    el tiempo que demorara el barbero en atenderlo en forma d eun int*/
    public int atender(int id)throws InterruptedException
    {

        this.clientesAtendidos++;
        System.out.println("clientes atendidos "+this.clientesAtendidos);

        return this.miRandom.nextInt(500);
    }




    @Override
    public  void run()
    {

        while(clientesTotales>clientesAtendidos)
        {
           while(this.isBarberoDormido())
           {
               try {
                   wait();
               }
               catch (Exception e)
               {

               }

           }
        }

    }




}
