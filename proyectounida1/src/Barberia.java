public class Barberia
{
    private int sillasLibres;
    private int sillasTotales;
    private int clientesQueLlegaron;
    private int clientesTotales;
    private int idActual;
    private Barbero miBarbero;

    public Barberia(int sillas,int clientes,Barbero barbero)
    {
        this.miBarbero=barbero;
        this.clientesTotales=clientes;
        this.clientesQueLlegaron=0;
        this.sillasLibres = sillas;
        this.sillasTotales=sillas;

    }

    public synchronized void despertarBarbero()throws InterruptedException
    {
        if(this.miBarbero.isBarberoDormido())
        {

                notifyAll();
        }
    }

    public synchronized boolean isBarberoDormido()
    {
        return this.miBarbero.isBarberoDormido();
    }





    public synchronized int getClientesTotales()
    {
        return clientesTotales;
    }

    public synchronized int getClientesQueLlegaron()
    {
        return clientesQueLlegaron;
    }

    public synchronized void aumentarClientesQueLegaron()
    {
        this.clientesQueLlegaron++;
    }


    public synchronized void sentarse(int id)
    {
        System.out.println("se sento a esperar "+id);

        this.sillasLibres--;
    }

    public synchronized void pararse()
    {
        this.sillasLibres++;
    }

    public synchronized int getSillasLibres()
    {
        return this.sillasLibres;
    }


    public synchronized int getSillasTotales()
    {
        return this.sillasTotales;
    }

    public synchronized int sentarseSillaBarbero(int id)throws InterruptedException
    {

        while (this.miBarbero.isBarberoOcupado())
        {
            wait();
        }
        System.out.println("se sento en la silla del barbero:"+id);
        this.pararse();
        this.miBarbero.setBarberoOcupado(true);
        this.miBarbero.setSillaBarbero(false);
        int aux=this.miBarbero.atender(id);
        return aux;

    }

    public synchronized void pararseSillaBarber(int id)throws InterruptedException
    {

        this.miBarbero.setBarberoOcupado(false);//el barbero  termina de atender al leinte y queda libre porende no esta ocupado.
        this.miBarbero.setSillaBarbero(true);//la silla del barbero queda libre
        System.out.println("se termino de atender a :"+id);
        System.out.println("se fue feliz " +id);
        notify();

    }

    public synchronized boolean nadieEnBarberia()
    {
        if(this.getSillasTotales()==this.getSillasLibres()&& this.miBarbero.isBarberoOcupado()&&this.miBarbero.isSillaBarbero())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
