public class Cinta
{
    private int cantidad;
    private int cantidadMaxima;

    public Cinta(int cantidad) {
        this.cantidad = 0;
        this.cantidadMaxima=cantidad;
    }

    public void quitar()
    {
        this.cantidad--;
    }

    public void poner()
    {
        this.cantidad++;
    }

    public int getCantidad()
    {
        return this.cantidad;
    }

    public int getCantidadMaxima()
    {
        return this.cantidadMaxima;
    }
}
