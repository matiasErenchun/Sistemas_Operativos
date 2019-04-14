public class Barbero
{
    private String id;
    private boolean ocupado;

    public Barbero()
    {
        this.id="Barbero";
        this.ocupado=false;
    }

    public boolean isOcupado()
    {
        return ocupado;
    }

    public void setOcupado(boolean ocupado)
    {
        this.ocupado = ocupado;
    }
}
