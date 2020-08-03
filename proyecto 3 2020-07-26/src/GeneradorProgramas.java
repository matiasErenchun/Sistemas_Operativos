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
            int largo= random.nextInt(this.maxLargoPrograma+1);
            while (largo<1)//para evitar largo = 0, ya que unn programa sin instrucciones no tiene logica
            {
                largo= random.nextInt(this.maxLargoPrograma+1);
            }
            int id=this.programId;
            Programa programa=new Programa(this.programId,largo,prioridad);
            this.disco.cargarPrograma(programa);
            this.colaProgramas.agregarPrograma(programa);
            this.programId++;
            i++;
            random.setSeed(System.currentTimeMillis());//otra semilla asi es mas random
        }

    }
}
