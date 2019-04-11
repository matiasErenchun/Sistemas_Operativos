public abstract class ComparadorSup implements Comparable<Proceso>
{

    public int compareTo(Proceso proceso1, Proceso proceso2)
    {
        if(proceso1.getTiempoDeLlegada()-proceso2.getTiempoDeLlegada()==0)
        {
            return proceso1.getTiempoEnCPU()-proceso2.getTiempoEnCPU();
        }
        else
        {
            return proceso1.getTiempoDeLlegada()-proceso2.getTiempoDeLlegada();
        }
    }
}
