import java.util.ArrayList;

public class Multiplicador extends Thread
{
    public ArrayList<Double> mifila;
    public ArrayList<Double>miColumna;
    public Multiplicador(ArrayList<Double> fila,ArrayList<Double>columna)
    {
        this.mifila=fila;
        this.miColumna=columna;
    }

    @Override
    public void run()
    {

    }

    public ArrayList<Double> calcularFila()
    {
        ArrayList<Double>filaSalida=new ArrayList<>();

    }

    public Double calcularValor(int a)
    {
        Double aMultiplicar=this.mifila.get(a);


    }
}
