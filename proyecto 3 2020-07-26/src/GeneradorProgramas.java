import java.util.Random;

public class GeneradorProgramas
{
    private Disco disco;
    private ColaProgramas  colaProgramas;
    private int programId;
    private int maxLargoPrograma;

    public GeneradorProgramas(Disco disco, ColaProgramas colaProgramas, int largoMax)
    {
        this.disco = disco;
        this.colaProgramas = colaProgramas;
        this.programId=1;
        this.maxLargoPrograma=largoMax;
    }

    /*
    se le pasa como parametro la cantidad de progrmas que se desea generar, si al generar un programa
    el tamaño de este supera el espacio libre, el programa no se genera,
     esto es  ya que lso tamaños son aleatorios y el usuario puede ingresa cualquier numero de programas.

     una vez ggeenrado el programa este se carga al disco y se  agrega a la cola de programas
     segun corresponda a su prioridad.
     */
    public void generarProgramas(int cantidadProgramas )
    {
        Random random= new Random(System.currentTimeMillis());
        int i=0;
        while (i<cantidadProgramas)
        {
            int prioridad= random.nextInt(11);
            if(prioridad<=8)//con esto es para hacer que los programas sean en su mayoria programas normales
            {
                prioridad=1;//estos son lso programas normales
            }
            int largo= random.nextInt(this.maxLargoPrograma)+1;
            if((this.disco.getEspacioLibre()-largo)<0)
            {
                System.out.println("programa:"+this.programId+"no se creo, no cupia en el disco");
            }
            else {

                Programa programa=new Programa(this.programId,largo,prioridad);
                this.disco.cargarPrograma(programa);
                this.colaProgramas.agregarPrograma(programa);

            }
            this.programId++;
            i++;
            random.setSeed(System.currentTimeMillis());//otra semilla asi es mas random
        }

    }
}
