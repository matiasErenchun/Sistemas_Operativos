public class Proceso
{
    private int tiempoEnCPU;
    private int tiempoDeLlegada;
    private int prioridad;

    public Proceso(int tiempoEnCPU, int tiempoDeLlegada, int prioridad)
    {
        this.tiempoEnCPU = tiempoEnCPU;
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.prioridad = prioridad;
    }

    public int getTiempoEnCPU()
    {
        return this.tiempoEnCPU;
    }

    public int getTiempoDeLlegada()
    {
        return this.tiempoDeLlegada;
    }

    public int getPrioridad()
    {
        return this.prioridad;
    }


    public int compareTo(Proceso proceso)
    {
        if (this.getTiempoDeLlegada()< proceso.getTiempoDeLlegada())
        {
            return -1;
        }
        else
        {
            if (this.getTiempoDeLlegada()==proceso.getTiempoDeLlegada())
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

    }

}
