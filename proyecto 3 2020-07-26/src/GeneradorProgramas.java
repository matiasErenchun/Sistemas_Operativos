import java.util.Random;

public class GeneradorProgramas
{
    private Disco disco;
    private ColaProgramas  colaProgramas;
    private int programId;
    private int maxLargoPrograma;
    private int maxTime;

    public GeneradorProgramas(Disco disco, ColaProgramas colaProgramas, int largoMax, int maxTime)
    {
        this.disco = disco;
        this.colaProgramas = colaProgramas;
        this.programId=1;
        this.maxLargoPrograma=largoMax;
        this.maxTime = maxTime;
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
            int largo= random.nextInt(this.maxLargoPrograma)+1;
            if((this.disco.getEspacioLibre()-largo)<0)
            {
                System.out.println("programa:"+this.programId+"no se creo, no cupia en el disco");
            }
            else {
                int time = random.nextInt(this.maxTime)+1;
                int id=this.programId;
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
