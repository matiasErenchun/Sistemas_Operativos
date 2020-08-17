import java.util.ArrayList;
import java.util.Random;

public class GeneradorProgramas
{
    private Disco disco;
    private ColaProgramas  colaProgramas;
    private int programId;
    private int maxLargoPrograma;
    private Random random;
    

    public GeneradorProgramas(Disco disco, ColaProgramas colaProgramas, int largoMax)
    {
        this.disco = disco;
        this.colaProgramas = colaProgramas;
        this.programId=1;
        this.maxLargoPrograma=largoMax;
    }
    
    /*
    Recibe como parámetro la cantidad de programas que se desean simular, si el tamaño de
    un programa generado supera el espacio libre, el programa no se genera. Esto debido a
    que los tamaños son ALEATORIOS y el usuario decide la cantidad de programas a generar.
    
    Una vez se ha generado un programa, se carga al disco y se agrega a la Cola de Programas
    dependiendo de su Prioridad.
    */
    public void generarProgramas(int cantidadProgramas )
    {
        int largo;
        this.random= new Random(System.currentTimeMillis());
        int i=0;
        while (i<cantidadProgramas)
        {
            int prioridad= random.nextInt(11);
            if(prioridad<=8)//Todo programa que tenga prioridad de 8 se transforma en prioridad "normal"
            {
                prioridad=1;//Se establece la prioridad "normal"
            }
            largo= random.nextInt(this.maxLargoPrograma)+1;
            if((this.disco.getEspacioLibre()-largo)<0)
            {
                System.out.println("\n*****[AVISO]*****\nNo es posible generar un nuevo programa (Programa: "+this.programId+")\nMOTIVO: No hay espacio suficiente en el Disco");
            }
            else {

                Programa programa=new Programa(this.programId,largo,prioridad);
                this.disco.cargarPrograma(programa);
                this.colaProgramas.agregarPrograma(programa);

            }
            this.programId++;
            i++;
            random.setSeed(System.currentTimeMillis());//Se vuelve a generar otra semilla para aumentar la aleatoriedad
            

        }
    }
}
