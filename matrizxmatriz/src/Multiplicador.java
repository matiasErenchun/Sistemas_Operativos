import java.util.ArrayList;

public class Multiplicador extends Thread
{

    private ArrayList<Double> mifila;
    private ArrayList<Double>miColumna;
    private ArrayList<Double>filaCalculada;
    public Multiplicador(ArrayList<Double> fila,ArrayList<Double>columna)
    {
        this.mifila=fila;
        this.miColumna=columna;
        this.filaCalculada=new ArrayList<>();
    }

    @Override
    public void run()
    {
        int i=0;
        while (i<this.miColumna.size())
        {
            Double aux=this.calcularValor(i);
            this.filaCalculada.add(aux);
            i++;
        }
    }
     public void print()
     {
         for (Double d:this.filaCalculada)
         {
             System.out.print(d+",");
         }
         System.out.println(" ");
     }

    public Double calcularValor(int a)
    {
        Double aux=new Double(0);
        Double aMultiplicar=this.mifila.get(a);
        for (Double d:this.miColumna)
        {
            aux+=(aMultiplicar*d);
        }

        return aux;


    }
}
