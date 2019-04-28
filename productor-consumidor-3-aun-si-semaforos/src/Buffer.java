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
        return this.cantidadActual++;
    }

    public int sacar()
    {
        return this.cantidadActual--;
    }
}
