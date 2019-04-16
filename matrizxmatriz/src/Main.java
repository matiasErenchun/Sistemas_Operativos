import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Main
{
    // por motivos de tiempo se incurrio en malas practicas :p
    private static Integer[][] matriz1={{1,2,3},{1,-1,-2},{2,-5,-6}};
    private static Integer[][] matriz2={{2,3,1},{-1,-2,4},{-2,4,5}};
    private static ArrayList<Multiplicador>misMultiplicadores;
    public static void main(String[] args)
    {
        misMultiplicadores=new ArrayList<>();
        for (int i = 0; i < matriz1.length; i++)
        {
            ArrayList<Double>fila=new ArrayList<>();
            ArrayList<Double>columna=new ArrayList<>();
            for (int j=0; j< matriz1.length; j++)
            {
                Integer auxFila=matriz1[i][j];
                Integer auxColumna=matriz2[j][i];
                fila.add(Double.parseDouble(auxFila.toString()));
                columna.add(Double.parseDouble(auxColumna.toString()));
            }
            Multiplicador miMultiplicador=new Multiplicador(fila,columna);
            misMultiplicadores.add(miMultiplicador);
        }
        for (Multiplicador mul:misMultiplicadores)
        {
            mul.start();
        }

        for (Multiplicador mul:misMultiplicadores)
        {
            mul.print();
        }



        System.out.println("Hello World!");// no lo quite porque me trae recuerdos
    }
}
