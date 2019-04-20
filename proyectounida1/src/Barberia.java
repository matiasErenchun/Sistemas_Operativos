public class Barberia
{
    private int sillasLibres;
    private int sillasTotales;
    private boolean barberoOcupado;
    private boolean sillaBarbero;
    private int tiempoAtension;
    private int clientesQueLlegaron;
    private int clientesTotales;

    public Barberia(int sillas,int clientes)
    {
        this.clientesTotales=clientes;
        this.clientesQueLlegaron=0;
        this.sillasLibres = sillas;
        this.sillasTotales=sillas;
        this.barberoOcupado=false;
        this.sillaBarbero=true;
        this.tiempoAtension=0;
    }

    public synchronized int getClientesTotales()
    {
        return clientesTotales;
    }
    public synchronized boolean quedanClientes()
    {
        if(this.getClientesTotales()<=this.getClientesQueLlegaron()&&this.nadieEnBarberia())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public synchronized int getClientesQueLlegaron()
    {
        return clientesQueLlegaron;
    }

    public synchronized void aumentarClientesQueLegaron()
    {
        this.clientesQueLlegaron++;
    }

    public synchronized int getTiempoAtension()
    {
        return tiempoAtension;
    }

    public synchronized void setTiempoAtension(int tiempoAtension)
    {
        this.tiempoAtension = tiempoAtension;
    }

    public synchronized void sentarse()
    {
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

    public synchronized boolean isBarberoOcupado()
    {
        return this.barberoOcupado;
    }

    public synchronized void setBarberoOcupado(boolean b)
    {
        this.barberoOcupado=b;
    }

    public synchronized boolean isSillaBarberoLibre()
    {
        return this.sillaBarbero;
    }

    public synchronized void setSillaBarbero(boolean b)
    {
        this.sillaBarbero=b;
    }

    public synchronized int getSillasTotales()
    {
        return this.sillasTotales;
    }

    public synchronized void sentarseSillaBarbero()
    {

        this.setBarberoOcupado(true);// el barbero comienza a atender y por ende esta ocupado
        this.setSillaBarbero(false);// la siya es ocupada por ende no esta libre
    }

    public synchronized void pararseSillaBarber()
    {

        this.setBarberoOcupado(false);//el barbero  termina de atender al leinte y queda libre porende no esta ocupado.
        this.setSillaBarbero(true);//la silla del barbero queda libre
    }

    public synchronized boolean nadieEnBarberia()
    {
        if(this.isSillaBarberoLibre()&&this.getSillasLibres()==this.getSillasTotales())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
