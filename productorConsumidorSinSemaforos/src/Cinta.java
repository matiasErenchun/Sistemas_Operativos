public class Cinta
{
    private int cantidad;
    private int producidos;
    private int cantidadMaxima;

    public Cinta(int cantidad) {
        this.cantidad = 0;
        this.producidos=0;
        this.cantidadMaxima=cantidad;
    }

    public synchronized void quitar()
    {
        this.producidos++;
        this.cantidad--;
    }

    public synchronized void poner()
    {
        this.cantidad++;
    }

    public synchronized int getCantidad()
    {
        return this.cantidad;
    }

    public synchronized int getCantidadMaxima()
    {
        return this.cantidadMaxima;
    }

    public synchronized int getProducidos()
    {
        return this.producidos;
    }

    public synchronized void sumar1()
    {
        this.producidos++;
    }
}
