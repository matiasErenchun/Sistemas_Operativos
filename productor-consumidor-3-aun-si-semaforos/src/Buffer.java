public class Buffer
{
    private int cantidadMaxima;
    private int cantidadActual;
    private int permisoActual;//puede ser 1 para el consumidor y 0 para el productor
    private boolean permitirEntrarProductor;
    private boolean permitirEntrarConsumidor;

    public Buffer(int cantidadMaxima)
    {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual=0;
        this.permisoActual=0;
        this.permitirEntrarProductor=true;
        this.permitirEntrarConsumidor=false;
    }

    public int getCantidadMaxima()
    {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima)
    {
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual)
    {
        this.cantidadActual = cantidadActual;
    }

    public int getPermisoActual()
    {
        return permisoActual;
    }

    public void setPermisoActual(int permisoActual)
    {
        this.permisoActual = permisoActual;
    }

    public boolean isPermitirEntrarProductor()
    {
        return permitirEntrarProductor;
    }

    public void setPermitirEntrarProductor(boolean permitirEntrarProductor)
    {
        this.permitirEntrarProductor = permitirEntrarProductor;
    }

    public boolean isPermitirEntrarConsumidor()
    {
        return permitirEntrarConsumidor;
    }

    public void setPermitirEntrarConsumidor(boolean permitirEntrarConsumidor)
    {
        this.permitirEntrarConsumidor = permitirEntrarConsumidor;
    }

    public int agegar()
    {
        System.out.println("se agrego 1 a "+this.cantidadActual);
        return this.cantidadActual++;

    }

    public int sacar()
    {
        System.out.println("se saco 1 de "+this.cantidadActual);
        return this.cantidadActual--;
    }

    public boolean puedoSacar()
    {
        if(this.cantidadActual==0)
        {
            return false;
        }
        return true;
    }

    public boolean puedoColocar()
    {
        if(this.cantidadActual==this.cantidadMaxima)
        {
            return false;
        }
        return true;
    }
}
