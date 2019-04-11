public class Proceso implements Comparable<Proceso>
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
            return this.getTiempoDeLlegada()-proceso.getTiempoDeLlegada();
    }

    public void print()
    {
        System.out.println("tiempo en cpu "+this.getTiempoEnCPU()+" tiempo de llgada "+this.tiempoDeLlegada+" prioridad "+this.prioridad);
    }

}
