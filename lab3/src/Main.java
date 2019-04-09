import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    private static Lector lector;
    private static ArrayList<Proceso> misProcesos;
    private static Fifo fifo;
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        lector= new Lector("procesos.dat");
        misProcesos=lector.leerProcesos();
        fifo=new Fifo(misProcesos);
        for (Proceso p:misProcesos)
        {
            p.print();
        }
        fifo.ordenarProcesos();
        fifo.calcularTiempoDeCompletacion();

    }
}
